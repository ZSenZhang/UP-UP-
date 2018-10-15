#include <jni.h>
#include <string>
#include "opencv2/objdetect.hpp"
#include "opencv2/highgui.hpp"
#include "opencv2/imgproc.hpp"
#include <android/bitmap.h>
#include <android/log.h>
#include <fstream>

#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, "keymatch", __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,"keymatch",__VA_ARGS__)

using namespace std;
using namespace cv;
extern "C"
JNIEXPORT jint

JNICALL

Java_com_example_apple_camera_1face_Camera2BasicFragment_getMat(
        JNIEnv *env,
        jclass obj,
        jstring pathpic,
        jstring pathface,
        jstring patheye
         /* this */) {
    printf("Java_com_dengxy_opencvtest_ImageProc_getLaplacian:start");
//    Mat *bitmapMat = (Mat*) bmAddress;
    const char *pathpics=env->GetStringUTFChars(pathpic, NULL);
    const char *pathfaces = env->GetStringUTFChars(pathface, NULL);
    const char *patheyes = env->GetStringUTFChars(patheye, NULL);



//    AndroidBitmapInfo inBmpInfo;
//    void *inPixelsAddress;
//    int ret;
//    if ((ret = AndroidBitmap_getInfo(env, bmpIn, &inBmpInfo)) < 0) {
//        LOGD("AndroidBitmap_getInfo() failed ! error=%d", ret);
//
//    }



//    AndroidBitmap_getInfo(env, bmpIn, &inBmpInfo);
//    AndroidBitmap_lockPixels(env, bmpIn, &inPixelsAddress);
//    Mat img(inBmpInfo.height, inBmpInfo.width,CV_8UC4, inPixelsAddress);
//    Sobel(img, img, img.depth(), 1, 1);
    LOGD("Sobel");

//           if (NULL == img) {
//                   printf("Java_com_dengxy_opencvtest_ImageProc_getLaplacian:the bitmpaMat is Null");
//                   return -1;
//               }
    /** Function Headers */
    Mat img=imread(pathpics);

/** Global variables */
//    string face_cascade_name = "/storage/emulated/0/haarcascade_frontalface_alt.xml";
//    string eyes_cascade_name = "/storage/emulated/0/haarcascade_eye_tree_eyeglasses.xml";
//    if( !pathfaces ){ printf("--(!)Error loading face cascade\n"); return -2; };
//    if( !patheyes ){ printf("--(!)Error loading eyes cascade\n"); return -1; };
//    String stringeyes=(String)patheyes;

    LOGD("path");
//    LOGI(patheyes);
//    LOGI(pathfaces);
//    CascadeClassifier face_cascade;
    LOGD("get");
//    CascadeClassifier eyes_cascade;

//    if(!(face_cascade.load(face_cascade_name))){LOGD("Error loading face");return -2; }
//    if(!(eyes_cascade.load(eyes_cascade_name))){LOGD("Error loading eyes");return -1;}
    CascadeClassifier *face_cascade=new CascadeClassifier(pathfaces);
    CascadeClassifier *eyes_cascade=new CascadeClassifier(patheyes);
    ifstream fin(patheyes);
    if(!fin) {LOGD("error open"); return -4;}
    string window_name = "Capture - Face detection";

/** @function main */
// int main( void )
// {
    // VideoCapture capture;
    // Mat frame;
    jint flag=0;
    // IplImage* pImg = cvLoadImage("sachin.jpg");
    // Mat img = cv::cvarrToMat(pImg);
    // Mat dst=imread("sachin.jpg");
    // Mat *src;
    // src=&dst;
    // long srcaddr=(long)(&src);

    // img = imread("sachin.jpg");

    // Mat img=(*((Mat*)mat));
    // if(img==NULL){
    //     printf("Error reading\n");
    // }
    if (img.empty()){LOGD("--(!)Error opening image\n");return -3;}
    // Mat gray;
    // cvtColor(img,gray, COLOR_BGR2GRAY);

    //-- 1. Load the cascades


    //-- 2. Read the video stream
    // capture.open( 0 );
    // if ( ! capture.isOpened() ) { printf("--(!)Error opening video capture\n"); return -1; }

    // while (  capture.read(frame) )
    // while(frame="")
    // {
    // if( frame.empty() )
    // {
    // printf(" --(!) No captured frame -- Break!");
    // break;
    // }

    //-- 3. Apply the classifier to the frame
    // detectAndDisplay( img );


    std::vector<Rect> faces;
    std::vector<Rect> eyes;
    Mat frame_gray;

    cvtColor( img, frame_gray, COLOR_BGR2GRAY );
    equalizeHist( frame_gray, frame_gray );

    //-- Detect faces
    LOGD("detect");
    face_cascade->detectMultiScale( frame_gray, faces, 1.1, 2, 0|CASCADE_SCALE_IMAGE, Size(30, 30) );
    LOGD("detected");
    // if(faces.size()>0)
    // {
    //     flag=true;
    // }
    for( size_t i = 0; i < faces.size(); i++ )
    {
        LOGD("get in");
        Point center( faces[i].x + faces[i].width/2, faces[i].y + faces[i].height/2 );
        ellipse( img, center, Size( faces[i].width/2, faces[i].height/2), 0, 0, 360, Scalar( 255, 0, 255 ), 4, 8, 0 );

        Mat faceROI = frame_gray( faces[i] );


        //-- In each face, detect eyes
        eyes_cascade->detectMultiScale( faceROI, eyes, 1.1, 2, 0 |CASCADE_SCALE_IMAGE, Size(30, 30) );
//        LOGD(""+eyes.size());
        if(eyes.size()>0)
        {
            flag=1;
        }
        for( size_t j = 0; j < eyes.size(); j++ )
        {
            Point eye_center( faces[i].x + eyes[j].x + eyes[j].width/2, faces[i].y + eyes[j].y + eyes[j].height/2 );
            int radius = cvRound( (eyes[j].width + eyes[j].height)*0.25 );
            circle( img, eye_center, radius, Scalar( 255, 0, 0 ), 4, 8, 0 );
        }
    }
//    if(flag)
//    {
//        Point true_center(eyes[1].x,faces[0].y);
//        ellipse(img, true_center,Size(faces[0].width/4, faces[0].height/4), 0, 0, 360,Scalar( 255, 0, 0 ), 4, 8, 0 );
//    }
    // long imgaddr=(long)img;
    // printf("%ld",imgaddr);
    //-- Show what you got
//    Mat limg = cv::cvarrToMat(pImg);
//    imshow( window_name, limg );

//    int c = waitKey(10);
//    waitKey(0);
//    destroyAllWindows();
    // if( (char)c == 27 ) { break; } // escape
    // }
//    AndroidBitmap_unlockPixels(env, matin);
    return flag;
 }

