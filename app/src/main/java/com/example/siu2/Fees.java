package com.example.siu2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Fees extends AppCompatActivity {

    Dialog dialog;
    TextView Fees_cse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fees);
        //Hooks
        Fees_cse = (TextView) findViewById(R.id.fees_cse);
        dialog = new Dialog(this);

        //Buttons
        Fees_cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOneOne();
            }
        });

    }

    private void openOneOne() {
        dialog.setContentView(R.layout.fees_cse);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}