package thirdstage.exercise.scala.clazz

class Rational(n: Int, d:Int) {
  
  require(d != 0)
  
  override def toString = n + "/" + d
  
  
  
}