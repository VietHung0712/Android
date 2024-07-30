package com.example.deso04;

import android.content.Intent;
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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnThem, btnSua, btnXoa;
    EditText edtTen, edtSDT;
    ArrayList<DanhBa> arrayList;
    ArrayAdapter<DanhBa> arrayAdapter;
    ListView lv;

    String[] ten = {"Bui Thanh Mai", "Pham Van Hung"};
    String[] sdt = {"0912345678", "0915346987"};
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
        btnThem = findViewById(R.id.btnThem);
        edtTen = findViewById(R.id.edtTen);
        edtSDT = findViewById(R.id.edtSDT);
        lv = findViewById(R.id.lv);

        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        for (int i = 0; i < ten.length; i++){
            arrayList.add(new DanhBa(ten[i], sdt[i]));
        }

        lv.setAdapter(arrayAdapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String tenString = edtTen.getText().toString();
                    String sdtString = edtSDT.getText().toString();
                    arrayList.add(new DanhBa(tenString, sdtString));
                    arrayAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Bạn đã thêm thành công số điện thoại " + sdtString + " vào danh bạ", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = arrayList.get(i).getSoDienThoai();
                Toast.makeText(MainActivity.this, "Bạn đã lấy số điện thoại " + item, Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + item));
                startActivity(callIntent);
            }
        });

    }
}