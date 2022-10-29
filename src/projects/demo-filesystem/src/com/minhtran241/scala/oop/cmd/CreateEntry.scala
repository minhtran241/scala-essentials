package com.minhtran241.scala.oop.cmd

import com.minhtran241.scala.oop.files.{DirEntry, Directory}
import com.minhtran241.scala.oop.filesystem.State

abstract class CreateEntry(name: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage(s"Entry $name already exists.")
    } else if (name.contains(Directory.SEPERATOR)) {
      // mkdir something/somethingElse -> forbid
      state.setMessage(s"$name must not contain separators.")
    } else if (checkIllegal(name)) {
      state.setMessage(s"$name: illegal entry name.")
    } else {
      doCreateEntry(state)
    }
  }

  def checkIllegal(name: String): Boolean

  def doCreateEntry(state: State): State = {
    def updateStructure(
                         currentDirectory: Directory,
                         path: List[String],
                         newEntry: DirEntry
                       ): Directory = {
      if (path.isEmpty) currentDirectory.addEntry(newEntry)
      else {
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(
          oldEntry.name,
          updateStructure(oldEntry, path.tail, newEntry)
        )
      }
    }

    val wd = state.wd

    // 1. all the directories in the fullPath
    val allDirsInPath = wd.getAllFoldersInPath

    // 2. create new directory entry in the wd
    val newEntry: DirEntry = createSpecificEntry(state)

    // 3. update the whole directory structure starting from the root
    // (the directory structure is IMMUTABLE)
    val newRoot = updateStructure(state.root, allDirsInPath, newEntry)

    // 4. find new working directory INSTANCE given wd's full path, in the NEW directory structure
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)
  }

  def createSpecificEntry(state: State): DirEntry
}
