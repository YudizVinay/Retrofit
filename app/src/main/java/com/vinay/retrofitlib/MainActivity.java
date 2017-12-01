package com.vinay.retrofitlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vinay.retrolib.interfaces.OnApiResponseListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APICall.getPost(new OnApiResponseListener<ArrayList<Post>>() {
            @Override
            public void onResponseComplete(ArrayList<Post> clsGson, int requestCode) {
                Log.d("Tag", "response: " + clsGson.size());
            }

            @Override
            public void onResponseError(String errorMessage, int requestCode) {
                Log.e("Tag", "Error: " + errorMessage);
            }
        });

        APICall.getPostById("1", new OnApiResponseListener<Post>() {
            @Override
            public void onResponseComplete(Post clsGson, int requestCode) {
                Log.d("Tag", "response: " + clsGson.toString());
            }

            @Override
            public void onResponseError(String errorMessage, int requestCode) {
                Log.e("Tag", "Error: " + errorMessage);
            }
        });
    }
}
