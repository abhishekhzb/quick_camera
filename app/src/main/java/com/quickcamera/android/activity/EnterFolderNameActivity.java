package com.quickcamera.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.quickcamera.android.R;
import com.quickcamera.android.utils.Constants;

public class EnterFolderNameActivity extends AppCompatActivity {
    Button btn_create;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_folder_name);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Enter Folder Name");

        btn_create = findViewById(R.id.btn_create);
        editText = findViewById(R.id.edittext);
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCameraActivity();
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != 0 || event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    goToCameraActivity();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    private void goToCameraActivity() {
        if(editText.getText().length()!=0) {
            Intent intent = new Intent(EnterFolderNameActivity.this, CameraActivity.class);
            intent.putExtra(Constants.FOLDER_NAME, "" + editText.getText().toString().replaceAll(" ","").trim());
            Log.e("folderName", editText.getText().toString().trim());
            startActivity(intent);
            editText.setText("");
            finish();
        }else{
            Toast.makeText(EnterFolderNameActivity.this,"Please Enter Folder Name",Toast.LENGTH_SHORT).show();
        }
    }
}