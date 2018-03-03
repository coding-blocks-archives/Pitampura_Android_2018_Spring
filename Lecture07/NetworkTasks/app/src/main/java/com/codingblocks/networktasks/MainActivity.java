package com.codingblocks.networktasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    EditText etUrl;
    Button btnGo;
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvData = findViewById(R.id.tvData);
        btnGo = findViewById(R.id.btnGo);
        etUrl = findViewById(R.id.etUrl);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DownloadTask task = new DownloadTask(etUrl.getText().toString());
                    task.execute();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "URL format is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class DownloadTask extends AsyncTask<String, Void, String> {
        URL url;
        DownloadTask(String urlString) throws MalformedURLException {
            url = new URL(urlString);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URLConnection connection = url.openConnection();
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String buf = br.readLine();
                while (buf != null) {
                    sb.append(buf);
                    buf = br.readLine();
                }
                return sb.toString();

            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvData.setText(s);
        }
    }

}
