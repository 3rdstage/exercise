
#include "stdio.h"
#include "windows.h"
#include "jni.h"
#include <cv.hpp>
#include <opencv2/opencv.hpp>
#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <thirdstage_exercise_jni_library_case1_OpenCvAdapter1.h>
#include <iostream>

using namespace std;
using namespace cv;

JNIEXPORT void JNICALL Java_thirdstage_exercise_jni_library_case1_OpenCvAdapter1_justCreateSimplestMatAndPrint
  (JNIEnv *, jobject){

	//Mat r = Mat(3, 2, CV_8UC3);
	//Mat M;
	CvCapture* capture;
	Mat a(100, 100, CV_32F);

}
