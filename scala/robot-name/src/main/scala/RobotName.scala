import scala.annotation.tailrec
import scala.util.Random

object RobotName {

  private val NumLetters = 2
  private val NumDigits = 3
  val rand = Random

  private var robotNames = Set.empty[String]

  @tailrec
  def randomName(): String = {
    val name = randomPrefix("", NumLetters) + randomSuffix("", NumDigits)
    if (!robotNames.contains(name)) {
      robotNames += name
      name
    }
    else randomName
  }

  @tailrec
  private def randomPrefix(acc: String, cnt: Int): String = {
    if (cnt == 0) acc
    else randomPrefix(acc + (rand.nextInt(26) + 'A').toChar, cnt - 1)
  }

  @tailrec
  private def randomSuffix(acc: String, cnt: Int): String = {
    if (cnt == 0) acc
    else randomSuffix(acc + rand.nextInt(10).toString, cnt - 1)
  }
}

case class Robot() {
  var tempName = RobotName.randomName

  def name(): String = tempName

  def reset() = {
    tempName = RobotName.randomName
  }
}