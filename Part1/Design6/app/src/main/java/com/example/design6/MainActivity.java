package com.example.design6;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String[] name = {"Nguyen Nghia", "Hoang Minh", "Pham Thu", "Tran Phuc"};
    ArrayList<Item> arr;
    MyArrayAdapter myArrayAdapter;
    CheckBox checkbox;
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
        btn = findViewById(R.id.button);
        arr = new ArrayList<>();
        checkbox = findViewById(R.id.checkBox2);
        for (int i = 0; i < name.length; i++) {
            arr.add(new Item(name[i]));
        }
        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, arr);
        AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setTitle("Multi Dialog:");
                myDialog.setIcon(R.mipmap.ic_launcher);
                myDialog.setAdapter(myArrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "OnClick SetAdapter", Toast.LENGTH_SHORT).show();
                    }
                });
                myDialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                myDialog.setNeutralButton("NEWTRAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "*(O.0)*", Toast.LENGTH_SHORT).show();
                    }
                });
                myDialog.create().show();
            }
        });
    }
}