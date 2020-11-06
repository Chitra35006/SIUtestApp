package com.example.siu2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ForgotPassword extends AppCompatActivity {

    com.google.android.material.textfield.TextInputEditText Email;
    Button Send;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        //Hooks
        Email = (com.google.android.material.textfield.TextInputEditText) findViewById(R.id.recovery_email);
        Send = (Button) findViewById(R.id.send_email);

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = Objects.requireNonNull(Email.getText()).toString();

                if(userEmail.equals("")){
                    Toast.makeText(ForgotPassword.this, "Please enter your registered email ID", Toast.LENGTH_LONG).show();
                }else{
                    firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotPassword.this, "Password reset email sent!", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(ForgotPassword.this, Login.class));
                            }else{
                                Toast.makeText(ForgotPassword.this, "Error in sending password reset email", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }


            }
        });

    }
}