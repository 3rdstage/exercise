#ifndef __STDC_CONSTANT_MACROS
#define __STDC_CONSTANT_MACROS
#endif

#include <cstdio>
#ifdef __cplusplus
extern "C" {
#endif
#include <libavcodec/avcodec.h>
#include <libavformat/avformat.h>
#include <libavutil/frame.h>
#include <libswscale/swscale.h>
#ifdef __cplusplus
}
#endif

int main(){
  printf("Starting test2.\n");

  av_register_all();

  char *file_name = ".\\src\\test\\resources\\matrix2-superbowltrailer640_dl.mov";
  printf("The file is %s\n", file_name);

  AVFormatContext *format_cntx = NULL;
  if(avformat_open_input(&format_cntx, file_name, NULL, NULL) != 0){
      return -1;
  }

  if(avformat_find_stream_info(format_cntx, NULL) < 0){
      return -1;
  }

  AVCodecContext *codec_cntx = NULL;
  int video_strm = -1;
  for(int i = 0; i < format_cntx->nb_streams; i++){
      if(format_cntx->streams[i]->codec->codec_type == AVMEDIA_TYPE_VIDEO){
          video_strm = i;
          codec_cntx = format_cntx->streams[i]->codec;
          break;
      }
  }
  if(video_strm == -1){
      fprintf(stderr, "Can't find video stream in the file.\n");
      return -1;
  }

  AVCodec *codec = NULL;
  codec = avcodec_find_decoder(codec_cntx->codec_id);
  if(codec == NULL){
      fprintf(stderr, "Unsupported codec!\n");
      return -1;
  }

  AVCodecContext *codec_cntx1 = NULL;
  codec_cntx1 = avcodec_alloc_context3(codec);
  if(avcodec_copy_context(codec_cntx1, codec_cntx) != 0){
      fprintf(stderr, "Fail to copy codec context.\n");
      return 1;
  }

  if(avcodec_open2(codec_cntx1, codec, NULL) < 0){
      return -1;
  }

  AVFrame *frm = NULL;
  frm = av_frame_alloc();
  AVFrame *frm_rgb = NULL;
  frm_rgb = av_frame_alloc();
  if(frm_rgb == NULL){
      fprintf(stderr, "Fail to allocate frame data");
      return -1;
  }

  int num_bytes = avpicture_get_size(PIX_FMT_RGB24, codec_cntx1->width, codec_cntx1->height);
  uint8_t *buffer = (uint8_t *)av_malloc(num_bytes * sizeof(uint8_t));

  avpicture_fill((AVPicture *)frm_rgb, buffer, PIX_FMT_RGB24, codec_cntx1->width, codec_cntx1->height);

  struct SwsContext *sws_cntx = NULL;
  int frm_finished;
  AVPacket packet;
  sws_cntx = sws_getContext(codec_cntx1->width, codec_cntx1->height,
      codec_cntx1->pix_fmt, codec_cntx1->width, codec_cntx1->height, PIX_FMT_RGB24,
      SWS_BILINEAR, NULL, NULL, NULL);

  int cnt = 0;
  while(av_read_frame(format_cntx, &packet) >= 0){
      if(packet.stream_index == video_strm){
          avcodec_decode_video2(codec_cntx, frm, &frm_finished, &packet);

          if(frm_finished){
              sws_scale(sws_cntx, (uint8_t const * const *)frm->data,
                  frm->linesize, 0, codec_cntx1->height, frm_rgb->data, frm_rgb->linesize);

              printf("The %dth frame is decoded.\n", ++cnt);
              if(cnt <= 5){
              }
          }
      }

      av_free_packet(&packet);

  }

  av_free(buffer);
  av_frame_free(&frm_rgb);
  av_frame_free(&frm);

  avcodec_close(codec_cntx1);
  avcodec_close(codec_cntx);

  avformat_close_input(&format_cntx);

  printf("Ending test2.\n");
  return 0;


}
