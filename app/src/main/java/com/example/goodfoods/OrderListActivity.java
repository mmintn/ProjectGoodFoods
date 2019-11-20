package com.example.goodfoods;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.midi.MidiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.goodfoods.adapter.adapterRecyclerView;
import com.example.goodfoods.room_db.MenuRepository;
import com.example.goodfoods.room_db.menu;

import java.util.List;

public class OrderListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        Intent intent = getIntent();
        int amount_saba = Integer.parseInt(intent.getStringExtra("saba"));
        int amount_yok = Integer.parseInt(intent.getStringExtra("yok"));
        int amount_sandwish = Integer.parseInt(intent.getStringExtra("sandwish"));
        int amount_fish = Integer.parseInt(intent.getStringExtra("fish"));

        MenuRepository repo = new MenuRepository(OrderListActivity.this);
        menu m = null;
        if(amount_saba != 0) {
           m = new menu(0, "ปลาซาบะย่าง", amount_saba);
            repo.insertMenu(m, new MenuRepository.InsertCallback() {
                @Override
                public void onInsertSuccess() {
                }
            });
        }
        if(amount_yok != 0) {
            m = new menu(0, "ผัดหมี่หยก", amount_yok);
            repo.insertMenu(m, new MenuRepository.InsertCallback() {
                @Override
                public void onInsertSuccess() {
                }
            });
        }
        if(amount_sandwish != 0) {
            m = new menu(0, "แซนวิชทูน่า-ไข่ต้ม", amount_sandwish);
            repo.insertMenu(m, new MenuRepository.InsertCallback() {
                @Override
                public void onInsertSuccess() {
                }
            });
        }
        if(amount_fish != 0) {
            m = new menu(0, "ยำปลาทู", amount_fish);
            repo.insertMenu(m, new MenuRepository.InsertCallback() {
                @Override
                public void onInsertSuccess() {
                }
            });
        }


        Button confirmButton = findViewById(R.id.buttonConfirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OrderListActivity.this, deliveryActivity.class);
                startActivity(i);

            }
        });

        Button cancelButton = findViewById(R.id.buttonCancel);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuRepository repo = new MenuRepository(OrderListActivity.this);
                repo.deleteMenu(new MenuRepository.deleteCallback() {
                    @Override
                    public void deleteMenu() {
                        onResume();
                    }
                });
                Intent intent = new Intent(OrderListActivity.this, MenuGoodfood.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        reloadData();
    }


    private void reloadData(){
        MenuRepository repo= new MenuRepository(OrderListActivity.this);

        repo.getMenu(new MenuRepository.Callback() {
            @Override
            public void onGetFood(List<menu> itemList) {
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                adapterRecyclerView adapter = new adapterRecyclerView(
                        OrderListActivity.this,
                        R.layout.item_food,
                        itemList

                        );
                recyclerView.setLayoutManager(new LinearLayoutManager(OrderListActivity.this));
                recyclerView.setAdapter(adapter);
            }
        });

    }
}



