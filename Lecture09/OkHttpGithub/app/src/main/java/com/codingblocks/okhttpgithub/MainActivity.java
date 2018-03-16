package com.codingblocks.okhttpgithub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    // https://api.github.com/users/the-dagger

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeNetworkCall("https://api.github.com/search/users?q=harshit");
            }
        });
    }

    public void makeNetworkCall(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                final ArrayList<GithubUser> githubUsers = parseJson(result);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    UserAdapter userAdapter = new UserAdapter(githubUsers);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    recyclerView.setAdapter(userAdapter);
                    }
                });
            }
        });

    }

    public ArrayList<GithubUser> parseJson(String s) {
        //Parse the JSON
        ArrayList<GithubUser> githubUserArrayList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("items");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String login = jsonObj.getString("login");
                String url = jsonObj.getString("html_url");
                String profile = jsonObj.getString("avatar_url");
                String score = jsonObj.getString("score");

                Log.e("TAG", "parseJson: " + login);

                GithubUser githubUser = new GithubUser(login, url, profile, score);
                githubUserArrayList.add(githubUser);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("TAG", "parseJson: " + githubUserArrayList.size());
        return githubUserArrayList;
    }

}
