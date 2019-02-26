object SpaceAge {

  private val BaseFactor = 31557600
  private val EarthFactor = 1
  private val MercuryFactor = 0.2408467
  private val VenusFactor = 0.61519726
  private val MarsFactor = 1.8808158
  private val JupiterFactor = 11.862615
  private val SaturnFactor = 29.447498
  private val UranusFactor = 84.016846
  private val NeptuneFactor = 164.79132

  def onEarth(age: Double): Double = calculateAge(age, EarthFactor)

  def onMercury(age: Double): Double = calculateAge(age, MercuryFactor)

  def onVenus(age: Double): Double = calculateAge(age, VenusFactor)

  def onMars(age: Double): Double = calculateAge(age, MarsFactor)

  def onJupiter(age: Double): Double = calculateAge(age, JupiterFactor)

  def onSaturn(age: Double): Double = calculateAge(age, SaturnFactor)

  def onUranus(age: Double): Double = calculateAge(age, UranusFactor)

  def onNeptune(age: Double): Double = calculateAge(age, NeptuneFactor)

  private def calculateAge(age: Double, factor: Double): Double = {
    age / BaseFactor / factor
  }

}