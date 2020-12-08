package com.example.project_v1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.wafflecopter.multicontactpicker.ContactResult;
import com.wafflecopter.multicontactpicker.LimitColumn;
import com.wafflecopter.multicontactpicker.MultiContactPicker;

import java.util.ArrayList;
import java.util.List;

public class CustomUserMessage extends AppCompatActivity
{
    private static final int CONTACT_PICKER_REQUEST = 202;
    List<ContactResult> results=new ArrayList<>();
   public String incoming;
   public String outgoing;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            //Bundle bundle=new Bundle();
            //results=bundle.getParcelableArrayList("contact");

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
                    incoming=editText.getText().toString();
                    outgoing=editText1.getText().toString();

                    if(incoming.length()!=0 && outgoing.length()!=0)
                    {
                        new MultiContactPicker.Builder(CustomUserMessage.this) //Activity/fragment context
                                .hideScrollbar(false) //Optional - default: false
                                .showTrack(true) //Optional - default: true
                                .searchIconColor(Color.WHITE) //Option - default: White
                                .setChoiceMode(MultiContactPicker.CHOICE_MODE_MULTIPLE) //Optional - default: CHOICE_MODE_MULTIPLE
                                .handleColor(ContextCompat.getColor(CustomUserMessage.this, R.color.colorPrimary)) //Optional - default: Azure Blue
                                .bubbleColor(ContextCompat.getColor(CustomUserMessage.this, R.color.colorPrimary)) //Optional - default: Azure Blue
                                .bubbleTextColor(Color.WHITE) //Optional - default: White
                                .setTitleText("Select Contacts") //Optional - default: Select Contacts
                                .setLoadingType(MultiContactPicker.LOAD_ASYNC) //Optional - default LOAD_ASYNC (wait till all loaded vs stream results)
                                .limitToColumn(LimitColumn.NONE) //Optional - default NONE (Include phone + email, limiting to one can improve loading time)
                                .setActivityAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                                        android.R.anim.fade_in,
                                        android.R.anim.fade_out) //Optional - default: No animation overrides
                                .showPickerForResult(CONTACT_PICKER_REQUEST);


                    }
                    else if(incoming.length()==0)
                    {
                        Toast.makeText(CustomUserMessage.this, "Enter incoming message", Toast.LENGTH_SHORT).show();
                    }
                    else if(outgoing.length()==0)
                    {
                        Toast.makeText(CustomUserMessage.this, "Enter outgoing message", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CONTACT_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                results = MultiContactPicker.obtainResult(data);
                Log.d("MyTag", results.get(0).getDisplayName());
            } else if (resultCode == RESULT_CANCELED) {
                System.out.println("User closed the picker without selecting items.");
            }
        }
        Toast.makeText(CustomUserMessage.this, "Message created", Toast.LENGTH_SHORT).show(); //working fine
        saveDatabase(incoming,outgoing);
    }


    public void saveDatabase(String incoming, String outgoing)
        {
            SQLiteDatabase db;
            db = openOrCreateDatabase("DATABASE_MESSAGES",MODE_PRIVATE,null);
            db.execSQL("Create table if not exists custom_custom_messages (incomingmessage varchar(100),outgoingmessage varchar(100),name varchar(100),number varchar(100))");
           // Toast.makeText(CustomUserMessage.this, "Message created", Toast.LENGTH_SHORT).show(); //working fine
            for(int i=0;i<results.size();i++) {
            try
            {
                String name=results.get(i).getDisplayName();
                String number=results.get(i).getPhoneNumbers().get(0).getNumber();
                db.execSQL("insert into custom_custom_messages(incomingmessage,outgoingmessage,name,number) values('"+incoming+"','"+outgoing+"','" + name + "','"+ number +"')");

            }
            catch (Exception e)
            {
                Toast.makeText(CustomUserMessage.this, "Error : "+e, Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(CustomUserMessage.this,MainActivity.class);
            startActivity(intent);
        } Toast.makeText(CustomUserMessage.this, "Message inserted", Toast.LENGTH_SHORT).show();}
}
//need to unpack the bundle and change the database