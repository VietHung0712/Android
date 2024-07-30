package com.example.design12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChiidActivity extends AppCompatActivity {
    Button btnReturn;
    EditText edtKQ2;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chiid);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnReturn = findViewById(R.id.btnReturn);
        edtKQ2 = findViewById(R.id.edtKQ2);
        intent = getIntent();
        int a = intent.getIntExtra("a", 0);
        int b = intent.getIntExtra("b", 0);
        int c = intent.getIntExtra("c", 0);
        double result = 0;
        if(c == 1){
            result = a + b;
        }else if(c == 2){
            result = a - b;
        }else if(c == 3){
            result = a * b;
        }else if(c == 4){
            result = a / b;
        }
        double kq = result;
        edtKQ2.setText(String.valueOf(kq));
        //
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("result", kq);
                setResult(33, intent);
                finish();
            }
        });
    }
}