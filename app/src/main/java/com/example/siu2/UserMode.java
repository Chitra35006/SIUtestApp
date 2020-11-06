package com.example.siu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class UserMode extends AppCompatActivity {
    LinearLayout Fb, Location, Fees, Faculty, Logout, Profile, Notice, News, About;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermode);
        //Set Hooks
        SetHooks();

        //About
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMode.this, About.class));
            }
        });

        //Newsfeed
        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMode.this, News.class));
            }
        });

        //Notice
        Notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMode.this, NoticePage.class));
            }
        });


        //Profile
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMode.this, Profile.class));
            }
        });

        //Logout
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });


        //Faculty
        Faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMode.this, Faculty.class));
            }
        });

        //Fees
        Fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMode.this, Fees.class));
            }
        });

        //Location
        Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMode.this, Location.class));
            }
        });


        //Facebook Page
        Fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotoFbPage("1063090737184212");
            }
        });

    }

    private void logout() {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(UserMode.this, Login.class));
    }

    private void GotoFbPage(String id) {
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"+ id));
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"+ id));
            startActivity(intent);
        }

    }

    private void SetHooks() {
        Fb = (LinearLayout) findViewById(R.id.user_fb);
        Location = (LinearLayout) findViewById(R.id.user_location);
        Fees = (LinearLayout) findViewById(R.id.user_fees);
        Faculty = (LinearLayout) findViewById(R.id.user_faculty);
        Logout = (LinearLayout) findViewById(R.id.user_logout);
        Profile = (LinearLayout) findViewById(R.id.user_profile);
        Notice = (LinearLayout) findViewById(R.id.user_notice);
        News = (LinearLayout) findViewById(R.id.user_newsfeed);
        About = (LinearLayout) findViewById(R.id.user_about);
    }
}