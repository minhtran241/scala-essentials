package com.minhtran241.scala.oop.files

abstract class DirEntry(val parentsPath: String, val name: String) {

  def path: String = {
    val separatorIfNecessary =
      if (Directory.ROOT_PATH.equals(parentsPath)) ""
      else Directory.SEPARATOR

    parentsPath + separatorIfNecessary + name
  }

  def asDirectory: Directory

  def asFile: File

  def isDirectory: Boolean

  def isFile: Boolean

  def getType: String
}
