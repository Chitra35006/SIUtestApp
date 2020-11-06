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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Register extends AppCompatActivity {

    com.google.android.material.textfield.TextInputEditText UserName, FullName, RegistrationNumber, Department, Email, Password;
    Button SkipNow , Login, Register;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        //Set IDs
        SetID();

        //Firebase Calling (Users)
        firebaseAuth = FirebaseAuth.getInstance();


        //Skip Button
        SkipNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, SkipMode.class));
            }
        });

        //Login Button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });

        //Register Button
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reg_email = Objects.requireNonNull(Email.getText()).toString().trim();
                String reg_password = Objects.requireNonNull(Password.getText()).toString().trim();

                if(validate()){
                    //Firebase
                    firebaseAuth.createUserWithEmailAndPassword(reg_email,reg_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                sendEmailVerification();
                            }else{
                                Toast.makeText(Register.this, "You are a Registered member! Please Login!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

            }

        });


    }


    //Send to Databse
    private void sendUserData() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        DatabaseReference databaseReference = firebaseDatabase.getReference("Users");

        String sUserName = Objects.requireNonNull(UserName.getText()).toString();
        String sFullName = Objects.requireNonNull(FullName.getText()).toString();
        String sRegistrationNumber = Objects.requireNonNull(RegistrationNumber.getText()).toString();
        String sDepartment = Objects.requireNonNull(Department.getText()).toString();
        String sEmail = Objects.requireNonNull(Email.getText()).toString();
        String sPassword = Objects.requireNonNull(Password.getText()).toString();


        assert firebaseUser != null;
        databaseReference.child(firebaseUser.getUid()).child("UserName").setValue(sUserName);
        databaseReference.child(firebaseUser.getUid()).child("FullName").setValue(sFullName);
        databaseReference.child(firebaseUser.getUid()).child("RegistrationNumber").setValue(sRegistrationNumber);
        databaseReference.child(firebaseUser.getUid()).child("Department").setValue(sDepartment);
        databaseReference.child(firebaseUser.getUid()).child("Email").setValue(sEmail);
        databaseReference.child(firebaseUser.getUid()).child("Password").setValue(sPassword);

    }


    private void SetID() {
        UserName = (com.google.android.material.textfield.TextInputEditText) findViewById(R.id.register_username);
        FullName = (com.google.android.material.textfield.TextInputEditText) findViewById(R.id.register_fullname);
        RegistrationNumber = (com.google.android.material.textfield.TextInputEditText) findViewById(R.id.register_regnumber);
        Department = (com.google.android.material.textfield.TextInputEditText) findViewById(R.id.register_department);
        Email = (com.google.android.material.textfield.TextInputEditText) findViewById(R.id.register_email);
        Password = (com.google.android.material.textfield.TextInputEditText) findViewById(R.id.register_password);
        SkipNow = (Button) findViewById(R.id.register_skip);
        Login = (Button) findViewById(R.id.register_login);
        Register = (Button) findViewById(R.id.register_register);
    }

    //Verification Email
    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        sendUserData();

                        firebaseAuth.signOut();
                        Toast.makeText(Register.this, "Successfully Registered, Check your Verification mail!", Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(new Intent(Register.this, Login.class));

                    }else{
                        Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }


    private Boolean validate(){
        AtomicReference<Boolean> result = new AtomicReference<>(false);

        String sUserName = Objects.requireNonNull(UserName.getText()).toString();
        String sFullName = Objects.requireNonNull(FullName.getText()).toString();
        String sRegistrationNumber = Objects.requireNonNull(RegistrationNumber.getText()).toString();
        String sDepartment = Objects.requireNonNull(Department.getText()).toString();
        String sEmail = Objects.requireNonNull(Email.getText()).toString();
        String sPassword = Objects.requireNonNull(Password.getText()).toString();

        //CheckEmail();
        if(sUserName.isEmpty() || sFullName.isEmpty() || sRegistrationNumber.isEmpty() || sDepartment.isEmpty() || sEmail.isEmpty() || sPassword.isEmpty()){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result.set(true);
        }

        return result.get();
    }


}