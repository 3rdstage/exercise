#ifndef __STDC_CONSTANT_MACROS
#define __STDC_CONSTANT_MACROS
#endif

#include <stdio.h>
#ifdef __cplusplus
extern "C" {
#endif
#include <libavcodec/avcodec.h>
#include <libavformat/avformat.h>
#include <libswscale/swscale.h>
#ifdef __cplusplus
}
#endif

int main(){
  printf("Starting test2.\n");

  av_register_all();

  char *fileName = "D:\\home\\git\\repos\\exercise\\thirdstage.exercise.jni.library\\src\\test\\resources\\matrix2-superbowltrailer640_dl.mov";
  printf("The file is %s\n", fileName);

  AVFormatContext *formatCntx = NULL;
  if(avformat_open_input(&formatCntx, fileName, NULL, NULL) != 0){
      return -1;
  }

  printf("Ending test2.\n");
  return 0;


}
