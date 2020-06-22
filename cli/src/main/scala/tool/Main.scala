package tool

import java.nio.file.Paths

import tool.Config.{DocumentPath, DocumentType, DocumentsToGenerate, TargetPackageName, TargetProjectRootPath}

object Main {

  def main(args: Array[String]): Unit = {

    args.toList match {
      case rootPath :: docPath :: Nil =>
        val targetProjectRootPath = TargetProjectRootPath(Paths.get(rootPath))
        val targetPackageNames = Seq("example.domain").map(TargetPackageName) // TODO
        val documentsToGenerate = DocumentsToGenerate(Seq(DocumentType.DomainObjectTable))
        val documentPath = DocumentPath(Paths.get(docPath)) // TODO
        val config = Config(targetProjectRootPath, targetPackageNames, documentsToGenerate, documentPath)
        Zugen.run(config)
      case els =>
        sys.error(s"Expected <rootPath>, obtained $els")
    }
  }
}
