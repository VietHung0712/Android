package com.example.design12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btn_add, btn_sub, btn_mul, btn_div;
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
        addControl();
        clickButton(btn_add);
        clickButton(btn_div);
        clickButton(btn_mul);
        clickButton(btn_sub);
    }

    void addControl(){
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btn_add = findViewById(R.id.button);
        btn_sub = findViewById(R.id.button2);
        btn_mul = findViewById(R.id.button3);
        btn_div = findViewById(R.id.button4);
    }

    void clickButton(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtA.length() > 0 && edtB.length() > 0) {
                    int a = Integer.parseInt(edtA.getText().toString());
                    int b = Integer.parseInt(edtB.getText().toString());
                    int c = 0;
                    if(btn.getId()== btn_add.getId()){
                        c = 1;
                    }else if(btn.getId()== btn_sub.getId()){
                        c = 2;
                    }else if(btn.getId()== btn_mul.getId()){
                        c = 3;
                    }else if(btn.getId()== btn_div.getId()) {
                        c = 4;
                    }
                    Intent intent = new Intent(MainActivity.this, ChiidActivity.class);
                    intent.putExtra("a", a);
                    intent.putExtra("b", b);
                    intent.putExtra("c", c);
                    startActivityForResult(intent, 99);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == 33) {
            double kq = 0;
            if (data != null) {
                kq = data.getDoubleExtra("result", 0);
            }
            edtKQ.setText(String.valueOf(kq));
        }
    }
}