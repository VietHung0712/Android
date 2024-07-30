package com.example.design7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtChiSoCuoi, edtChiSoDau, edtGia;
    Button btnThanhToan, btnBoQua;
    ImageButton btnGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtChiSoCuoi = findViewById(R.id.edtChiSoCuoi);
        edtChiSoDau = findViewById(R.id.edtChiSoDau);
        edtGia = findViewById(R.id.edtGia);
        btnThanhToan = findViewById(R.id.button);
        btnBoQua = findViewById(R.id.button2);
        btnGia = findViewById(R.id.imageButton);

        Event();
    }

    public double Price() {
        double chiSoDau = Double.parseDouble(edtChiSoDau.getText().toString());
        double chiSoCuoi = Double.parseDouble(edtChiSoCuoi.getText().toString());
        double soDien = chiSoCuoi - chiSoDau;

        double gia = 0;
        if (soDien < 50) {
            gia = 1000;
        } else if (50 <= soDien && soDien < 100) {
            gia = 1500;
        } else {
            gia = 2000;
        }
        return gia;
    }

    public void Event() {
        btnGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtGia.setText(String.valueOf(Price()));
            }
        });

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double chiSoDau = Double.parseDouble(edtChiSoDau.getText().toString());
                double chiSoCuoi = Double.parseDouble(edtChiSoCuoi.getText().toString());
                double soDien = chiSoCuoi - chiSoDau;

                double thanhTien = Price() * soDien;

                Intent intent = new Intent(MainActivity.this, ChildActivity.class);
                intent.putExtra("thanhTien", thanhTien);
                intent.putExtra("soDien", soDien);
                edtGia.setText(String.valueOf(Price()));
                startActivity(intent);
            }
        });
    }
}