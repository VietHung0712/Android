package com.example.bai3_2307;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button btnThem, btnXem, btnLuu, btnXoa;
    EditText edtID, edtTen;
    ListView lv;

    ArrayList<String> arrListID;
    ArrayList<String> arrListTen;

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
        addControl();
        setOnClickButton();
    }

    void addControl() {
        btnThem = findViewById(R.id.btnThem);
        btnXem = findViewById(R.id.btnXem);

        arrListID = new ArrayList<>();
        arrListTen = new ArrayList<>();

    }

    void setOnClickButton() {

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                myDialog.setTitle("Quản lí Album:");
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.layout_dialog, null);
                myDialog.setView(dialogView);

                myDialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                myDialog.create().show();

                btnLuu = dialogView.findViewById(R.id.btnLuu);
                btnXoa = dialogView.findViewById(R.id.btnXoa);
                edtID = dialogView.findViewById(R.id.edtID);
                edtTen = dialogView.findViewById(R.id.edtTen);


                btnXoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtID.setText(null);
                        edtTen.setText(null);
                    }
                });

                btnLuu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String id = edtID.getText().toString();
                        String ten = edtTen.getText().toString();
                        if (!id.isEmpty() && !ten.isEmpty()) {
                            arrListID.add(id);
                            arrListTen.add(ten);
                        }
                        Toast.makeText(MainActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                        edtID.setText(null);
                        edtTen.setText(null);
                        edtID.setHint(id);
                        edtTen.setHint(ten);
                    }
                });
            }
        });


        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                myDialog.setTitle("Danh sách Album:");
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.layout_dialog_2, null);
                myDialog.setView(dialogView);

                myDialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                myDialog.create().show();

                lv = dialogView.findViewById(R.id.lv);

                ArrayList<String> arrayList = new ArrayList<>();

                if(arrListID.size()>0){
                    for(int i = 0; i < arrListID.size(); i++){
                        String item = arrListID.get(i) + " - " + arrListTen.get(i);
                        arrayList.add(item);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
                    lv.setAdapter(arrayAdapter);
                }
            }
        });
    }
}