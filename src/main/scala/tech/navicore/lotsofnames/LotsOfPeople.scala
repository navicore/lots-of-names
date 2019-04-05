package tech.navicore.lotsofnames

import scala.io.Source
import scala.util.hashing.MurmurHash3

object LotsOfPeople {

  val people: Array[String] = Source.fromResource("people.txt").getLines().toArray
  val middle: Array[String] = Source.fromResource("middle.txt").getLines().toArray
  val things: Array[String] = Source.fromResource("things.txt").getLines().toArray

  def apply(source: String): String = {

    val hash = MurmurHash3.stringHash(source)
    val even = hash % 2
    val (first, middleO, last) = even match {
      case 0 => (people, None, things)
      case 1 => (things, None, people)
      case -1 => (things, Some(middle), people)
    }
    val f = Math.abs(hash % first.length)
    val m = Math.abs(hash % middle.length)
    val l = Math.abs(hash % last.length)
    middleO match {
      case Some(_) =>
        first(f) + ' ' + middle(m) + ' ' +  last(l)
      case _ =>
        first(f) + ' ' +  last(l)
    }

  }

}
