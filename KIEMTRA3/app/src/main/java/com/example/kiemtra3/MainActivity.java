package com.example.kiemtra3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnSignin, btnExit;
    EditText edtUser, edtPass;
    Intent myIntent;
    @SuppressLint("MissingInflatedId")
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
        btnExit = findViewById(R.id.btn1Exit);
        btnSignin = findViewById(R.id.btnSignIn);
        edtPass = findViewById(R.id.edt1Password);
        edtUser = findViewById(R.id.edt1Username);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                if(user.equals("cnttk13hn") && pass.equals("cnttk13")){
                    myIntent = new Intent(MainActivity.this, DANGKIMONHOC.class);
                    startActivity(myIntent);
                }else {
                    Toast.makeText(MainActivity.this, "Sai thong tin dang nhap", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}