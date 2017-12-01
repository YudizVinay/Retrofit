package com.vinay.retrofitlib;


import com.vinay.retrolib.API;
import com.vinay.retrolib.APICallBack;
import com.vinay.retrolib.interfaces.OnApiResponseListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Vinay Rathod on 18/05/16.
 */
public class APICall {

    private static AppDataAPI api;

    // "https://jsonplaceholder.typicode.com/posts" -> to get all post
    private static final String POSTS = "posts";

    // "https://jsonplaceholder.typicode.com/posts/3" -> to get third post
    private static final String GET_POST = POSTS + "/{ID}";

    static {
        try {
            API.Builder builder = new API.Builder("https://jsonplaceholder.typicode.com/");
//            builder.setHeader("Authentication", token);
//            builder.setHeader("Authentication", user, name);
            api = builder.build().create(AppDataAPI.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getPost(OnApiResponseListener<ArrayList<Post>> listener) {
        api.getPost().enqueue(new APICallBack<>(listener, 1));
    }

    public static void getPostById(String id, OnApiResponseListener<Post> listener) {
        api.getPost(id).enqueue(new APICallBack<>(listener, 2));
    }

    private interface AppDataAPI {

        @GET(POSTS)
        Call<ArrayList<Post>> getPost();

        @GET(GET_POST)
        Call<Post> getPost(@Path("ID") String id);

    }
}
