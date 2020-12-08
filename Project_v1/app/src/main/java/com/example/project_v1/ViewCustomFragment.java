package com.example.project_v1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class ViewCustomFragment extends Fragment
{
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.view_layout, container, false);
        Button button=view.findViewById(R.id.btn1);
        Button button1=view.findViewById(R.id.btn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCustom_AnyUser();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                viewCustom_CustomUser();
            }
        });

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                lvShow = view.findViewById(R.id.list1);
                db = getActivity().openOrCreateDatabase("DATABASE_MESSAGES",MODE_PRIVATE,null);
                load();
                lvShow.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
                {
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        String data = al.get(position).toString();
                        String arr[] = data.split("\n");
                        final String imessage = arr[0];
                        AlertDialog.Builder ab = new AlertDialog.Builder(view.getContext());//here
                        ab.setTitle("Action");
                        ab.setMessage("Do you want to delete ?");
                        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int which)
                            {
                                try
                                {
                                    db.execSQL("delete from custom_messages where incomingmessage='"+imessage+"'");
                                    al.clear();
                                    load();
                                }
                                catch (Exception e)
                                {
                                    Toast.makeText(getActivity(),"Error : "+e,Toast.LENGTH_LONG).show();//here
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
        });
*/


        return view;
    }


  /*  public void load()
    {
        Cursor cur = db.rawQuery("select * from custom_messages", null);
        while(cur.moveToNext())
        {
            String incomingmessage = cur.getString(0);
            String outgoingmessage = cur.getString(1);
            al.add(incomingmessage+"\n"+outgoingmessage);
        }
        cur.close();
        ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,al);
        lvShow.setAdapter(aa);
    }*/

   void viewCustom_AnyUser()
   {
       Intent intent = new Intent(getActivity(),DisplayCustomAny.class);
       startActivity(intent);
   }

   void viewCustom_CustomUser()
   {
       Intent intent = new Intent(getActivity(),DisplayCustomCustom.class);
       startActivity(intent);

   }
}
