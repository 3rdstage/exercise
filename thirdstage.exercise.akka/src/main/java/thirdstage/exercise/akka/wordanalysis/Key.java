package thirdstage.exercise.akka.wordanalysis;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Sangmoon Oh
 *
 * @param <T>
 */
@Immutable
public class Key<T>{


   private final T value;

   public Key(@Nonnull T key){
      Validate.isTrue(key != null, "The key should be non-null value");
      this.value = key;
   }

   public T getValue(){ return this.value; }

   @Override
   public boolean equals(Object obj){
      if(obj == null) return false;
      if(!(obj instanceof Key)) return false;

      return EqualsBuilder.reflectionEquals(this.value, ((Key)obj).getValue());
   }

   @Override
   public int hashCode(){
      return HashCodeBuilder.reflectionHashCode(this.value);
   }

}
