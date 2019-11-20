package com.example.goodfoods;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.goodfoods.R;

import org.w3c.dom.Text;

public class deliveryActivity extends AppCompatActivity {
    private Button Confriem;
    private EditText Address;
    private EditText Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        Address = findViewById(R.id.address);
        Phone = findViewById(R.id.phon);
        Confriem = findViewById(R.id.confrimButton_last);

        Confriem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(Address.getText()) && TextUtils.isEmpty(Phone.getText())) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(deliveryActivity.this);

                    dialog.setMessage(R.string.confriem_fail);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            //todo:
                        }
                    });
                    dialog.show();
                }else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(deliveryActivity.this);
                    dialog.setTitle("ขอบคุณสำหรับการสั่งซื้อ");
                    dialog.setMessage(R.string.confriem);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            //todo:
                        }
                    });
                    dialog.show();
                }
            }
        });

    }
}