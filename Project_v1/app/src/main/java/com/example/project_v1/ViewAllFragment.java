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

public class ViewAllFragment extends Fragment {
    SQLiteDatabase db;
    ArrayList al = new ArrayList();
    ListView lvShow;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.view_layout, container, false);
        Button button=view.findViewById(R.id.btn1);
        Button button1=view.findViewById(R.id.btn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewAny_AnyUser();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                viewAny_CustomUser();
            }
        });
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Button button=view.findViewById(R.id.btn1);
                Button button1=view.findViewById(R.id.btn2);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        lvShow = view.findViewById(R.id.list1);
                        db = getActivity().openOrCreateDatabase("DATABASE_MESSAGES",MODE_PRIVATE,null);
                        load(view);
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
                                            db.execSQL("delete from messages where outgoingmessage='"+imessage+"'");
                                            al.clear();
                                            load(view);
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

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                displayCustomUser();
            }
        });*/

        return view;
    }

  /*  public void load(View view)
    {
        Cursor cur = db.rawQuery("select * from messages", null);//err
        while(cur.moveToNext())
        {
            //String incomingmessage = cur.getString(0);
            String outgoingmessage = cur.getString(0);
            al.add(outgoingmessage);
        }
        cur.close();
        ArrayAdapter aa = new ArrayAdapter(view.getContext(),android.R.layout.simple_list_item_1,al);
        lvShow.setAdapter(aa);
    }*/

    void viewAny_AnyUser()
    {
        Intent intent = new Intent(getActivity(),DisplayAnyAny.class);
        startActivity(intent);
    }

    void viewAny_CustomUser()
    {

    }
}
