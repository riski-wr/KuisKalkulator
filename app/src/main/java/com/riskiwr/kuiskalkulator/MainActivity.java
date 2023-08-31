package com.riskiwr.kuiskalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView tvDaduSatu;
    TextView tvDaduDua;
    TextView tvOperator;

    EditText etJawaban;

    Button btnCek;
    Button btnMulai;
    Button btnPlus;
    Button btnMinus;
    Button btnKali;
    Button btnBagi;

    String operator = "+";
    String jawaban;

    double randomDaduSatu;

    double randomDaduDua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
    }

    private void bindView() {
        tvDaduSatu = findViewById(R.id.dadu_1);
        tvDaduDua = findViewById(R.id.dadu_2);
        tvOperator = findViewById(R.id.operator);
        etJawaban = findViewById(R.id.et_jawaban);
        btnCek = findViewById(R.id.btn_cek);
        btnMulai = findViewById(R.id.btn_acak);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnKali = findViewById(R.id.btn_kali);
        btnBagi = findViewById(R.id.btn_bagi);

        btnMulai.setOnClickListener(view -> {
            mulai();
        });


        btnPlus.setOnClickListener(view -> {
            operator = "+";
            tvOperator.setText(operator);
        });

        btnMinus.setOnClickListener(view -> {
            operator = "-";
            tvOperator.setText(operator);
        });

        btnKali.setOnClickListener(view -> {
            operator = "X";
            tvOperator.setText(operator);
        });

        btnBagi.setOnClickListener(view -> {
            operator = "/";
            tvOperator.setText(operator);
        });



        btnCek.setOnClickListener(view -> {
            cekJawaban();
        });




    }

    private void mulai() {

        // Randomize
        Random rand = new Random();
        randomDaduSatu = rand.nextInt(10);
        randomDaduDua = rand.nextInt(10);

        // Set to view
        tvDaduSatu.setText(Double.toString(randomDaduSatu));
        tvDaduDua.setText(Double.toString(randomDaduDua));

        btnMulai.setVisibility(View.GONE);
        btnCek.setVisibility(View.VISIBLE);

    }

    private void cekJawaban() {

        if(etJawaban.getText().length() > 0){
            calculate();
        }else{
            Toast.makeText(this, "Mohon isi jawaban dulu ygy", Toast.LENGTH_SHORT).show();
        }


    }

    private void calculate() {
        double daduSatu = randomDaduSatu;
        double daduDua = randomDaduDua;

        switch (operator){
            case "+":
                jawaban = String.valueOf(daduSatu + daduDua);
                break;
            case "-":
                jawaban = String.valueOf(daduSatu - daduDua);
                break;
            case "X":
                jawaban = String.valueOf(daduSatu * daduDua);
                break;
            case "/":
                jawaban = String.valueOf(daduSatu / daduDua);
                break;
        }


        if(jawaban.equals(etJawaban.getText().toString())){
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("status", true);
            intent.putExtra("jawaban", jawaban);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("status", false);
            intent.putExtra("jawaban", jawaban);
            startActivity(intent);
        }
    }
}