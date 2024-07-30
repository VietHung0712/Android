package com.example.kiemtrabu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        String msg = "Chức năng này chưa được cập nhật!";
        if (id == R.id.item0) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item1) {
            Intent intent = new Intent(this, Quanlidienthoaikhachhang.class);
            startActivity(intent);
        } else if (id == R.id.item2) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        } else {
            finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }
}