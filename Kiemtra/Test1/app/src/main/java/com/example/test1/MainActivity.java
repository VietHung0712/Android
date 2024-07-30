package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String[] name = {"Linux", "Windows7", "Suse", "Eclipse", "Ubuntu", "Solaris", "Android", "Iphone"};
    ArrayList<Item> arr;
    ArrayMyAdapter myArrayAdapter;
    ListView lv;
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
        lv = findViewById(R.id.listView);
        arr = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            arr.add(new Item(name[i]));
        }
        myArrayAdapter = new ArrayMyAdapter(MainActivity.this, R.layout.layout_item, arr);
        lv.setAdapter(myArrayAdapter);

        
    }
}