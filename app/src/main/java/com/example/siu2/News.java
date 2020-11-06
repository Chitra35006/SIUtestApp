package com.example.siu2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import pl.droidsonroids.gif.GifImageView;

public class News extends AppCompatActivity {
    ImageView  NewsTwo, NewsThree, NewsFour, NewsFive;
    GifImageView NewsOne;
    StorageReference NewsRefOne, NewsRefTwo, NewsRefThree, NewsRefFour, NewsRefFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news);
        //Hooks
        NewsOne = (GifImageView) findViewById(R.id.news_1);
        NewsTwo = (ImageView) findViewById(R.id.news_2);
        NewsThree = (ImageView) findViewById(R.id.news_3);
        NewsFour = (ImageView) findViewById(R.id.news_4);
        NewsFive = (ImageView) findViewById(R.id.news_5);

        NewsRefOne = FirebaseStorage.getInstance().getReference("News/news1.jpg");
        NewsRefTwo = FirebaseStorage.getInstance().getReference("News/news2.jpg");
        NewsRefThree = FirebaseStorage.getInstance().getReference("News/news3.jpg");
        NewsRefFour = FirebaseStorage.getInstance().getReference("News/news4.jpg");
        NewsRefFive = FirebaseStorage.getInstance().getReference("News/news5.jpg");

        try{
            final File localFile = File.createTempFile("news1","jpg");
            NewsRefOne.getFile(localFile)
                    .addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            NewsOne.setImageBitmap(bitmap);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            final File localFile = File.createTempFile("news2","jpg");
            NewsRefTwo.getFile(localFile)
                    .addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            NewsTwo.setImageBitmap(bitmap);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            final File localFile = File.createTempFile("news3","jpg");
            NewsRefThree.getFile(localFile)
                    .addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            NewsThree.setImageBitmap(bitmap);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            final File localFile = File.createTempFile("news4","jpg");
            NewsRefFour.getFile(localFile)
                    .addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            NewsFour.setImageBitmap(bitmap);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            final File localFile = File.createTempFile("news5","jpg");
            NewsRefFive.getFile(localFile)
                    .addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            NewsFive.setImageBitmap(bitmap);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}