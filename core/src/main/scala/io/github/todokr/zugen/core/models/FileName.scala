package io.github.todokr.zugen.core.models

/**
  * ソースコードのファイル名
  */
case class FileName(value: String) extends AnyVal {

  override def toString: String = value
}