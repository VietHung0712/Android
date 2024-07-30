package com.example.kiemtrabu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class Quanlidienthoaikhachhang extends AppCompatActivity {
    Button btnThem, btnGoi, btnTiep;
    EditText edt;
    ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    String sdt;
    String[] phoneString = {"0928767889", "0934875898", "0979870355"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quanlidienthoaikhachhang);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        setOnClickEvent();
    }
    void addControl(){
        btnGoi = findViewById(R.id.btnGoi);
        btnThem = findViewById(R.id.btnThem);
        btnTiep = findViewById(R.id.btnTiep);
        edt = findViewById(R.id.edt);
        lv = findViewById(R.id.lv);

        arrayList = new ArrayList<>();
        Collections.addAll(arrayList, phoneString);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(arrayAdapter);
    }

    void setOnClickEvent(){
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Quanlidienthoaikhachhang.this, "Đã chọn Thêm", Toast.LENGTH_SHORT).show();
                String txt = edt.getText().toString();
                arrayList.add(txt);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sdt = lv.getItemAtPosition(i).toString();
                edt.setText(sdt);
            }
        });
        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + sdt));
                if (ActivityCompat.checkSelfPermission(Quanlidienthoaikhachhang.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Quanlidienthoaikhachhang.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(callIntent);
            }
        });
        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quanlidienthoaikhachhang.this, DanhSachKhachHang.class);
                startActivity(intent);
            }
        });
    }
}