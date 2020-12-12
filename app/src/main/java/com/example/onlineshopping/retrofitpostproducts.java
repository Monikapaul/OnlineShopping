package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.onlineshopping.R;
import com.example.onlineshopping.api_interfaces.JsonPlaceHolderApi;
import com.example.onlineshopping.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitpostproducts extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retrofitpostproducts);
        textViewResult = findViewById(R.id.text_view_result);
        createPost();
    }
    void createPost(){
        Post post = new Post("high heel sandals", "90", "comfortable");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/Monikapaul/finalproject/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Post> call = jsonPlaceHolderApi.createPost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " +response.code());
                }
                Post postresponse=response.body();
                String content = "";
                content += "id: " +postresponse.getId() + "\n";
                content += "name:" +postresponse.getName() + "\n";
                content += "price:" +postresponse.getPrice() + "\n";
                content += "description:" +postresponse.getDesc() + "\n\n";



                textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
