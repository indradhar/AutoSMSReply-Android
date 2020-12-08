/*package com.example.project_v1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.wafflecopter.multicontactpicker.ContactResult;
import com.wafflecopter.multicontactpicker.LimitColumn;
import com.wafflecopter.multicontactpicker.MultiContactPicker;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class DialogueCustomUser extends DialogFragment {
    String message;
    private static final int CONTACT_PICKER_REQUEST = 202;
    List<ContactResult> results=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.dialogue_layout, container, false);
        EditText editText=(EditText)view.findViewById(R.id.edit1);
        TextView textView=(TextView)view.findViewById(R.id.view2);
        TextView textView1=(TextView)view.findViewById(R.id.view3);

       // Bundle bundle=getArguments();
        //results=bundle.getParcelableArrayList("contacts");



        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message=editText.getText().toString();
                if(message.length()!=0)
                {
                    new MultiContactPicker.Builder(DialogueCustomUser.this) //Activity/fragment context //change1
                            .hideScrollbar(false) //Optional - default: false
                            .showTrack(true) //Optional - default: true
                            .searchIconColor(Color.WHITE) //Option - default: White
                            .setChoiceMode(MultiContactPicker.CHOICE_MODE_MULTIPLE) //Optional - default: CHOICE_MODE_MULTIPLE
                            .handleColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary)) //Optional - default: Azure Blue
                            .bubbleColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary)) //Optional - default: Azure Blue
                            .bubbleTextColor(Color.WHITE) //Optional - default: White
                            .setTitleText("Select Contacts") //Optional - default: Select Contacts
                            .setLoadingType(MultiContactPicker.LOAD_ASYNC) //Optional - default LOAD_ASYNC (wait till all loaded vs stream results)
                            .limitToColumn(LimitColumn.NONE) //Optional - default NONE (Include phone + email, limiting to one can improve loading time)
                            .setActivityAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                                    android.R.anim.fade_in,
                                    android.R.anim.fade_out) //Optional - default: No animation overrides
                            .showPickerForResult(CONTACT_PICKER_REQUEST);



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
            public void onClick(View view) { getDialog().dismiss();}
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);//change 1
        if (requestCode == CONTACT_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                results = MultiContactPicker.obtainResult(data);
                Log.d("MyTag", results.get(0).getDisplayName());
            } else if (resultCode == RESULT_CANCELED) {
                System.out.println("User closed the picker without selecting items.");
            }
        }
        Toast.makeText(getActivity(), "Message created", Toast.LENGTH_SHORT).show(); //working fine
        saveDatabase(message);
    }

    void saveDatabase(String message)
    {
        SQLiteDatabase db;

        db = getActivity().openOrCreateDatabase("DATABASE_MESSAGES",MODE_PRIVATE,null);
        db.execSQL("Create table if not exists custom_user_messages (outgoingmessage varchar(100),name varchar(100),number varchar(100))");
        Toast.makeText(getActivity(), "Message created", Toast.LENGTH_SHORT).show(); //working fine
        for(int i=0;i<results.size();i++)
        {
            try {
                //Toast.makeText(getActivity(), "loop started", Toast.LENGTH_SHORT).show(); //not working
                String name=results.get(i).getDisplayName();
                String number=results.get(i).getPhoneNumbers().get(0).getNumber();
                db.execSQL("insert into custom_user_messages(outgoingmessage,name,number) values('" + message + "','" + name + "','"+ number +"')"); //ikkada loop inka message
                Toast.makeText(getActivity(), "Message inserted", Toast.LENGTH_SHORT).show();
            } catch (Exception e)
            {
                Toast.makeText(getActivity(), "Error : " + e, Toast.LENGTH_SHORT).show();
            }
        }
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }
}
*/