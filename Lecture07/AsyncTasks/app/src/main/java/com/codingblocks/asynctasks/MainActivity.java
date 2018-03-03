package com.codingblocks.asynctasks;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "ASYNC";
    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String arg = editText.getText().toString();
                int delay = arg.isEmpty() ? 0 : Integer.valueOf(arg);
                CounterTask task = new CounterTask();
                task.execute(delay);
            }
        });
    }

    class CounterTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: ");
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            Log.d(TAG, "doInBackground: started");
            int n = 5;
            if (integers.length > 0) {
                n = integers[0];
            }
            for (int i = 0; i < n; i++) {
                wait1Sec();
                Log.d(TAG, "doInBackground: iteration = " + i);
                publishProgress(i+1);
            }
            Log.d(TAG, "doInBackground: ended");
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (values.length > 0) {
                textView.setText(String.valueOf(values[0]));
            }
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d(TAG, "onPostExecute: ");
            super.onPostExecute(aVoid);
            textView.setText("DONE");

        }
    }

    static void wait1Sec() {
        long startTime = SystemClock.elapsedRealtime();
        while (SystemClock.elapsedRealtime() < startTime + 1000);
    }
    static void waitNSec(int n) {
        for (int i = 0; i < n; i++) {
            wait1Sec();
        }
    }
}
