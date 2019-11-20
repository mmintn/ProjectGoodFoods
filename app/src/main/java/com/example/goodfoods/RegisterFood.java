package com.example.goodfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.goodfoods.DB.Usermanager;
import com.example.goodfoods.model.User;

public class RegisterFood extends AppCompatActivity {
    private EditText Username;
    private EditText mFullname;
    private EditText Password;
    private Button Register;

    private Context Context;
    private Usermanager Manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_food);
        Manager = new Usermanager(this);
        Context = this;
        mFullname = findViewById(R.id.full_name_edit_text);
        Username = findViewById(R.id.username_edit_text);
        Password = findViewById(R.id.password_edit_text);

        Register = findViewById(R.id.register_button);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String fullname = mFullname.getText().toString();
                String username = Username.getText().toString().trim().toLowerCase();
                String password = Password.getText().toString();


                User user = new User(username, password);
                long rowId = Manager.registerUser(user);



                if (TextUtils.isEmpty(Username.getText()) && TextUtils.isEmpty(Password.getText()) && TextUtils.isEmpty(mFullname.getText())) {
                    Toast.makeText(Context, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Context, "Register successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterFood.this, LoginGoodfood.class);
                    startActivity(intent);
                }

            }


        });
    }
}
