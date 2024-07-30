package com.example.baitap_kiemtra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CAIDATBANDO extends AppCompatActivity {
    Button btnExit, btnNext, btnChoose;
    RadioGroup radioGroup;
    CheckBox checkBox1, checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_caidatbando);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnChoose = findViewById(R.id.btn2Choose);
        btnExit = findViewById(R.id.btn2Exit);
        btnNext = findViewById(R.id.btn2Next);
        radioGroup = findViewById(R.id.radioGroupB);
        checkBox1 = findViewById(R.id.checkBoxB1);
        checkBox2 = findViewById(R.id.checkBoxB2);

        setOnClickButton();
    }

    private void setOnClickButton() {
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioButtonIsChecked = radioGroup.getCheckedRadioButtonId();
                String loaiBanDo = "";
                if(idRadioButtonIsChecked!=-1){
                    RadioButton radioButtonIsChecked = findViewById(idRadioButtonIsChecked);
                    loaiBanDo = radioButtonIsChecked.getText().toString();
                }else {
                    loaiBanDo = "Chưa chọn loại bản đồ!";
                }

                String thuocTinh = "";
                if (checkBox1.isChecked()) {
                    thuocTinh = thuocTinh.concat(checkBox1.getText().toString() + " ");
                }
                if (checkBox2.isChecked()) {
                    thuocTinh = thuocTinh.concat(checkBox2.getText().toString());
                }

                String msg = "Loai ban do: " + loaiBanDo + "\nThuoc tinh: " + thuocTinh;
                Toast.makeText(CAIDATBANDO.this, msg, Toast.LENGTH_LONG).show();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CAIDATBANDO.this, PHEPHAIQUANSU.class);
                startActivity(intent);
            }
        });
    }
}