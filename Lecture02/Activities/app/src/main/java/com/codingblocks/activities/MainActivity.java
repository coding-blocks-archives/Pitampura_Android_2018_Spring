package com.codingblocks.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etVar1, etVar2;
    Button btnAdd, btnSub, btnMult, btnDiv;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVar1 = findViewById(R.id.etVar1);
        etVar2 = findViewById(R.id.etVar2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        try {
            int a = Integer.valueOf(etVar1.getText().toString());
            int b = Integer.valueOf(etVar2.getText().toString());
            int c = 0;
            switch (v.getId()) {
                case R.id.btnAdd:
                    c = a + b;
                    break;
                case R.id.btnSub:
                    c = a - b;
                    break;
                case R.id.btnMult:
                    c = a * b;
                    break;
                case R.id.btnDiv:
                    c = a / b;
                    break;
            }
            tvResult.setText(String.valueOf(c));
        } catch (NumberFormatException | ArithmeticException e) {
            Toast.makeText(this, "Wrong input or operation", Toast.LENGTH_SHORT).show();
        }
    }
}
