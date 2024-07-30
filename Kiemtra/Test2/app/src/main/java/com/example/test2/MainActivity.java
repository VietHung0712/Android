package com.example.test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
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
        CheckBox cBIphone = findViewById(R.id.checkBox);
        CheckBox cBAndroid = findViewById(R.id.checkBox2);
        CheckBox cBWindow = findViewById(R.id.checkBox3);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String list = cBIphone.getText() + ": " + cBIphone.isChecked() + "\t" + cBAndroid.getText() + ": " + cBAndroid.isChecked() + "\n" + cBWindow.getText() + ": " + cBWindow.isChecked();
                Toast.makeText(MainActivity.this, list, Toast.LENGTH_SHORT).show();
            }
        });
    }
}