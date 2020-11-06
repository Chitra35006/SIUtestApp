package com.example.siu2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CSE extends AppCompatActivity {

    TextView FacultyMember, Syllabus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cse);

        FacultyMember = (TextView) findViewById(R.id.cse_faculty_member);
        Syllabus = (TextView) findViewById(R.id.cse_syllabus);

        FacultyMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CSE.this, FacultyMember.class));
            }
        });

        Syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CSE.this, Syllabus.class));
            }
        });

    }
}