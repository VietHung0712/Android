package com.example.baitap_kiemtra;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DanhSachNguoiChoi extends AppCompatActivity {
    Button btn;

    String[] ten = {"TranVietHung", "HoangDuyTuan"};
    int[] tuoi = {20, 21};
    ArrayList<ItemDanhSach> arrList;
    MyArrayAdapter myArrayAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_nguoi_choi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn = findViewById(R.id.btnDisplay);
        listView = findViewById(R.id.listView4);
        arrList = new ArrayList<>();
        for(int i = 0; i < ten.length; i++){
            arrList.add(new ItemDanhSach(ten[i], tuoi[i]));
        }
        myArrayAdapter = new MyArrayAdapter(DanhSachNguoiChoi.this, R.layout.layout_item_danhsachnguoichoi, arrList);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(myArrayAdapter);
            }
        });
    }
}