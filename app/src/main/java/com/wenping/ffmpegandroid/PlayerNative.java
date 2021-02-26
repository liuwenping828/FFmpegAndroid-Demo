package com.wenping.ffmpegandroid;


public class PlayerNative {

    /**
     * 这里加载有依赖关系
     */
    static {
//        System.loadLibrary("avutil");
//        System.loadLibrary("swresample");
//        System.loadLibrary("avcodec");
//        System.loadLibrary("avfilter");
//        System.loadLibrary("swscale");
//        System.loadLibrary("avdevice");
//        System.loadLibrary("avformat");
//        System.loadLibrary("postproc");
        System.loadLibrary("native-ffmpeg");
    }


    /**
     * 音视频解码播放
     *
     * @param path
     * @param view
     */
    public native static void play(String path, Object view);

    /**
     * 音视频解码停止
     */
    public native static void stop();


}
