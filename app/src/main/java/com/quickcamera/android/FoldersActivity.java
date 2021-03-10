package com.quickcamera.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.quickcamera.android.activity.CameraActivity;
import com.quickcamera.android.activity.EnterFolderNameActivity;
import com.quickcamera.android.adapters.FolderRecyclerAdapter;
import com.quickcamera.android.pojo.FolderPojo;
import com.quickcamera.android.utils.Constants;

import java.io.File;
import java.util.ArrayList;

public class FoldersActivity extends AppCompatActivity {
    FolderRecyclerAdapter mAdapter;
    RecyclerView recyclerView;
    String path = Constants.PATH;
    ArrayList<FolderPojo> folderPojos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folders);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("  Folders");

    }

    @Override
    protected void onResume() {
        super.onResume();
        showFolders();
    }

    private void showFolders() {
        recyclerView = findViewById(R.id.recycler_folders);

        folderPojos = new ArrayList<>();

        File f = new File(path);
        File[] files = f.listFiles();
        if(files!=null)
            for (File inFile : files) {
                if (inFile.isDirectory()) {
                    Log.e("Folders",""+inFile);

                    Uri uri = Uri.fromFile(inFile);
                    String uri_string =  Uri.fromFile(inFile).toString();
                    String name = uri_string.replace("file://"+path,"");

                    folderPojos.add(new FolderPojo(name,uri,uri_string));

                }
            }

        //recyclerview code
        LinearLayoutManager layoutManager = new LinearLayoutManager(FoldersActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new FolderRecyclerAdapter(FoldersActivity.this, folderPojos);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.folder_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create:
                Intent intent = new Intent(FoldersActivity.this, EnterFolderNameActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}