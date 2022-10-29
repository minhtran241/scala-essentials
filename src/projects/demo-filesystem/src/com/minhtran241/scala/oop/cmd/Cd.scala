package com.minhtran241.scala.oop.cmd

import com.minhtran241.scala.oop.files.{DirEntry, Directory}
import com.minhtran241.scala.oop.filesystem.State

import scala.annotation.tailrec

class Cd(dir: String) extends Command {
  override def apply(state: State): State = {

    // 1. find root
    val root = state.root
    val wd = state.wd

    // 2. find the absolute path of the directory I want to cd to
    val absolutePath =
      if (dir.startsWith(Directory.SEPERATOR)) dir
      else if (wd.isRoot) wd.path + dir
      else wd.path + Directory.SEPERATOR + dir

    // 3. find the directory to cd to, given the path
    val destinationDirectory = doFindEntry(root, absolutePath)

    // 4. change the state given the new directory
    if (destinationDirectory == null || !destinationDirectory.isDirectory)
      state.setMessage(s"$dir: no such directory.")
    else
      State(root, destinationDirectory.asDirectory)
  }

  def doFindEntry(root: Directory, absolutePath: String): DirEntry = {
    @tailrec
    def findEntryHelper(currentDirectory: Directory, path: List[String]): DirEntry =
      if (path.isEmpty || path.head.isEmpty) currentDirectory
      else if (path.tail.isEmpty) currentDirectory.findEntry(path.head)
      else {
        val nextDir = currentDirectory.findEntry(path.head)
        if (nextDir == null || !nextDir.isDirectory) null
        else findEntryHelper(nextDir.asDirectory, path.tail)
      }

    // 1. tokens
    val tokens: List[String] =
      absolutePath.substring(1).split(Directory.SEPERATOR).toList

    // 2. navigate to the correct entry
    findEntryHelper(root, tokens)
  }
}