/** @function detectAndDisplay */
// void detectAndDisplay( Mat frame )
// {
//     std::vector<Rect> faces;
//     Mat frame_gray;

//     cvtColor( frame, frame_gray, COLOR_BGR2GRAY );
//     equalizeHist( frame_gray, frame_gray );

//     //-- Detect faces
//     face_cascade.detectMultiScale( frame_gray, faces, 1.1, 2, 0|CASCADE_SCALE_IMAGE, Size(30, 30) );

//     for( size_t i = 0; i < faces.size(); i++ )
//     {
//         Point center( faces[i].x + faces[i].width/2, faces[i].y + faces[i].height/2 );
//         ellipse( frame, center, Size( faces[i].width/2, faces[i].height/2), 0, 0, 360, Scalar( 255, 0, 255 ), 4, 8, 0 );

//         Mat faceROI = frame_gray( faces[i] );
//         std::vector<Rect> eyes;

//         //-- In each face, detect eyes
//         eyes_cascade.detectMultiScale( faceROI, eyes, 1.1, 2, 0 |CASCADE_SCALE_IMAGE, Size(30, 30) );

//         for( size_t j = 0; j < eyes.size(); j++ )
//         {
//             Point eye_center( faces[i].x + eyes[j].x + eyes[j].width/2, faces[i].y + eyes[j].y + eyes[j].height/2 );
//             int radius = cvRound( (eyes[j].width + eyes[j].height)*0.25 );
//             circle( frame, eye_center, radius, Scalar( 255, 0, 0 ), 4, 8, 0 );
//         }
//     }
//     //-- Show what you got
//     imshow( window_name, frame );
// }