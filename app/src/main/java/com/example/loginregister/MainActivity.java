package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.loginregister.adapter.BeverageRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
//bok
public class MainActivity extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id. recycler_view);

        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);


        List<Beverage> allBeverageInfor = getallBeverageInfor();
        BeverageRecyclerViewAdapter beverageRecyclerViewAdapter = new BeverageRecyclerViewAdapter(MainActivity.this,allBeverageInfor);
        recyclerView.setAdapter(beverageRecyclerViewAdapter);

    }

    private List<Beverage> getallBeverageInfor(){

        List<Beverage> allBeverage = new ArrayList<Beverage>();
        allBeverage.add(new Beverage("Event"/**, R.drawable.flat_white**/));
//        allBeverage.add(new Beverage("Long Black"/**, R.drawable.long_black**/));
//        allBeverage.add(new Beverage("Latte"/**, R.drawable.latte_1**/));
//        allBeverage.add(new Beverage("Latte"/**, R.drawable.latte_2**/));
//        allBeverage.add(new Beverage("Long Black"/**, R.drawable.long_black_2**/));
//
//        allBeverage.add(new Beverage("Macchiato"/**, R.drawable.macchiato**/));
//        allBeverage.add(new Beverage("Mochaccino"/**, R.drawable.mochaccino**/));
//        allBeverage.add(new Beverage("Espresso"/**, R.drawable.espresso_1**/));
//        allBeverage.add(new Beverage("Expresso"/**, R.drawable.espresso_2**/));
//        allBeverage.add(new Beverage("Earl Grey"/**, R.drawable.earl_grey**/));
//
//        allBeverage.add(new Beverage("Grean Tea"/**, R.drawable.green_tea**/));
//        allBeverage.add(new Beverage("Capuccino"/**, R.drawable.cappuccino_1**/));
//        allBeverage.add(new Beverage("Capuccino"/**, R.drawable.cappuccino_2**/));

        return allBeverage;

    }

}