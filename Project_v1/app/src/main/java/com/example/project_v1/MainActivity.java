package com.example.project_v1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.wafflecopter.multicontactpicker.ContactResult;
import com.wafflecopter.multicontactpicker.LimitColumn;
import com.wafflecopter.multicontactpicker.MultiContactPicker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

   // private static final int CONTACT_PICKER_REQUEST = 202;
  //  List<ContactResult> results=new ArrayList<>();

                  /*  protected MainActivity(Parcel in) {
                        results = in.createTypedArrayList(ContactResult.CREATOR);
                    }

                    public static final Creator<MainActivity> CREATOR = new Creator<MainActivity>() {
                        @Override
                        public MainActivity createFromParcel(Parcel in) {
                            return new MainActivity(in);
                        }

                        @Override
                        public MainActivity[] newArray(int size) {
                            return new MainActivity[size];
                        }
                    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                        if (Build.VERSION.SDK_INT >= 26)//android 8.0
                        {
                            if (ContextCompat.checkSelfPermission(MainActivity.this, "android.permission.RECEIVE_SMS") != PackageManager.PERMISSION_GRANTED)
                            {
                                ActivityCompat.requestPermissions(MainActivity.this,new String[]{"android.permission.RECEIVE_SMS","android.permission.SEND_SMS"},1);
                            }
                        }

        Button button = (Button)findViewById(R.id.btn1);
        Button button1 = findViewById(R.id.btn2);
        Button button2 = findViewById(R.id.btn3);

                button.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        startCustomUsers();
                    }
                });

                button1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {startAllUsers();}
                });

                button2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        viewDatabase();
                    }
                });


    }


        void startCustomUsers()
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            CustomUser frame1 = new CustomUser();
            fragmentTransaction.replace(R.id.frame1,frame1);
            fragmentTransaction.commit();
            /*
            new MultiContactPicker.Builder(MainActivity.this) //Activity/fragment context
                    .hideScrollbar(false) //Optional - default: false
                    .showTrack(true) //Optional - default: true
                    .searchIconColor(Color.WHITE) //Option - default: White
                    .setChoiceMode(MultiContactPicker.CHOICE_MODE_MULTIPLE) //Optional - default: CHOICE_MODE_MULTIPLE
                    .handleColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary)) //Optional - default: Azure Blue
                    .bubbleColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary)) //Optional - default: Azure Blue
                    .bubbleTextColor(Color.WHITE) //Optional - default: White
                    .setTitleText("Select Contacts") //Optional - default: Select Contacts
                    .setLoadingType(MultiContactPicker.LOAD_ASYNC) //Optional - default LOAD_ASYNC (wait till all loaded vs stream results)
                    .limitToColumn(LimitColumn.NONE) //Optional - default NONE (Include phone + email, limiting to one can improve loading time)
                    .setActivityAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                            android.R.anim.fade_in,
                            android.R.anim.fade_out) //Optional - default: No animation overrides
                    .showPickerForResult(CONTACT_PICKER_REQUEST);

            //Send results bundle to CustomUserMessage and DialogueCustomUser
        */}

        void startAllUsers()
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            AllUser frame1 = new AllUser();
            fragmentTransaction.replace(R.id.frame1,frame1);
            fragmentTransaction.commit();
        }

        void viewDatabase()
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ViewFragment frame1 = new ViewFragment();
            fragmentTransaction.replace(R.id.frame1,frame1);
            fragmentTransaction.commit();
        }

                            @Override
                            public boolean onCreateOptionsMenu(Menu menu)
                            {
                                getMenuInflater().inflate(R.menu.main,menu);
                                return super.onCreateOptionsMenu(menu);
                            }

                            @Override
                            public boolean onOptionsItemSelected(MenuItem item)
                            {
                                int id = item.getItemId();
                                switch (id)
                                {
                                    case R.id.info1:
                                        DialogueAbout dialogueabout=new DialogueAbout();//opening dialogue
                                        dialogueabout.show(getSupportFragmentManager(),null);
                                        break;
                                    case R.id.power:
                                        DialogueService dialogueservice=new DialogueService();//opening dialogue
                                        dialogueservice.show(getSupportFragmentManager(),null);
                                        break;
                                }
                                return super.onOptionsItemSelected(item);
                            }

                   /*     @Override
                        public int describeContents()
                        {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel parcel, int i)
                        {
                            parcel.writeTypedList(results);
                        }*/
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CONTACT_PICKER_REQUEST){
            if(resultCode == RESULT_OK) {
                results = MultiContactPicker.obtainResult(data);
                Log.d("MyTag", results.get(0).getDisplayName());
            } else if(resultCode == RESULT_CANCELED){
                System.out.println("User closed the picker without selecting items.");
            }
        }
        //send results bundle to customusermessage and dialoguecustomuser
    /*    DialogFragment dialogFragment=new DialogFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelableArrayList("contacts",(ArrayList<?extends Parcelable>)results);
        dialogFragment.setArguments(bundle);
*/
       /* Intent intent=new Intent();
        Bundle bundle1=new Bundle();
        bundle1.putParcelableArrayList("contact",(ArrayList<?extends Parcelable>)results);
        intent.putExtras(bundle1);
*/
   //     Intent intent = new Intent(MainActivity.this, CustomUserMessage.class);
     //   intent.putExtra("key", results);
      /*  Intent intent = new Intent(MainActivity.this ,CustomUserMessage.class);
        intent.putParcelableArrayListExtra("contact", (ArrayList<? extends Parcelable>) results);
        startActivity(intent);
*/

    //}
   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }*/
}