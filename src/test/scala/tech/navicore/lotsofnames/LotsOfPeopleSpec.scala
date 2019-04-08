package tech.navicore.lotsofnames

import java.util.UUID

import org.scalatest._

class LotsOfPeopleSpec extends FlatSpec with Matchers {

  "what is" should "hash" in {

    val data = "1010020202993993938484885858577583939392929393AAKDKDKDKDKDKDKDKDKDD"
    val id = LotsOfPeople(data)
    assert(id == "Bentley Rizvi")

    val uuid = "a8f0bb4c-e921-46a7-af32-268c9fdd15c2"
    val id2 = LotsOfPeople(uuid)
    assert(id2 == "Malathion Avery Wobbe")

    val uuid3 = "a8f0bb4c-e921-46a7-af32-268c9fdd15c3"
    val id3 = LotsOfPeople(uuid3)
    assert(id3 == "Winkydink Scagliotti")

  }

  "collisions" should "not happen too often" in {

    val uuids = for (_ <- 1 to 100000) yield UUID.randomUUID()

    val ids = uuids.map(uuid => LotsOfPeople(uuid.toString))

    val set = ids.toSet

    assert(ids.length - set.size < 20, s"--- too many dupes: ${ids.length - set.size}")

    set.slice(0, 20).foreach(println)

    println(s"collisions: ${ids.length - set.size}")
    //set.foreach(println)

  }

}
