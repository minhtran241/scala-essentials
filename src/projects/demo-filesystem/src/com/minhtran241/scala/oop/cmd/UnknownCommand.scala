package com.minhtran241.scala.oop.cmd
import com.minhtran241.scala.oop.filesystem.State

class UnknownCommand extends Command {

  override def apply(state: State): State =
    state.setMessage("Command not found.")

}
