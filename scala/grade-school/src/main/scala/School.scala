import scala.collection.immutable.ListMap

class School {
  type DB = Map[Int, Seq[String]]

  private var roster: DB = Map.empty

  def add(name: String, g: Int) = {roster = roster.updated(g, grade(g) :+ name)}

  def db: DB = roster

  def grade(g: Int): Seq[String] = roster.getOrElse(g, Seq.empty[String])

  def sorted: DB = ListMap(roster.map{case (g, seq) => (g -> seq.sorted)}.toSeq.sortBy(_._1):_*)
}
