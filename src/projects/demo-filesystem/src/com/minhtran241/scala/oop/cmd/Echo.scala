package com.minhtran241.scala.oop.cmd

import com.minhtran241.scala.oop.files.{Directory, File}
import com.minhtran241.scala.oop.filesystem.State

import scala.annotation.tailrec

class Echo(args: Array[String]) extends Command {
  override def apply(state: State): State = {
    /*
    if no args, state
    else if just one arg, print to console
    else if multiple args
    {
      operator = next to last argument
      if >
        echo oto file (may create a file if not there)
      if >>
        append to a file
      else
        just echo everything to console
    }
     */
    if (args.isEmpty) state
    else if (args.length == 1) state.setMessage(args(0))
    else {
      val operator = args(args.length - 2)
      val filename = args(args.length - 1)
      val content = createContent(args, args.length - 2)

      if (operator.equals(">>"))
        doEcho(state, content, filename, append = true)
      else if (operator.equals(">"))
        doEcho(state, content, filename, append = false)
      else
        state.setMessage(createContent(args, args.length))
    }
  }

  def getRootAfterEcho(
                        currentDirectory: Directory,
                        path: List[String],
                        content: String,
                        append: Boolean): Directory = {

    /*
    if path is empty, then fail (currentDirectory)
    else if no more things to explore = path.tail.isEmpty
      find the file to create/add content to
      if file not found, create file
      else if the entry is actually a directory, then fail
      else
        replace or append content to the file
        replace the entry with the filename with the NEW file
     else
      find the next directory to navigate
      call gRAE recursively on that

      if recursive call failed, fail
      else replace entry with the NEW directory after the recursive call
     */
    if (path.isEmpty) currentDirectory
    else if (path.tail.isEmpty) {
      val dirEntry = currentDirectory.findEntry(path.head)
      if (dirEntry == null)
        currentDirectory.addEntry(
          new File(currentDirectory.path, path.head, content)
        )
      else if (dirEntry.isDirectory) currentDirectory
      else if (append) currentDirectory.replaceEntry(
        path.head, dirEntry.asFile.appendContent(content)
      )
      else currentDirectory.replaceEntry(
        path.head, dirEntry.asFile.setContent(content)
      )
    }
    else {
      val nextDirectory: Directory = currentDirectory.findEntry(path.head).asDirectory
      val newNextDirectory = getRootAfterEcho(nextDirectory, path.tail, content, append)

      if (newNextDirectory == nextDirectory) currentDirectory
      else currentDirectory.replaceEntry(path.head, newNextDirectory)
    }
  }

  def doEcho(state: State, content: String, filename: String, append: Boolean): State = {
    if (filename.contains(Directory.SEPARATOR))
      state.setMessage("Echo: filename must not contain separators.")
    else {
      val newRoot: Directory =
        getRootAfterEcho(
          state.root,
          state.wd.getAllFoldersInPath :+ filename,
          content,
          append = append
        )
      if (newRoot == state.root)
        state.setMessage(s"$filename: no such file.")
      else
        State(newRoot, newRoot.findDescendant(state.wd.getAllFoldersInPath))
    }
  }

  // topIndex NON-INCLUSIVE
  def createContent(args: Array[String], topIndex: Int): String = {
    @tailrec
    def createContentHelper(currentIndex: Int, accumulator: String): String = {
      if (currentIndex >= topIndex) accumulator
      else createContentHelper(
        currentIndex + 1,
        s"$accumulator ${args(currentIndex)}"
      )
    }

    createContentHelper(0, "")
  }
}
