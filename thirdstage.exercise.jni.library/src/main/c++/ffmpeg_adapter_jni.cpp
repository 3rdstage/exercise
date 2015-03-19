#ifndef __STDC_CONSTANT_MACROS
#define __STDC_CONSTANT_MACROS
#endif


#ifdef __cplusplus
extern "C" {
#endif
#include "thirdstage_exercise_jni_library_case1_FfmpegAdapter.h"
#include "stdio.h"
#include "windows.h"
#include "libavcodec/avcodec.h"
#include "libavformat/avformat.h"
#include "libswscale/swscale.h"
#include "libavutil/avutil.h"


JNIEXPORT void JNICALL
Java_thirdstage_exercise_jni_library_case1_FfmpegAdapter_avRegisterAll
(JNIEnv *env, jobject j_this)
{
	av_register_all();
	printf("av_register_all() is executed successfully.");
}
#ifdef __cplusplus
}
#endif
