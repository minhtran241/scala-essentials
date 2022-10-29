package com.minhtran241.scala.oop.cmd
import com.minhtran241.scala.oop.filesystem.State

class Pwd extends Command{
  override def apply(state: State): State =
    state.setMessage(state.wd.path)
}
