package com.minhtran241.scala.oop.cmd

import com.minhtran241.scala.oop.files.{DirEntry, Directory}
import com.minhtran241.scala.oop.filesystem.State

class Mkdir(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)

  override def checkIllegal(name: String): Boolean =
    name.contains(".")
}
