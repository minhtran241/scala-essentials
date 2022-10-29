package com.minhtran241.scala.oop.files

abstract class DirEntry(val parentsPath: String, val name: String) {

  def path: String = parentsPath + Directory.SEPERATOR + name

  def asDirectory: Directory

  def getType: String
}
