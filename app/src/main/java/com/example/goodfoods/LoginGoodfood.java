package com.example.goodfoods;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.goodfoods.DB.Usermanager;
import com.example.goodfoods.model.User;

public class LoginGoodfood extends AppCompatActivity {

    private Button Loginn;
    private EditText Username;
    private EditText Password;
    private TextView Registerr;
    private Context Context;
    private Usermanager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        manager = new Usermanager(this);

        Context = this;

        Loginn = findViewById(R.id.login_button);
        Username = findViewById(R.id.username_edit_text);
        Password = findViewById(R.id.password_edit_text);
        Registerr = findViewById(R.id.register_button);

        Loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(Username.getText()) && TextUtils.isEmpty(Password.getText())) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(LoginGoodfood.this);
                    dialog.setTitle("Login failed");
                    dialog.setMessage(R.string.login_error_message);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            //todo:
                        }
                    });
                    dialog.show();
                }else {
                    checkLogin();
                }
            }
        });

        Registerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Context, RegisterFood.class);
                startActivity(intent);
            }
        });
    }

    private void checkLogin() {
        String username = Username.getText().toString().trim().toLowerCase();
        String password = Password.getText().toString().trim();
        User user = new User(username, password);

        User validateUser = manager.checkUserLogin(user);

        if (null == validateUser) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(LoginGoodfood.this);
            dialog.setTitle("Invalid username or password");
            dialog.setMessage(R.string.login_error_message);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    //todo:
                }
            });
            dialog.show();
        } else {
            Button LoginButon= findViewById(R.id.buttonConfirm);

            Loginn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(LoginGoodfood.this, MenuGoodfood.class);
                    startActivity(i);

                }
            });
            Loginn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginGoodfood.this, MenuGoodfood.class);
                    startActivity(intent);
                }
            });

        }
    }
    }
