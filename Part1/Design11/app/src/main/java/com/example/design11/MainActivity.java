package com.example.design11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        Button btn_1 = findViewById(R.id.btn_tinh);
        btn_1.setOnClickListener(new View.OnClickListener() {
            EditText a = findViewById(R.id.Editext1);
            EditText b = findViewById(R.id.Editext2);
            EditText c = findViewById(R.id.Editext3);

            TextView showNO = findViewById(R.id.txt);

            int A = Integer.parseInt(a.getText() + "");
            int B = Integer.parseInt(b.getText() + "");
            int C = Integer.parseInt(c.getText() + "");

            float D = (float) (-B) / (2 * A);
            float denTa = (float) B * B - 4 * A * C;

            @Override
            public void onClick(View view) {
                if (denTa < 0)
                    showNO.setText("PT Vo No" + "");
                else if (denTa == 0) {
                    showNO.setText("Pt No Kep:" + D + "");
                } else {
                    float no1 = (float) (-B - Math.sqrt(denTa)) / (2 * A);
                    float no2 = (float) (-B + Math.sqrt(denTa)) / (2 * A);
                    showNO.setText("No Phan Biet" + no1 + "\t" + no2 + "");
                }
                showNO.setText("Chua Ro Nguyen Nhan");
            }
        });
    }
}