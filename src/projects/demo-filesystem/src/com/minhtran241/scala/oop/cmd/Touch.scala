package com.minhtran241.scala.oop.cmd
import com.minhtran241.scala.oop.files.{DirEntry, File}
import com.minhtran241.scala.oop.filesystem.State

class Touch(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)

  override def checkIllegal(name: String): Boolean = false
}
