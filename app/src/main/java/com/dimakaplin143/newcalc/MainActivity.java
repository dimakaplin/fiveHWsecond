package com.dimakaplin143.newcalc;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    private static final String APP_PREFERENCES = "bgImg";
    public static final String APP_PREFERENCES_NAME = "imgName";
    private SharedPreferences bgSettings;

    private Storage storage;
    private ImageView img;
    Button im;

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;
    Button point;

    Button clear;
    Button dev;
    Button mul;
    Button plus;
    Button minus;
    Button prec;
    Button res;
    TextView result;

    String first = "";
    String two = "";
    String man = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        checkImg();

    }

    private void checkImg() {
        String fileName = bgSettings.getString(APP_PREFERENCES_NAME, "");
        Log.e(LOG_TAG, fileName);
        if (!"".equals(fileName)) {
            File file = storage.getPrivateDocStorageDir(fileName);
/*            img.setImageURI(null);
            Log.e(LOG_TAG, Uri.fromFile(file).toString());
            img.setImageURI(Uri.fromFile(file));*/
            img.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        }
    }

    private void initViews() {

        img = findViewById(R.id.img);
        storage = new Storage();
        bgSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        im = findViewById(R.id.image_btn);

        im.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, ChangeBg.class);
            startActivity(intent);
        });

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);

        clear = findViewById(R.id.clear);
        dev = findViewById(R.id.dev);
        mul = findViewById(R.id.mul);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        prec = findViewById(R.id.prec);
        res = findViewById(R.id.res);
        point = findViewById(R.id.point);
        result = findViewById(R.id.result);

        clear.setOnClickListener(v-> {
            //Button b = (Button) v;
            result.setText("0");
        });
        dev.setOnClickListener(v-> {
            Button b = (Button) v;
            if(!result.getText().toString().contains(b.getText().toString())) {
                first = result.getText().toString();
                man = b.getText().toString();
                buttonClick(b);
            }
        });
        mul.setOnClickListener(v-> {
            Button b = (Button) v;
            if(!result.getText().toString().contains(b.getText().toString())) {
                first = result.getText().toString();
                man = b.getText().toString();
                buttonClick(b);
            }
        });
        plus.setOnClickListener(v-> {
            Button b = (Button) v;
            if(!result.getText().toString().contains(b.getText().toString())) {
                first = result.getText().toString();
                man = b.getText().toString();
                buttonClick(b);
            }
        });
        minus.setOnClickListener(v-> {
            Button b = (Button) v;
            if(!result.getText().toString().contains(b.getText().toString())) {
                first = result.getText().toString();
                man = b.getText().toString();
                buttonClick(b);
            }
        });
        prec.setOnClickListener(v-> {
            Button b = (Button) v;
            if(!result.getText().toString().contains(b.getText().toString())) {
                first = result.getText().toString();
                man = b.getText().toString();
                buttonClick(b);
            }
        });
        res.setOnClickListener(v-> {

            if(!"".equals(first) && !"".equals(man)) {
                double res;
                two = result.getText().toString().substring(result.getText().toString().indexOf(man)+1);
                Button b = (Button) v;
                switch (man) {
                    case "/":
                        res = ((Double.parseDouble(first) * 10000) / (Double.parseDouble(two)* 10000)) / 10000;
                        result.setText(Double.toString(res));
                        break;
                    case "*":
                        res = ((Double.parseDouble(first) * 10000) * (Double.parseDouble(two) * 10000)) / 100000000;
                        result.setText(Double.toString(res));
                        break;
                    case "-":
                        System.out.println(first);
                        System.out.println(two);
                        res = (Double.parseDouble(first) * 10000 - Double.parseDouble(two)* 10000) / 10000;
                        result.setText(Double.toString(res));
                        break;
                    case "+":
                        res = (Double.parseDouble(first) * 10000 + Double.parseDouble(two)* 10000) / 10000;
                        result.setText(Double.toString(res));
                        break;
                    case "%":
                        res = (Double.parseDouble(first) * 100) / Double.parseDouble(two);
                        result.setText(Double.toString(res));
                        break;
                }
            }
        });

        b1.setOnClickListener(v-> {
            Button b = (Button) v;
            buttonClick(b);
        });
        b2.setOnClickListener(v-> {
            Button b = (Button) v;
            buttonClick(b);
        });
        b3.setOnClickListener(v-> {
            Button b = (Button) v;
            buttonClick(b);
        });
        b4.setOnClickListener(v-> {
            Button b = (Button) v;
            buttonClick(b);
        });
        b5.setOnClickListener(v-> {
            Button b = (Button) v;
            buttonClick(b);
        });
        b6.setOnClickListener(v-> {
            Button b = (Button) v;
            buttonClick(b);
        });
        b7.setOnClickListener(v-> {
            Button b = (Button) v;
            buttonClick(b);
        });
        b8.setOnClickListener(v-> {
            Button b = (Button) v;
            buttonClick(b);
        });
        b9.setOnClickListener(v-> {
            Button b = (Button) v;
            buttonClick(b);
        });
        b0.setOnClickListener(v-> {
            Button b = (Button) v;
            buttonClick(b);
        });
        point.setOnClickListener(v-> {
            Button b = (Button) v;

            if(!result.getText().toString().contains(".") && "".equals(first)) {
                buttonClick(b);
            }
            else if (!result.getText().toString().substring(result.getText().toString().indexOf(man)+1).contains(".")) {
                buttonClick(b);
            }
        });
    }

    private void buttonClick(Button b) {
        if("0".equals(result.getText().toString())) {
            result.setText(b.getText().toString());
        }
        else {
            result.setText(result.getText().toString() + b.getText().toString());
        }
    }
}

