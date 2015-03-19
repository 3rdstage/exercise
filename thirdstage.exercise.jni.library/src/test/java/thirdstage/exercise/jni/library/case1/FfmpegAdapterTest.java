package thirdstage.exercise.jni.library.case1;

public class FfmpegAdapterTest{

   static{
      System.loadLibrary("ffmpeg_adapter_jni");
   }
   
   public static void main(String... args){
      
      FfmpegAdapter testee = new FfmpegAdapter();
      testee.avRegisterAll();
      
   }
   
   
}
