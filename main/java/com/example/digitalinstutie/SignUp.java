package com.example.digitalinstutie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {
   Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login = findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(SignUp.this, Login.class);
                 startActivity(i);
                 finish();

             }
         });
    }
}
/**
 *
 *
 *  Login = findViewById(R.id.Login);
 *         Name = findViewById(R.id.SignUpName);
 *         Username = findViewById(R.id.SignUpUserName);
 *         email = findViewById(R.id.SignUpEmail);
 *         password = findViewById(R.id.SignUpPassword);
 *         phone = findViewById(R.id.SignUpPhone);
 *
 *         SignUp=findViewById(R.id.SignUP);
 *         SignUp.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View view) {
 *
 *                 if(validateEmail()|validateName()|validatePassword()|validatePhone()|validateUserName()){
 *
 *
 *                     if(Spassword.length()<6)
 *                         Toast.makeText(SignUp.this, "Invalid Password", Toast.LENGTH_SHORT).show();
 *
 *                 }else
 *                     Register(SName, SUsername, Semail, Sphone, Spassword);
 *
 *             }
 *         });
 *
 *         Login.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View view) {
 *                 Intent i = new Intent(SignUp.this, Login.class);
 *                 startActivity(i);
 *                 finish();
 *
 *             }
 *         });
 *
 *     }
 *
 *     private void Register(final String sName, final String sUsername, final String semail, final String sphone, final String spassword) {
 *         mAuth.createUserWithEmailAndPassword(semail,spassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
 *             @Override
 *             public void onComplete(@NonNull Task<AuthResult> task) {
 *                 if(task.isSuccessful())
 *                 {
 *
 *                     SName=Name.getText().toString();
 *                     SUsername = Username.getText().toString();
 *                     Semail=email.getText().toString();
 *                     Spassword=password.getText().toString();
 *                     Sphone=phone.getText().toString();
 *                     user=mAuth.getCurrentUser();
 *                     String em=user.getEmail();
 *                     String uid=user.getUid();
 *                     UserHelperClass helperClass= new UserHelperClass(SName, SUsername, Semail, Sphone, Spassword,uid);
 *
 *                     DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");
 *                     reference.child(uid).setValue(helperClass);
 *                     progressDialog= new ProgressDialog(SignUp.this);
 *                     progressDialog.show();
 *                     progressDialog.setContentView(R.layout.progress_dialog);
 *                     progressDialog.getWindow().setBackgroundDrawableResource(
 *                             android.R.color.transparent
 *                     );
 *                     Thread timer = new Thread(){
 *                         @Override
 *                         public void run() {
 *                             try{
 *                                 sleep(100);
 *                                 Intent i = new Intent(getApplicationContext(),Login.class);
 *                                 startActivity(i);
 *                                 progressDialog.dismiss();
 *                                 super.run();
 *                             }catch (Exception e)
 *                             {
 *                                 e.printStackTrace();
 *                             }
 *
 *                         }
 *                     };
 *                     timer.start();
 *                     startActivity(new Intent(SignUp.this,MainActivity.class));
 *                     finish();
 *
 *                 }
 *                 else
 *                 {
 *                     Toast.makeText(SignUp.this, "Registertaion failed", Toast.LENGTH_SHORT).show();
 *                 }
 *             }
 *         }).addOnFailureListener(new OnFailureListener() {
 *             @Override
 *             public void onFailure(@NonNull Exception e) {
 *                 Toast.makeText(SignUp.this, "Registertaion failed"+e.getMessage(), Toast.LENGTH_SHORT).show();
 *             }
 *         });
 *     }
 *     private  boolean validateUserName()
 *     {
 *         String val = Username.getText().toString();
 *         String noWhiteSpace="\\A\\w{4,20}\\z";
 *         if(val.isEmpty())
 *         {
 *             Username.setError("Username Field should not be empty");
 *             return false;
 *         }
 *         else if (val.length()>25)
 *         {
 *             Username.setError("Username is too long");
 *             return false;
 *         }
 *         else if (!val.matches(noWhiteSpace))
 *         {
 *             Username.setError("UserName should not have whitespace");
 *             return false;
 *         }
 *         else {
 *             Username.setError(null);
 * //            Username.setErrorEnabled(false);
 *             return true;
 *         }
 *     }
 *     private  boolean validateEmail(){
 *         String val=email.getText().toString();
 *         String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
 *         if(val.isEmpty())
 *         {
 *             email.setError("Email Field should not be empty");
 *             return false;
 *         }
 *         else if(!val.matches(emailPattern)){
 *             email.setError("Invalid Email Address");
 *             return  false;
 *         }else {
 *             email.setError(null);
 * //            email.setErrorEnabled(false);
 *             return  true;
 *         }
 *
 *     }
 *     private  boolean validateName(){
 *         String val=Name.getText().toString();
 *         String passwordPattern="^"+"(?=.*[a-zA-Z])"+"(?=.*[@#$%^&+=])"+"(?=.\\S+$)"+".{4,}"+"$";
 *         if(val.isEmpty())
 *         {
 *             Name.setError("Field can't be empty");
 *
 *             return false;
 *         }else if(!val.matches(passwordPattern)){
 *             password.setError("Weak password");
 *             return false;
 *         }
 *         else{
 *             Name.setError(null);
 * //            Name.setErrorEnabled(false);
 *             return true;
 *         }
 *     }
 *     private  boolean validatePhone(){
 *         String val=phone.getText().toString();
 *         if(val.isEmpty())
 *         {
 *             phone.setError("Field can't be empty");
 *             return false;
 *         }
 *         else if(val.length()<10){
 *             phone.setError("Number less than 10digits");
 *             return false;
 *         }
 *         else{
 *             phone.setError(null);
 * //            phone.setErrorEnabled(false);
 *             return true;
 *         }
 *     }
 *     private  boolean validatePassword(){
 *         String val=password.getText().toString();
 *         if(val.isEmpty())
 *         {
 *             password.setError("Field can't be empty");
 *             return false;
 *         }
 *         else if (val.length()<6)
 *         {
 *             password.setError("password length should be more than 6");
 *             return false;
 *         }
 *         else{
 *             password.setError(null);
 * //            password.setErrorEnabled(false);
 *             return true;
 *         }
  */
