package com.example.examplespinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = new ArrayList<>();
        list.add("Siêu nhân gao");
        list.add("Siêu nhân cuồng phong");
        list.add("Siêu nhân khủng long");
        list.add("Siêu nhân điện quang");
        list.add("Siêu nhân dế");
        list.add("Siêu nhân phép thuật");

        Spinner spinner = findViewById(R.id.id_spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//Gọi lệnh này để hiển thị danh sách cho Spinner
        spinner.setAdapter(spinnerAdapter);//set Adapter trên vào thằng spinner, đưa dữ liệu vào Adapter rồi thì bây giờ chỉ việc đưa nó lên thằng Spinner

        //Khi có Item nào được chọn thì Spinner sẽ giải phóng sự kiện, chúng ta implement giao diện OnItemSelectedListerner để bắt lấy sự kiện đó
        // có 2 phương thức phải override lại là onItemSelected() và onNothingSelected().
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //hàm này khi có một sự kiện chọn item nào đó, sau đó chuyển thành string r gán cho cái Toast
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String msg = "position :" + position + " value :" + list.get(position);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }

            //hàm này khi click vào Spinner mà không chọn item nào cả
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(MainActivity.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}