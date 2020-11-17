package com.example.project_v1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import static android.content.Context.MODE_PRIVATE;

public class DialogueAllUser extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.dialogue_layout, container, false);
        EditText editText=(EditText)view.findViewById(R.id.edit1);
        TextView textView=(TextView)view.findViewById(R.id.view2);
        TextView textView1=(TextView)view.findViewById(R.id.view3);


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=editText.getText().toString();
                if(message.length()!=0)
                {
                    saveDatabase(message);
                }
                else if(message.length()==0)
                {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run()
                        {
                            Toast.makeText(getActivity(), "Enter Any Message", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                getDialog().dismiss();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        return view;
    }
    void saveDatabase(String message)
    {
        SQLiteDatabase db;
        db = getActivity().openOrCreateDatabase("DATABASE_MESSAGES",MODE_PRIVATE,null);
        db.execSQL("Create table if not exists messages (outgoingmessage varchar(100))");

        try
        {
            db.execSQL("insert into messages(outgoingmessage) values('"+message+"')");
            Toast.makeText(getActivity(), "Message inserted", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(), "Error : "+e, Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }
}
