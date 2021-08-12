package com.rtjvm.scala.oop.files

import com.rtjvm.scala.oop.filesystem.FilesystemException

class File(override val parentPath: String, override val name: String, contents: String)
  extends DirEntry(parentPath, name) {

    def asDirectory: Directory =
      throw new FilesystemException("A file can not be converted to a directory")

    def asFile: File = this

    def getType: String = "file"
}
object File {

}
