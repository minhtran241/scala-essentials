package com.minhtran241.scala.oop.files

import com.minhtran241.scala.oop.filesystem.FilesystemException

import scala.annotation.tailrec

class Directory(
                 override val parentsPath: String,
                 override val name: String,
                 val contents: List[DirEntry]
               )
  extends DirEntry(parentsPath, name) {

  def hasEntry(name: String): Boolean =
    findEntry(name) != null

  def getAllFoldersInPath: List[String] =
    path.substring(1).split(Directory.SEPERATOR).toList.filter(e => e.nonEmpty)
  // /a/b/c/d => List["a", "b", "c", "d"]

  def findDescendant(path: List[String]): Directory =
    if (path.isEmpty) this
    else findEntry(path.head).asDirectory.findDescendant(path.tail)

  def addEntry(newEntry: DirEntry): Directory =
    new Directory(parentsPath, name, contents :+ newEntry)

  def findEntry(entryName: String): DirEntry = {
    @tailrec
    def findEntryHelper(name: String, contentList: List[DirEntry]): DirEntry = {
      if (contentList.isEmpty) null
      else if (contentList.head.name.equals(name)) contentList.head
      else findEntryHelper(name, contentList.tail)
    }

    findEntryHelper(entryName, contents)
  }

  def replaceEntry(entryName: String, newEntry: DirEntry): Directory =
    new Directory(parentsPath, name, contents.filter(e => !e.name.equals(entryName)) :+ newEntry)

  def isRoot: Boolean = parentsPath.isEmpty

  def asDirectory: Directory = this

  def asFile: File = throw new FilesystemException("A directory cannot be converted to a file.")

  override def isDirectory: Boolean = true

  override def isFile: Boolean = false

  override def getType: String = "Directory"

}

object Directory {
  val SEPERATOR = "/"
  val ROOT_PATH = "/"

  def ROOT: Directory = Directory.empty("", "")

  def empty(parentsPath: String, name: String): Directory =
    new Directory(parentsPath, name, List())
}
