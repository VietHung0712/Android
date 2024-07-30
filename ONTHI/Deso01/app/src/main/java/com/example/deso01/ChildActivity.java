package com.example.deso01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChildActivity extends AppCompatActivity {
    EditText edtMa, edtTen, edtDongia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtMa = findViewById(R.id.edtMa);
        edtTen = findViewById(R.id.edtTen);
        edtDongia = findViewById(R.id.edtGia);
        Intent intent = getIntent();
        String maString = intent.getStringExtra("ma");
        String tenString = intent.getStringExtra("ten");
        double dongia = intent.getDoubleExtra("dongia", 0);
        edtDongia.setText(String.valueOf(dongia));
        edtTen.setText(tenString);
        edtMa.setText(maString);
    }
}