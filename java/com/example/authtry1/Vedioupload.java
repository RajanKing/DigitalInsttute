package com.example.authtry1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.io.File;


import android.os.Bundle;

public class Vedioupload extends AppCompatActivity {
    private static final int PICK_VIDEO_REQUEST = 1;


    private Button choosebtn;
    private Button uploadbtn;
    private   ProgressBar progressBar;
    private VideoView videoView;
    private EditText title;
    private Uri url;
    MediaController mediaController;
    private StorageReference mStorageRef;
    private DatabaseReference mDataBaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedioupload);
        choosebtn = findViewById(R.id.choose_btn);
        uploadbtn = findViewById(R.id.upload_btn);
        videoView = findViewById(R.id.vedio_view);
        progressBar = findViewById(R.id.progress_bar);
        title = findViewById(R.id.video_name);

        mediaController = new MediaController(this);

        mStorageRef = FirebaseStorage.getInstance().getReference("video");
        mDataBaseRef = FirebaseDatabase.getInstance().getReference("video");
      //  mDataBaseRef= Firebase.database.getReference("Users")


        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();


        choosebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseVideo();
            }
        });

        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadVideo();
            }
        });

    }
    private  void ChooseVideo(){
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_VIDEO_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_VIDEO_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            url = data.getData();

            videoView.setVideoURI(url);


        }}

    private String getFileExtension(Uri videoUri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(videoUri));
    }

    private void UploadVideo() {

        progressBar.setVisibility(View.VISIBLE);
        if (url != null){
            StorageReference reference = mStorageRef.child(System.currentTimeMillis() +
                    "." +getFileExtension(url));

            reference.putFile(url)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(),"Upload successful",Toast.LENGTH_SHORT).show();
                            Member member = new Member(title.getText().toString().trim(),
                                    taskSnapshot.getUploadSessionUri().toString());
                            String UploadId = mDataBaseRef.push().getKey();
                            mDataBaseRef.child(UploadId).setValue(member);

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });


        }else {
            Toast.makeText(getApplicationContext(),"No file selected",Toast.LENGTH_SHORT).show();
        }


    }}