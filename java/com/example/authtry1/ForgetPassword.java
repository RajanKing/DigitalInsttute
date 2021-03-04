package com.example.authtry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        email= findViewById(R.id.ForgetPasswordInstitutemail);

    }

    public void SendPassword(View view) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = email.getText().toString();
        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(ForgetPassword.this,InstutionLoginActivity.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(ForgetPassword.this, "Password cant be reset or resended", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
