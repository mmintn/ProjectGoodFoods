package com.example.goodfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.goodfoods.room_db.MenuRepository;
import com.example.goodfoods.room_db.menu;

public class MenuGoodfood extends AppCompatActivity {

    int amount_saba = 0;
    int amount_yok = 0;
    int amount_sandwish = 0;
    int amount_fish = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_goodfood);

        Button deliveryButton = findViewById(R.id.button_delivery);

        deliveryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuGoodfood.this, OrderListActivity.class);
                i.putExtra("saba",String.valueOf(amount_saba));
                i.putExtra("yok",String.valueOf(amount_yok));
                i.putExtra("sandwish",String.valueOf(amount_sandwish));
                i.putExtra("fish",String.valueOf(amount_fish));
                startActivity(i);
            }
        });

        Button menu1Button = findViewById(R.id.button_menu1);

        menu1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount_saba++;
                Toast t = Toast.makeText(MenuGoodfood.this, "เลือกปลาซาบะย่างแล้ว จำนวน "+ amount_saba +" ที่", Toast.LENGTH_SHORT);
                t.show();


            }
        });

        Button menu2Button = findViewById(R.id.button_menu2);

        menu2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount_yok++;
                Toast t = Toast.makeText(MenuGoodfood.this, "เลือกผัดหมี่หยกแล้ว จำนวน "+ amount_yok+" ที่", Toast.LENGTH_SHORT);
                t.show();



            }
        });

        Button menu3Button = findViewById(R.id.button_menu3);

        menu3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount_sandwish++;
                Toast t = Toast.makeText(MenuGoodfood.this, "เลือกแซนวิชทูน่า-ไข่ต้มแล้ว  จำนวน "+ amount_sandwish+" ที่", Toast.LENGTH_SHORT);
                t.show();



            }
        });

        Button menu4Button = findViewById(R.id.button_menu4);

        menu4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount_fish++;
                Toast t = Toast.makeText(MenuGoodfood.this, "เลือกยำปลาทูแล้ว  จำนวน "+ amount_fish+" ที่", Toast.LENGTH_SHORT);
                t.show();



            }
        });





    }
}
