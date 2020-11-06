package com.example.siu2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;
import java.util.UUID;

public class Login extends AppCompatActivity {

    com.google.android.material.textfield.TextInputEditText LoginEmail, LoginPassword;
    Button SkipNow, Register, Login, Forgot;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Element Hooks
        LoginEmail =(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.login_email);
        LoginPassword =(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.login_password);
        SkipNow = (Button) findViewById(R.id.login_skip);
        Register = (Button) findViewById(R.id.login_register);
        Login = (Button) findViewById(R.id.login_login);
        Forgot = (Button) findViewById(R.id.forgot);

        firebaseAuth = FirebaseAuth.getInstance();

        SkipNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SkipMode.class));
            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Objects.requireNonNull(LoginEmail.getText()).toString(), Objects.requireNonNull(LoginPassword.getText()).toString());
            }
        });

        Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ForgotPassword.class));
            }
        });



    }

    private void validate(String toString, String toString1) {
        firebaseAuth.signInWithEmailAndPassword(Objects.requireNonNull(LoginEmail.getText()).toString(), Objects.requireNonNull(LoginPassword.getText()).toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    checkEmailVerification();
                }else{
                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkEmailVerification() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        assert firebaseUser != null;
        boolean emailflag = firebaseUser.isEmailVerified();

        if(emailflag){
            finish();
            startActivity(new Intent(Login.this, UserMode.class));
        }else{
            Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}