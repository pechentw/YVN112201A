package com.soho.yvtc.yvn112201a;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File f1 = getFilesDir();
        Log.d("FILE",f1.toString());
        File f2 = getCacheDir();
        Log.d("FILE",f2.toString());
        File f3 = getExternalCacheDir();
        Log.d("FILE",f3.toString());
        File f4 = Environment.getExternalStorageDirectory();
        Log.d("FILE",f4.toString());

    }
    public void click1(View v)
    {
        File f1 = getFilesDir();
        File writeFile = new File(f1, "mydata.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(writeFile.getAbsolutePath());
            fw.write("Hello This is data2");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click2(View v)
    {
        File f1 = getFilesDir();
        File readFile = new File(f1, "mydata2.txt");
        try {
            FileReader fr = new FileReader(readFile.getAbsoluteFile());
            StringBuilder sb = new StringBuilder();
            char[] ch = new char[1];
            while(fr.read(ch) != -1)
            {
                sb.append(new String(ch));
            }
            Log.d("DATA", sb.toString());
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
