package com.riskiwr.kuiskalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvJawaban;
    TextView tvStatus;

    Button btnJawaban;


    boolean status;
    String jawaban;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        bindView();
        getParam();
        initData();
    }

    private void initData() {
        tvJawaban.setText(jawaban);
        tvStatus.setText(status ? "Benar" : "Salah");
    }


    private void getParam() {
        Intent intent = getIntent();
        status = intent.getBooleanExtra("status", false);
        jawaban = intent.getStringExtra("jawaban");
    }

    private void bindView() {
        tvJawaban = findViewById(R.id.tvJawaban);
        tvStatus = findViewById(R.id.tvStatus);
        btnJawaban = findViewById(R.id.btn_jawaban);

        if(status){
            btnJawaban.setVisibility(View.GONE);
        }else{
            tvJawaban.setVisibility(View.INVISIBLE);
        }


        btnJawaban.setOnClickListener(view -> {
            tvJawaban.setVisibility(View.VISIBLE);
        });
    }
}