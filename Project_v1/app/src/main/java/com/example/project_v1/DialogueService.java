package com.example.project_v1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.project_v1.R;

public class DialogueService extends DialogFragment {
    public int service1=0,service2=0, service3=0,service4=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogue_service, container, false);
        TextView textView=(TextView)view.findViewById(R.id.view2);
        TextView textView1=(TextView)view.findViewById(R.id.view3);
        CheckBox checkBox=(CheckBox)view.findViewById(R.id.check1);
        CheckBox checkBox1=(CheckBox)view.findViewById(R.id.check2);
        CheckBox checkBox2=(CheckBox)view.findViewById(R.id.check3);
        CheckBox checkBox3=(CheckBox)view.findViewById(R.id.check4);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               /*if(checkBox.isChecked()){
                        service1=1;
                        service2=0;
                        service3=0;
                        service4=0;
                        Toast.makeText(getActivity(), "Service1", Toast.LENGTH_SHORT).show();
                        getDialog().dismiss();
                    }
               if(checkBox1.isChecked()){
                        service1=0;
                        service2=1;
                        service3=0;
                        service4=0;
                        Toast.makeText(getActivity(), "Service2", Toast.LENGTH_SHORT).show();
                        getDialog().dismiss();
                    }
               if(checkBox2.isChecked()){
                        service1=0;
                        service2=0;
                        service3=1;
                        service4=0;
                        Toast.makeText(getActivity(), "Service2", Toast.LENGTH_SHORT).show();
                        getDialog().dismiss();
                    }
               if(checkBox3.isChecked()){
                        service1=0;
                        service2=0;
                        service3=0;
                        service4=1;
                   Toast.makeText(getActivity(), "Service3", Toast.LENGTH_SHORT).show();
                    }
               if(checkBox1.isChecked() && checkBox.isChecked()){
                        service1=1;
                        service2=1;
                        service3=0;
                        service4=0;
                    }
               else
                   {
                       Toast.makeText(getActivity(), "Invalid Selection", Toast.LENGTH_SHORT).show();
                   }
                    getDialog().dismiss();*/
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
}