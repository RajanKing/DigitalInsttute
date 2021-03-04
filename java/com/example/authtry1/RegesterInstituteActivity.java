package com.example.authtry1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

public class RegesterInstituteActivity extends AppCompatActivity {
    EditText instutiename, instutiepass, instutiemail, instutiePhone;
    Button instutieRegester;
    FirebaseAuth auth;
    DatabaseReference InstutieRef;
    StorageReference storage;
    Uri imageuri;

String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regester_institute);
//        instilaizing edit text view and button
        instutiename = findViewById(R.id.institute_name);
        instutiemail = findViewById(R.id.institute_mail);
        instutiepass = findViewById(R.id.Institute_Password);
        instutiePhone = findViewById(R.id.Institute_phone);
        instutieRegester = findViewById(R.id.SignUp);
//        firebase authentication
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance().getReference();
        instutieRegester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckRegesterData();


            }
        });

    }

    private void CheckRegesterData() {
        String InstName = instutiename.getText().toString();
        String InstMail = instutiemail.getText().toString();
        String InstPass = instutiepass.getText().toString();
        String InstPhone = instutiePhone.getText().toString();
        if (InstName.isEmpty() || InstMail.isEmpty() || InstPass.isEmpty() || InstPhone.isEmpty()) {

            if (TextUtils.isEmpty(InstName)) {
                Toast.makeText(this, "Instutie Name is left empty", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(InstMail)) {
                Toast.makeText(this, "Instutie mail is left empty", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(InstPass)) {
                Toast.makeText(this, "Instutie password is left empty", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Instutie Contact or phone  is left empty", Toast.LENGTH_SHORT).show();
            }
        } else {
            InstituteRegester(InstName, InstMail, InstPhone, InstPass);

//            Toast.makeText(this, "Instutie Contact or phone  is left empty", Toast.LENGTH_SHORT).show();
        }
    }

    private void InstituteRegester(final String name, String mail, final String phone, String password) {
        auth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                             userid = null;
                            if (!(null == user)) userid = user.getUid();
                            InstutieRef = FirebaseDatabase.getInstance().getReference("InstutieUser").child(userid);
//                            hash map data base
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("Institute Name", name);
                            hashMap.put("ImageUrl", "default");
                            hashMap.put("Phone num", phone);
//opening after succsful regestration
                            InstutieRef.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent i = new Intent(RegesterInstituteActivity.this, MainActivity.class);
                                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(i);
                                        finish();
                                    }
                                }
                            });

                        }
                    }
                });
    }

//public void selectImage(){
//if(imageuri!=null)
//{
//    StorageReference imge = storage.child(InstutieUser).child(userid).child("ImageUrl");
//
//}
//}
}
