/**
 *
 */
package thirdstage.exercise.jackson.databind.case4;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;

/**
 * @author Sangmoon Oh
 *
 */
public class RequestToken {

   public enum Action{
      ADD_IMAGE,
      UPDATE_IMAGE,
      REMOVE_FACES
   }

   private int id;

   private Action action;

   private Date date;

   private Object obj;

   public int getId(){ return this.id;	}

   public RequestToken setId(int id){
      this.id = id;
      return this;
   }

   public Action getAction(){ return this.action; }

   public RequestToken setAction(Action action){
      this.action = action;
      return this;
   }

   public Date getDate(){ return this.date; }

   @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
   public RequestToken setDate(Date d){
      this.date = d;
      return this;
   }

   public Object getObject(){ return this.obj; }

   @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
   public RequestToken setObject(Object obj){
      this.obj = obj;
      return this;
   }
}
