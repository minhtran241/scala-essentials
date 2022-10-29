package com.minhtran241.scala.oop.cmd
import com.minhtran241.scala.oop.files.DirEntry
import com.minhtran241.scala.oop.filesystem.State

class Ls extends Command {
  override def apply(state: State): State = {
    val contents = state.wd.contents
    val lsOutput = createLsOutput(contents)
    state.setMessage(lsOutput)
  }

  def createLsOutput(contents: List[DirEntry]): String = {
    if (contents.isEmpty) ""
    else {
      val entry = contents.head
      s"${entry.name}[${entry.getType}]\n" + createLsOutput(contents.tail)
    }
  }
}
