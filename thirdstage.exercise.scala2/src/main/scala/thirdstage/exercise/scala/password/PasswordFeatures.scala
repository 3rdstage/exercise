package thirdstage.exercise.scala.password

class PasswordFeatures {
  
  private var minLength = 4
  
  private var maxLength = 12
  
  private def PasswordFeatures(){
    
  }
  
  
}

object PasswordFeatures {
  
  val MinLengthMin = 4
  
  val MaxLengthMax = 16
  
  def apply(minLen: Integer, maxLen: Integer){
    var features = new PasswordFeatures
    features.minLength = minLen
    features.maxLength = maxLen
    features
  }
  
  def apply(minLen: Integer){
    apply(minLen, MaxLengthMax)
  }
  
}