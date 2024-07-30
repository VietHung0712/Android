package com.example.design5;

import static com.example.design5.R.layout.activity_main;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int[] number = {1,2,3,4,5,6};
    String[] hoTen = {"Pham Thanh Toan", "Do Dinh Tien", "Bui Thi Hoa Mai", "Nguyen Thi Tra", "Tran Viet Hung", "Le Phi Vu"};
    int[] phone = {12345678, 87654321, 14785236, 98745612, 36985214, 65432197};
    int[] color = {Color.BLUE, Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.BLACK};

    ArrayList<Item> myList;
    MyArrayAdapter myArrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listView);
        myList = new ArrayList<>();
        for(int i = 0; i < number.length; i++){
            myList.add(new Item(number[i], hoTen[i], phone[i], color[i]));
        }
        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, myList);
        listView.setAdapter(myArrayAdapter);
    }
}