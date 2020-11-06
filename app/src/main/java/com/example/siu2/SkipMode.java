package com.example.siu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SkipMode extends AppCompatActivity {
    LinearLayout Fb, Location, About;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skipmode);
        //Set Hooks
        SetHooks();


        //About SIU
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SkipMode.this, About.class));
            }
        });

        //Location
        Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SkipMode.this, Location.class));
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
        Fb = (LinearLayout) findViewById(R.id.skip_fb);
        Location = (LinearLayout) findViewById(R.id.skip_location);
        About = (LinearLayout) findViewById(R.id.skip_about);

    }
}