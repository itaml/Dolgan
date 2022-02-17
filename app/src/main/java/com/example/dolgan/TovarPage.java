package com.example.dolgan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dolgan.model.Order;

public class TovarPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tovar_page);

        ImageView tovarImage = findViewById(R.id.tovarPageImage);
        TextView tovarTitle = findViewById(R.id.tovarPageTitle);
        TextView tovarInfo = findViewById(R.id.tovarPageInfo);
        TextView tovarPrice = findViewById(R.id.tovarPagePrice);

        tovarImage.setImageResource(getIntent().getIntExtra("tovarImage",0));
        tovarTitle.setText(getIntent().getStringExtra("tovarTitle"));
        tovarInfo.setText(getIntent().getStringExtra("tovarInfo"));
        tovarPrice.setText(getIntent().getStringExtra("tovarPrice"));
    }

    public void addToCart(View view)
    {
        int item_id = getIntent().getIntExtra("tovarId",0);
        Order.items_id.add(item_id);
        Toast.makeText(this,"Добавлено", Toast.LENGTH_LONG).show();
    }
}