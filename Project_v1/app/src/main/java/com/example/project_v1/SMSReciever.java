package com.example.project_v1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import java.util.HashMap;

public class SMSReciever extends BroadcastReceiver
{
        SQLiteDatabase db;
        public void onReceive(Context context, Intent intent)
        {
            Bundle bundle = intent.getExtras();
            Object[] pdusObj = (Object[])bundle.get("pdus");
            SmsMessage sm = SmsMessage.createFromPdu((byte[])pdusObj[0]);
            String sendermobileno = sm.getDisplayOriginatingAddress();
            String message = sm.getDisplayMessageBody();
            HashMap hm = new HashMap();
            DialogueService dialogueService=new DialogueService();
            int service1=dialogueService.service1;

           /* if(dialogueService.service1==1)
            {

            }
            if(dialogueService.service2==1)
            {

            }
            if(dialogueService.service3==1)
            {*/
                db = context.openOrCreateDatabase("DATABASE_MESSAGES", Context.MODE_PRIVATE, null);
                Cursor cur = db.rawQuery("select * from custom_messages", null);
                while (cur.moveToNext()) {
                    hm.put(cur.getString(0), cur.getString(1));
                }
                if (hm.containsKey(message)) {
                    String omessage = hm.get(message).toString();
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(sendermobileno, null, omessage, null, null);
                }
            //}
           // Log.d(null,"Service is recieved");
            //if(service1==1)
            //{
               /* Log.d(null,"Service is activated");
                db = context.openOrCreateDatabase("DATABASE_MESSAGES", Context.MODE_PRIVATE, null);
                Cursor cur1 = db.rawQuery("select * from messages", null);
                if(cur1!=null)
                {
                    String omessage = null;
                    while(cur1.moveToNext())
                    {
                        omessage = cur1.getString(0);
                    }
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(sendermobileno, null, omessage, null, null);

                }
            //}*/
        }
}
