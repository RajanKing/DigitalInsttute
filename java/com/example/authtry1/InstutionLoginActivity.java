package com.example.authtry1;

import android.content.Intent;
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

public class InstutionLoginActivity extends AppCompatActivity {
    EditText InstutionMail, InstutionPass;
    Button InstutionLogin, InstutionRegester, ForgetInstutionpass;

    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instution_login);
        InstutionMail = findViewById(R.id.InstutieId);
        InstutionPass = findViewById(R.id.InstutiePass);
        InstutionLogin = findViewById(R.id.signInInstitution);
        ForgetInstutionpass = findViewById(R.id.ForgetInstitutePass);
        InstutionRegester = findViewById(R.id.RegesterInstitution);


        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if(user!=null)
        {
            Intent i = new Intent(InstutionLoginActivity.this, MainActivity.class);
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); check it now
            startActivity(i);
            finish();


        }

        InstutionRegester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InstutionLoginActivity.this, RegesterInstituteActivity.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(i);
//                finish();
            }
        });
                ForgetInstutionpass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(InstutionLoginActivity.this, ForgetPassword.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        /*
                        * now check
                        * working both
                        * ok send me this folder
                        * and show ur app
                        *
                        * */
                        startActivity(i);
                        finish();
                    }
                });
        InstutionLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String InsEmail = InstutionMail.getText().toString();
                String InsPass = InstutionPass.getText().toString();
                if (TextUtils.isEmpty(InsEmail)) {
                    Toast.makeText(InstutionLoginActivity.this, "Please enter the email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(InsPass)) {
                    Toast.makeText(InstutionLoginActivity.this, "Please enter the Password", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(InstutionLoginActivity.this, "hello", Toast.LENGTH_SHORT).show();
                    auth.signInWithEmailAndPassword(InsEmail, InsPass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(InstutionLoginActivity.this, "hello", Toast.LENGTH_SHORT).show();
                                    if (task.isSuccessful()) {
                                        Intent i = new Intent(InstutionLoginActivity.this, MainActivity.class);
                                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(i);
                                        finish();
                                    } else {
                                        Toast.makeText(InstutionLoginActivity.this, "Institute Login Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }


            }
        });
    }

//    public void InstutieSignIn(View view) {
//    }
//
//    public void RegesterInstution(View view) {
//    }
//
//    public void ForgetInsutiePassword(View view) {
//    }
}
