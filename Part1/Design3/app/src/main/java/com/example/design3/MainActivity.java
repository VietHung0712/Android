package com.example.design3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
 
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtText;
    ListView listView;
    ArrayList<String> arr;

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
        txtText = findViewById(R.id.textViewResult);
        listView = findViewById(R.id.listView1);
        arr = new ArrayList<String>();

        arr.add("1. Số nguyên từ 1 đến 100");
        arr.add("2. Tính 12 x 7 x 1995");
        arr.add("3. Số chẵn từ 1 đến 100");
        arr.add("4. Số lẻ từ 1 đến 100");
        arr.add("5. Số PI");
        arr.add("6. Tên trường Uneti");
        arr.add("7. Số hoàn hảo từ 1 đến 100");
        arr.add("8. 50 chữ số Fibonacci");

        ArrayAdapter ad = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arr
        );
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String) listView.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, value + "( vị trí: " + (i + 1) + ")", Toast.LENGTH_SHORT).show();
                String result = "";
                switch (i) {
                    case 0:
                        result = Tong1den100() + "";
                        break;
                    case 1:
                        result = (12*7*1995) + "";
                        break;
                    case 2:
                        result = soChanTu1Den100();
                        break;
                    case 3:
                        result = soLeTu1Den100();
                        break;
                    case 4:
                        result = Math.PI + "";
                        break;
                    case 5:
                        result = "UNIVERSITY OF ECONOMICS - TECHNOLOGY FOR INDUSTRIES";
                        break;
                    case 6:
                        result = soHoanHao1Den100();
                        break;
                    case 7:
                        result = day50SoFinaccboci();
                        break;
                    default:
                        
                        break;
                }
                txtText.setText(result);
            }
        });
    }

    int Tong1den100(){
        int val0 = 0;
        int k = 1;
        while (k <= 100) {
            val0 += k;
            k++;
        }
        return val0;
    }

    String soChanTu1Den100(){
        String val = "";
        for(int i = 1; i <= 100; i++){
            if(i%2==0){
                val += " " + i;
            }
        }
        return val;
    }

    String soLeTu1Den100(){
        String val = "";
        for(int i = 1; i <= 100; i++){
            if(i%2!=0){
                val += " " + i;
            }
        }
        return val;
    }

    boolean isPerfectNumber(int number) {
        int sum = 1;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number && number != 1;
    }

    String soHoanHao1Den100(){
        String val = "";
        for (int i = 2; i <= 100; i++) {
            if (isPerfectNumber(i)) {
                val += " " + i;
            }
        }
        return val;
    }

    long isFinaccboci(int n){
        if(n == 0) return 0;
        if(n <= 2) return 1;
        return isFinaccboci(n-1) + isFinaccboci(n-2);
    }

    String day50SoFinaccboci(){
        String val = "";
        for(int i = 0; i < 50 ; i++){
            val = val.concat(" " + isFinaccboci(i));
        }
        return val;
    }

}