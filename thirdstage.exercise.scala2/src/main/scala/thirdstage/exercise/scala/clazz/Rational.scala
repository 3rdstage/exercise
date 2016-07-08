package thirdstage.exercise.scala.clazz

/**
 * @author Sangmoon Oh
 * @since 2016-07-08
 */
class Rational(n: Int, d:Int) {

  require(d != 0)

  val numer: Int = n
  val denom: Int = d

  override def toString = n + "/" + d

  def add(that: Rational): Rational =
    new Rational(
        numer * that.denom + denom * that.numer,
        denom * that.denom
    )

}