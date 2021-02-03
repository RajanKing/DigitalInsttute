package com.example.digitalinstutie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
signup.findViewById(R.id.SignUP);
        signup.setOnClickListener(new View.OnClickListener() {
           @Override
              public void onClick(View view) {
                  Intent i = new Intent(Login.this, SignUp.class);
                  startActivity(i);
                  finish();
                               }
          });

    }
}
/**
 *  Button signup,Login;
 *     EditText LoginUserName,LoginPassword;
 *     private FirebaseAuth mAuth;
 *     private String username,password;
 *     FirebaseUser user;
 *  // Initialize Firebase Auth
 *         mAuth = FirebaseAuth.getInstance();
 *         signup = findViewById(R.id.SignUp);
 *         LoginUserName = findViewById(R.id.LoginUserName);
 *         LoginPassword = findViewById(R.id.LoginUserPassword);
 *         Login = findViewById(R.id.LoginButton);
 *         Login.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View view) {
 *                 username = LoginUserName.getText().toString();
 *                 password = LoginPassword.getText().toString();
 *                 if(username.isEmpty()|password.isEmpty())
 *                 {
 *
 *                     if(username.isEmpty())
 *                         LoginUserName.setError("Field can't be empty");
 *                     if(password.isEmpty())
 *                         LoginPassword.setError("Field can't be empty");
 *                     Toast.makeText(Login.this, "Username and password is not empty", Toast.LENGTH_SHORT).show();
 *
 *                 }
 *                 else {
 *                     if(!username.isEmpty()){
 *                         LoginUserName.setError(null);
 *
 *                     }
 *                     if(!password.isEmpty()){
 *                         LoginPassword.setError(null);
 *
 *                     } else
 *                     Login(username,password);
 *                 }
 *             }
 *         });
 *         signup.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View view) {
 *                 Intent i = new Intent(Login.this, SignUp.class);
 *                 startActivity(i);
 *                 finish();
 *
 *             }
 *         });
 *
 *
 *     }
 *     private void Login(String username, String password) {
 *         mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
 *             @Override
 *             public void onComplete(@NonNull Task<AuthResult> task) {
 *                 if(task.isSuccessful())
 *                 {
 *                     user=mAuth.getCurrentUser();
 *                     Intent i = new Intent(Login.this,MainActivity.class);
 *                     startActivity(i);
 *                     finish();
 *                 }
 *                 else
 *                     Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
 *             }
 *         }).addOnFailureListener(new OnFailureListener() {
 *             @Override
 *             public void onFailure(@NonNull Exception e) {
 *                 Toast.makeText(Login.this, "Login Failed\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
 *             }
 *         });
 *
 */
