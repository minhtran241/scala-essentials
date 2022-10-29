package com.minhtran241.scala.oop.cmd

import com.minhtran241.scala.oop.filesystem.State

trait Command {

  def apply(state: State): State

}

object Command {
  val MKDIR = "mkdir"
  val LS = "ls"
  val PWD = "pwd"
  val TOUCH = "touch"

  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state
  }

  def incompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State =
      state.setMessage(s"$name: incomplete command.")
  }

  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")
    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if (tokens(0).equals(MKDIR)) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Mkdir(tokens(1))
    } else if (tokens(0).equals(LS)) {
      new Ls
    } else if (tokens(0).equals(PWD))  {
      new Pwd
    } else if (tokens(0).equals(TOUCH)) {
      if (tokens.length < 2) incompleteCommand(TOUCH)
      else new Touch(tokens(1))
    }
    else new UnknownCommand
  }
}
