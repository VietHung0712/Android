package com.example.design2;

import android.annotation.SuppressLint;
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
    EditText edtUser, edtPass;
    Button btnLogin, btnCancel, btnForget;
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

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);

        btnLogin = findViewById(R.id.button);
        btnCancel = findViewById(R.id.button2);
        btnForget = findViewById(R.id.button3);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtUser.getText().toString();
                String passWord = edtPass.getText().toString();
                if(userName.equals("uneti") && passWord.equals("uneti-k14")){
                    Toast.makeText(MainActivity.this, "User Name & Password đã nhập đúng!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Sai UserName hoặc Password!" + userName + " " + passWord, Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                Toast.makeText(MainActivity.this, "User Name: "+user + " /Password: " + pass, Toast.LENGTH_LONG).show();
            }
        });

        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtUser.setText(null);
                edtPass.setText(null);
                edtUser.requestFocus();
            }
        });
    }
}