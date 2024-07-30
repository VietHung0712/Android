package com.example.design1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtC, edtResult;
    Button btn;


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
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        edtResult = findViewById(R.id.edtResult);

        btn = findViewById(R.id.btnResult);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int a = Integer.parseInt(edtA.getText().toString());
                    int b = Integer.parseInt(edtB.getText().toString());
                    int c = Integer.parseInt(edtC.getText().toString());
                    String result = "";
                    double delta = Math.pow(b, 2) - 4*a*c;
                    if(delta < 0){
                        result = "vo nghiem";
                    }else if(delta ==0){
                        double x = - b / (2*a);
                    }else{
                        double x1 = (- b + Math.sqrt(delta))/2/a;
                        double x2 = (c/a)/x1;
                        result = "(" + x1 + ", " + x2 + ")";
                    }
                    edtResult.setText(result+"");
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Loi: "+ex, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}