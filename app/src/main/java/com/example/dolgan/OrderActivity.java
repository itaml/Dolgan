package com.example.dolgan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dolgan.model.Order;
import com.example.dolgan.model.Tovar;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ListView orders_list = findViewById(R.id.order);

        List<String> tovarsTitle = new ArrayList<>();
        for (Tovar c: SecondActivity.fullTovar) {
            if(Order.items_id.contains(c.getId()))
                tovarsTitle.add(c.getTitle());
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tovarsTitle));
    }
}