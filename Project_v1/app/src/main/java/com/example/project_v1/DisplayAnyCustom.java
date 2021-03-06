package com.example.project_v1;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DisplayAnyCustom extends AppCompatActivity
{
    ListView lvShow;
    SQLiteDatabase db;
    ArrayList al = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispay_layout);
    /*    Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Custom Message");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        lvShow = findViewById(R.id.lvShow);
        db = openOrCreateDatabase("DATABASE_MESSAGES",MODE_PRIVATE,null);
        load();
        lvShow.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                String data = al.get(position).toString();
                String arr[]= data.split("\n");
                final String name = arr[1];
                AlertDialog.Builder ab = new AlertDialog.Builder(DisplayAnyCustom.this);
                ab.setTitle("Action");
                ab.setMessage("Do you want to delete ?");
                ab.setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        try
                        {
                            db.execSQL("delete from custom_user_messages where name='"+name+"'");
                            al.clear();
                            load();
                        }
                        catch (Exception e)
                        {
                            Toast.makeText(DisplayAnyCustom.this,"Error : "+e,Toast.LENGTH_LONG).show();
                        }
                    }
                });
                ab.setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });
                ab.show();
                return false;
            }
        });
    }
    public void load()
    {
        Cursor cur = db.rawQuery("select * from custom_user_messages", null);
        while(cur.moveToNext())
        {
            String outgoingmessage = cur.getString(0);
            String name=cur.getString(1);
            al.add(outgoingmessage+"\n"+name);
        }
        cur.close();
        ArrayAdapter aa = new ArrayAdapter(DisplayAnyCustom.this,android.R.layout.simple_list_item_1,al);
        lvShow.setAdapter(aa);
    }
}
