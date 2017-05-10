package com.example.yurii.redbuttom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yurii.redbuttom.model.User;

public class RegistartionActivity extends AppCompatActivity {

    private EditText name;
    private EditText sername;
    private EditText age;
    private EditText phone;
    private Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        name = (EditText) findViewById(R.id.editName);
        sername = (EditText) findViewById(R.id.editSername);
        age = (EditText) findViewById(R.id.editAge);
        phone = (EditText) findViewById(R.id.editPhone);

        String stringAge = age.toString();

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(name.toString(), sername.toString(), Intent.parseIntent(stringAge),phone.toString());
            }
        });
    }

}
