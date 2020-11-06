package com.example.project_v1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class AllUser extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
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
        DialogueAllUser dialogue=new DialogueAllUser();//opening dialogue
        dialogue.show(getFragmentManager(),null);
    }
    public void startCustomMessageActivity()
    {
       Intent intent = new Intent(getActivity(),CustomMessage.class);
        startActivity(intent);
    }
}