object Bob {

  sealed trait StateType

  object Question extends StateType
  object Yell extends StateType
  object YellQuestion extends StateType
  object Nothing extends StateType
  object Other extends StateType

  def response(statement: String): String = {
    determineType(statement) match {
      case Question => "Sure."
      case Yell => "Whoa, chill out!"
      case YellQuestion => "Calm down, I know what I'm doing!"
      case Nothing => "Fine. Be that way!"
      case _ => "Whatever."
    }
  }

  private def determineType(state: String): StateType = {
    if (isNothing(state)) Nothing
    else if (isYellQuestion(state)) YellQuestion
    else if (isYell(state)) Yell
    else if (isQuestion(state)) Question
    else Other
  }

  private def isNothing(state: String): Boolean = state.trim.length == 0

  private def isYellQuestion(state: String): Boolean = isYell(state) && isQuestion(state)

  private def isYell(state: String): Boolean = state.exists(_.isLetter) && !state.exists(_.isLower)

  private def isQuestion(state: String): Boolean = state.trim.takeRight(1) == "?"
}
