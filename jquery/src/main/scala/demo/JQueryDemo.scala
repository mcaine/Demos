package demo

import org.scalajs.dom.html.{Button, Label}
import org.scalajs.dom.document
import org.scalajs.dom.raw.Element
import typings.jquery.{JQueryEventObject, JQuery_, mod => $}
import typings.jqueryui.jqueryuiRequire

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

object JQueryDemo {
  @JSImport("jqueryui/jquery-ui.css", JSImport.Namespace)
  @js.native
  object JqueryUiCss extends js.Object

  /* fake interface augmentation. This is done automatically in typescript. */
  def isJQueryUi[T](x: JQuery_[T]): typings.jqueryui.JQuery =
    x.asInstanceOf[typings.jqueryui.JQuery]

  def main(args: Array[String]): Unit = {
    // trigger loading of global library and CSS
    jqueryuiRequire
    JqueryUiCss

    val $container: JQuery_[Element] = $(document.getElementById("container"))

    var counter = 1
    val renderLabel: js.Function1[ /* event */ JQueryEventObject, scala.Unit] = eo => {
      counter += 1
      $[Label]("#label").text(s"Value is $counter")
    }

    $[Button]("#button")
      .text("bumpit")
      .on("click", renderLabel)

    isJQueryUi($("#accordion")).accordion()
  }
}
