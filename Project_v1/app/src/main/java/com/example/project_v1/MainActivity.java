package com.example.project_v1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 26)//android 8.0
        {
            if (ContextCompat.checkSelfPermission(MainActivity.this, "android.permission.RECEIVE_SMS") != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{"android.permission.RECEIVE_SMS","android.permission.SEND_SMS"},1);
            }
        }
        Button button = (Button)findViewById(R.id.btn1);
        Button button1 = findViewById(R.id.btn2);
        Button button2 = findViewById(R.id.btn3);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startCustomUsers();
            }
        });
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startAllUsers();

            }
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                viewDatabase();
            }
        });

    }
    void startCustomUsers()
    {

    }
    void startAllUsers()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AllUser frame1 = new AllUser();
        fragmentTransaction.replace(R.id.frame1,frame1);
        fragmentTransaction.commit();
    }
    void viewDatabase()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ViewFragment frame1 = new ViewFragment();
        fragmentTransaction.replace(R.id.frame1,frame1);
        fragmentTransaction.commit();
    }
}