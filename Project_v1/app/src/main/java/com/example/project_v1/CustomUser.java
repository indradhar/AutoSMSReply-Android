package com.example.project_v1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.wafflecopter.multicontactpicker.ContactResult;

import java.util.ArrayList;
import java.util.List;

public class CustomUser extends Fragment
{
   // List<ContactResult> results=new ArrayList<>();//th
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

       /* Bundle bundle=getArguments();//th
        results=bundle.getParcelableArrayList("contacts");//th*/

        View view = inflater.inflate(R.layout.all_user, container, false);
        Button button=(Button)view.findViewById(R.id.btn1);
        CheckBox checkBox=view.findViewById(R.id.check1);
        CheckBox checkBox1=view.findViewById(R.id.check2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()&&checkBox1.isChecked())
                {
                    startToast();
                }
                else if(checkBox.isChecked())
                {
                    startDialogue();
                }
                else if(checkBox1.isChecked())
                {
                    startCustomMessageActivity();
                }
            }
        });

        return view;
    }
    public void startToast()
    {
        Toast.makeText(getActivity(), "Check only one option", Toast.LENGTH_SHORT).show();
    }
    public void startDialogue()
    {
        //DialogueCustomUser dialogue=new DialogueCustomUser();//opening dialogue

      /*  DialogFragment dialogFragment=new DialogFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelableArrayList("contacts",(ArrayList<?extends Parcelable>)results);
        fragment.setArguments(bundle);*/

        //dialogue.show(getFragmentManager(),null);
        Intent intent = new Intent(getActivity(),CustomUserAny.class);
        startActivity(intent);
    }
    public void startCustomMessageActivity()
    {
        Intent intent = new Intent(getActivity(),CustomUserMessage.class);
        startActivity(intent);
    }
}
