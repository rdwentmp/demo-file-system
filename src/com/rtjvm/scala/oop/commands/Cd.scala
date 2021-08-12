package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.{DirEntry, Directory}
import com.rtjvm.scala.oop.filesystem.State

class Cd(dir: String) extends Command {

  override def apply(state: State): State = {

    /*
    cd  /something/smth/.../
    cd  a/b/c/ -relative to the current working directory

    cd ..
    cd .
    cd a/./../a/
     */

    // 1. find root
    val root = state.root
    val wd = state.wd

    // 2. find thew absolute path of the directory I want to c to
    val absolutePath =
      if (dir.startsWith(Directory.SEPARATOR)) dir
      else if (wd.isRoot) wd.path + dir
      else wd.path + Directory.SEPARATOR + dir

    // 3. find the directory to cd to, given the path
    val destinationDirectory = doFindEntry(root, absolutePath)

    // 4. change the state given the new directory
    if (destinationDirectory == null || destinationDirectory.isDirectory)
      state.setMessage(dir + ": no such directory")
  }
  def doFindEntry(root: Directory, path: String): DirEntry = ???

}
