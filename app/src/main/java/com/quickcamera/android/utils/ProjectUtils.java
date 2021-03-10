package com.quickcamera.android.utils;


import android.content.Context;
import android.media.MediaScannerConnection;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class ProjectUtils {
    static Context context;

    public ProjectUtils(Context context) {
        this.context = context;
    }

    //delete files
    public static boolean deleteFiles(String path) {
        File file = new File(path);

        if (file.exists()) {
            String deleteCmd = "rm -r " + path;
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(deleteCmd);
            } catch (IOException e) {

            }
            if (file.delete()) {
                Log.e("-->", "file not Deleted :" + path);
                callBroadCast(context);
                return true;
            } else {
                Log.e("-->", "file Deleted :" + path);
                callBroadCast(context);
                return true;
            }
        }
        return false;

    }

    public static void callBroadCast(Context context) {
        MediaScannerConnection.scanFile(context, new String[]{Environment.getExternalStorageDirectory().toString()}, null, new MediaScannerConnection.OnScanCompletedListener() {
            public void onScanCompleted(String path, Uri uri) {
                Log.e("ExternalStorage", "Scanned " + path + ":");
                Log.e("ExternalStorage", "-> uri=" + uri);
            }
        });
    }
}
