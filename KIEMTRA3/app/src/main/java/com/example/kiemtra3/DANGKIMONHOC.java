package com.example.kiemtra3;

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

public class DANGKIMONHOC extends AppCompatActivity {
    CheckBox checkBox1, checkBox2, checkBox3;
    RadioGroup radioGroup;
    Button btnChoose, btnExit, btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangkimonhoc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        radioGroup = findViewById(R.id.radioGroup);
        btnNext = findViewById(R.id.btn2Next);
        btnChoose = findViewById(R.id.btn2Choose);
        btnExit = findViewById(R.id.btn2Exit);

        setOnClickButton();
    }
    private void setOnClickButton() {
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioButtonIsChecked = radioGroup.getCheckedRadioButtonId();
                String gioiTinh = "";
                if (idRadioButtonIsChecked != -1) {
                    RadioButton radioButtonIsChecked = findViewById(idRadioButtonIsChecked);
                    gioiTinh = radioButtonIsChecked.getText().toString();
                } else {
                    gioiTinh = "Chưa chọn!";
                }

                String monHoc = "";
                if (checkBox1.isChecked()) {
                    monHoc = monHoc.concat(checkBox1.getText().toString() + " ");
                }
                if (checkBox2.isChecked()) {
                    monHoc = monHoc.concat(checkBox2.getText().toString() + " ");
                }
                if (checkBox3.isChecked()) {
                    monHoc = monHoc.concat(checkBox3.getText().toString() + " ");
                }

                String msg = "Mon hoc: " + monHoc + "\n Gioi tinh: " + gioiTinh;
                Toast.makeText(DANGKIMONHOC.this, msg, Toast.LENGTH_LONG).show();
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
                Intent intent = new Intent(DANGKIMONHOC.this, CACLOAIQUA.class);
                startActivity(intent);
            }
        });
    }
}