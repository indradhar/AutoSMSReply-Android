package com.example.project_v1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomMessage extends AppCompatActivity
{
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.custom_message);

            Button button = (Button)findViewById(R.id.btn1);
            EditText editText=(EditText)findViewById(R.id.edit1);
            EditText editText1=(EditText)findViewById(R.id.edit2);

            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    final String incoming=editText.getText().toString();
                    final String outgoing=editText1.getText().toString();

                    if(incoming.length()!=0 && outgoing.length()!=0)
                    {
                        saveDatabase(incoming,outgoing);
                    }
                    else if(incoming.length()==0)
                    {
                        Toast.makeText(CustomMessage.this, "Enter incoming message", Toast.LENGTH_SHORT).show();
                    }
                    else if(outgoing.length()==0)
                    {
                        Toast.makeText(CustomMessage.this, "Enter outgoing message", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
        public void saveDatabase(String incoming, String outgoing)
        {
            SQLiteDatabase db;
            db = openOrCreateDatabase("DATABASE_MESSAGES",MODE_PRIVATE,null);
            db.execSQL("Create table if not exists custom_messages (incomingmessage varchar(100),outgoingmessage varchar(100))");
            try
            {
                db.execSQL("insert into custom_messages(incomingmessage,outgoingmessage) values('"+incoming+"','"+outgoing+"')");
                Toast.makeText(CustomMessage.this, "Message inserted", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e)
            {
                Toast.makeText(CustomMessage.this, "Error : "+e, Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(CustomMessage.this,MainActivity.class);
            startActivity(intent);
        }
}
