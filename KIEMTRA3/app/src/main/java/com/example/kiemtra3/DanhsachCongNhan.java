package com.example.kiemtra3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DanhsachCongNhan extends AppCompatActivity {

    private TextView textViewWorkerData;
    private Button buttonShowData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danhsach_cong_nhan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewWorkerData = findViewById(R.id.textViewWorkerData);
        buttonShowData = findViewById(R.id.buttonShowData);

        buttonShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWorkerData();
            }
        });
    }
    private void showWorkerData() {
        String jsonData = "[{\"name\": \"Nguyen Van A\", \"salary\": 5000000}, " +
                "{\"name\": \"Tran Thi B\", \"salary\": 6000000}]";

        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            StringBuilder dataBuilder = new StringBuilder();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                int salary = jsonObject.getInt("salary");
                dataBuilder.append("Tên công nhân: ").append(name)
                        .append("\nLương: ").append(salary)
                        .append("\n\n");
            }

            textViewWorkerData.setText(dataBuilder.toString());

        } catch (JSONException e) {
            e.printStackTrace();
            textViewWorkerData.setText("Lỗi khi phân tích dữ liệu.");
        }
    }
}