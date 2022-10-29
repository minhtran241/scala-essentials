package com.minhtran241.scala.oop.files

import com.minhtran241.scala.oop.filesystem.FilesystemException

class File(override val parentsPath: String, override val name: String, contents: String)
  extends DirEntry(parentsPath, name) {
  override def asDirectory: Directory =
    throw new FilesystemException("A file cannot be converted to a directory.")

  override def asFile: File = this

  override def isDirectory: Boolean = false

  override def isFile: Boolean = true

  override def getType: String = "File"
}

object File {

  def empty(parentsPath: String, name: String): File =
    new File(parentsPath, name, "")
}
