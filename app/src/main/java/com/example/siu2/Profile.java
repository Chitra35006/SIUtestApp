package com.example.siu2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;
import java.util.UUID;

public class Profile extends AppCompatActivity {

    TextView UserName, FullName, RegistrationNumber, Department, Email, Password;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Users").child(Objects.requireNonNull(firebaseUser).getUid());



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //Hooks
        SetID();

        //Load Data
        LoaduserInfo();

    }

    private void SetID() {
        UserName = (TextView) findViewById(R.id.profile_username);
        FullName = (TextView) findViewById(R.id.profile_fullname);
        RegistrationNumber = (TextView) findViewById(R.id.profile_regnumber);
        Department = (TextView) findViewById(R.id.profile_department);
        Email = (TextView) findViewById(R.id.profile_email);
        Password = (TextView) findViewById(R.id.profile_password);
    }

    private void LoaduserInfo() {
        String email = firebaseUser.getEmail();
        Email.setText(email);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String userName = Objects.requireNonNull(snapshot.child("UserName").getValue()).toString();
                String fullName = Objects.requireNonNull(snapshot.child("FullName").getValue()).toString();
                String registrationNumber = Objects.requireNonNull(snapshot.child("RegistrationNumber").getValue()).toString();
                String department = Objects.requireNonNull(snapshot.child("Department").getValue()).toString();
                String password = Objects.requireNonNull(snapshot.child("Password").getValue()).toString();

                UserName.setText(userName);
                FullName.setText(fullName);
                RegistrationNumber.setText(registrationNumber);
                Department.setText(department);
                Password.setText(password);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}