package com.example.test;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BaoTriXeHoi extends AppCompatActivity {
    CheckBox checkBox, checkBox2;
    RadioGroup radioGroup;
    Button btnChoose, btnNext, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bao_tri_xe_hoi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        btnChoose = findViewById(R.id.btnChoose);
        btnNext = findViewById(R.id.btnNext);
        btnExit = findViewById(R.id.btnExit);

        setOnClickButton();
    }

    private void setOnClickButton(){
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioButtonisSelected = radioGroup.getCheckedRadioButtonId();
                RadioButton radioBtn = findViewById(radioButtonisSelected);

                String dichVuPhapLY = "";
                if(checkBox.isChecked()){
                    dichVuPhapLY = dichVuPhapLY.concat(" " + checkBox.getText().toString());
                }
                if(checkBox2.isChecked()){
                    dichVuPhapLY = dichVuPhapLY.concat(" " + checkBox2.getText().toString());
                }

                String tongHop = "Goi Dich Vu: " + radioBtn.getText().toString() + "\n" + "Dich vu phap ly: \n" + dichVuPhapLY;

                AlertDialog.Builder myDialog = new AlertDialog.Builder(BaoTriXeHoi.this);
                myDialog.setTitle("Thông tin cá nhân:");
                myDialog.setMessage(tongHop);
                myDialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                myDialog.create().show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaoTriXeHoi.this, HangXe.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}