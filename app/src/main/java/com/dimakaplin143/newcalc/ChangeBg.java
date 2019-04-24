package com.dimakaplin143.newcalc;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;

public class ChangeBg extends AppCompatActivity {

    private static final String APP_PREFERENCES = "bgImg";
    public static final String APP_PREFERENCES_NAME = "imgName";
    final String LOG_TAG = "myLogs";
    private SharedPreferences bgSettings;

    private Storage storage;
    private EditText chooseImg;
    private Button okBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_bg);

        initViews();
    }

    public void initViews() {
        bgSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        storage = new Storage();
        chooseImg = findViewById(R.id.editText);
        okBtn = findViewById(R.id.ok_btn);
        okBtn.setOnClickListener(v-> {
            String fileName = chooseImg.getText().toString();
            if(storage.isExis(fileName)) {
                SharedPreferences.Editor editor = bgSettings.edit();
                editor.putString(APP_PREFERENCES_NAME, fileName);
                editor.apply();

                Intent intent = new Intent(ChangeBg.this, MainActivity.class);
                startActivity(intent);

            }
            else {
                String message = getText(R.string.not_saved_message).toString();
                Toast.makeText(ChangeBg.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }




}
