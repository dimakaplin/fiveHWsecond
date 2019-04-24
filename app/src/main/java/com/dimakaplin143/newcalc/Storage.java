package com.dimakaplin143.newcalc;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {

    final String LOG_TAG = "myLogs";

    public File getPrivateDocStorageDir(String fileName) {

        File file = new File(Environment.
                getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),fileName);

        return file;
    }
     public boolean isExis(String fileName) {
        return getPrivateDocStorageDir(fileName).exists();
     }

}