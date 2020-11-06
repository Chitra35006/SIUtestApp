package com.example.siu2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Syllabus extends AppCompatActivity {

    Dialog dialog;
    TextView One_one, One_two,Two_one,Two_two,Three_one,Three_two,Four_one,Four_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus);
        //Hooks
        One_one = (TextView) findViewById(R.id.one_one);
        One_two = (TextView) findViewById(R.id.one_two);
        Two_one = (TextView) findViewById(R.id.two_one);
        Two_two = (TextView) findViewById(R.id.two_two);
        Three_one = (TextView) findViewById(R.id.three_one);
        Three_two = (TextView) findViewById(R.id.three_two);
        Four_one = (TextView) findViewById(R.id.four_one);
        Four_two = (TextView) findViewById(R.id.four_two);
        dialog = new Dialog(this);

        //Buttons
        One_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOneOne();
            }
        });

        One_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOneTwo();
            }
        });

        Two_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwoOne();
            }
        });

        Two_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwoTwo();
            }
        });

        Three_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThreeOne();
            }
        });

        Three_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThreeTwo();
            }
        });

        Four_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFourOne();
            }
        });

        Four_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFourTwo();
            }
        });


    }

    private void openOneOne() {
        dialog.setContentView(R.layout.one_one);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void openOneTwo() {
        dialog.setContentView(R.layout.one_two);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void openTwoOne() {
        dialog.setContentView(R.layout.two_one);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void openTwoTwo() {
        dialog.setContentView(R.layout.two_two);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void openThreeOne() {
        dialog.setContentView(R.layout.three_one);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void openThreeTwo() {
        dialog.setContentView(R.layout.three_two);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void openFourOne() {
        dialog.setContentView(R.layout.four_one);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void openFourTwo() {
        dialog.setContentView(R.layout.four_two);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}