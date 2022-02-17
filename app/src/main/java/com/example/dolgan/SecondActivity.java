package com.example.dolgan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dolgan.adapter.CategoryAdapter;
import com.example.dolgan.adapter.TovarAdapter;
import com.example.dolgan.model.Category;
import com.example.dolgan.model.Tovar;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, tovarRecycler;
    CategoryAdapter categoryAdapter;
    TextView first;
    Button button;
    static TovarAdapter tovarAdapter;
    static List<Tovar> tovarList = new ArrayList<>();
    static List<Tovar> fullTovar = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tovar);
        first = findViewById(R.id.textView3);
        button = findViewById(R.id.button);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart(view);
            }
        });

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Украшения"));
        categoryList.add(new Category(3,"Мужская одежда"));
        categoryList.add(new Category(2,"Женская одежда"));

        setCategoryRecycler(categoryList);

        List<Tovar> tovarList = new ArrayList<>();
        tovarList.add(new Tovar(1,"first","Гривны","Гривны, изготовлены из серебра 500 пробы","40000 рублей", 1));
        tovarList.add(new Tovar(2,"second","Серьги «ытырга»","Серьги «ытырга» крючкового типа с подвесками","40999 рублей",1));
        tovarList.add(new Tovar(3,"third","Цепь «hyрэк быата»","Цепи с подвесками и крестами «һүрэк быата»","59990 рублей",1));
        tovarList.add(new Tovar(4,"fourth","Парные браслеты ","Нашейные гравированные украшения в комплекте с парными браслетами","30999 рублей",1));
        tovarList.add(new Tovar(5,"fifth","Нашейное украшение)","Нашейные гравированные украшения в комплекте с парными браслетами","18990 рублей",1));
        tovarList.add(new Tovar(6,"sixth","«Карак»)","Узор «Карак» (глаз) дает владельцу зоркий глаз","18999 рублей",1));
        tovarList.add(new Tovar(7,"seventh","Парка «Эриэн hонтап»","Парка приталена, сшита из сукна чёрного цвета.","90000 рублей",2));
        tovarList.add(new Tovar(8,"eighth","Парка «Тирии кыбытыы ардай»","Парка выполнена в технике «меховая мозаика».","80999 рублей",2));
        tovarList.add(new Tovar(9,"ninth","Парка «Тyoстээк haнгыйак»","Зимняя распашная одежда, сшитая из тёмных тельчих шкур","85999 рублей",3));
        tovarList.add(new Tovar(10,"tenth","Парка «hутургу hонтап»","Парка сшита из чёрной ткани","78000 рублей",3));
        tovarList.add(new Tovar(11,"eleven","Шапка «Торго бэргэhэ»","Тканевая мужская шапка.","7800 рублей",3));
        tovarList.add(new Tovar(12,"twelve","Обувь «Огуруолаак»","Обувь с высокими голенищами из тёмных камусов.","15999 рублей",3));

        fullTovar.addAll(tovarList);

        setTovarRecycler(tovarList);
    }

    public void Cart(View view)
    {
        Intent intent = new Intent(this,OrderActivity.class);
        startActivity(intent);
    }

    private void setTovarRecycler(List<Tovar> tovarList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        tovarRecycler = findViewById(R.id.tovarRecycler);
        tovarRecycler.setLayoutManager(layoutManager);

        tovarAdapter = new TovarAdapter(this,tovarList);
        tovarRecycler.setAdapter(tovarAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showTovarsByCategory(int category){
        List<Tovar> filterTovars = new ArrayList<>();

        for(Tovar c: tovarList) {
            if(c.getCategory() == category)
                filterTovars.add(c);
        }

        tovarList.clear();
        tovarList.addAll(filterTovars);

        tovarAdapter.notifyDataSetChanged();
    }


}