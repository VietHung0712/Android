package com.example.bai2_2307;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChildActivity extends AppCompatActivity {
    private TextView textViewWorkerData;
    String[] hangSanXuat = {"___", "AAA", "BBB", "CCC"};
    String[] xuatSu = {"VIETNAM", "VIETNAM", "CHINA", "CHINA", "ENGLAND"};
    String namSx;

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
        textViewWorkerData = findViewById(R.id.textViewWorkerData);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        showWorkerData();
    }

    private void showWorkerData() {
        String jsonData0 ="[";
        for(int i = 0; i < hangSanXuat.length; i++){
            jsonData0 = jsonData0.concat("{\"hangSX\": \"" + hangSanXuat[i] + "\", \"xuatSu\": " + xuatSu[i] + "},");
        }
        String jsonData = jsonData0.substring(0, jsonData0.length()-1).concat("]");
        Log.e("JSONDATA", jsonData );
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            StringBuilder dataBuilder = new StringBuilder();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("hangSX");
                String salary = jsonObject.getString("xuatSu");
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