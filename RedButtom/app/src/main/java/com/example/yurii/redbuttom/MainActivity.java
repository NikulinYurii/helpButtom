package com.example.yurii.redbuttom;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;

import com.example.yurii.redbuttom.model.Address;
import com.example.yurii.redbuttom.model.Message;
import com.example.yurii.redbuttom.model.Message_Event;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

import org.json.JSONObject;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    private Button help_button;
    private Button medicaid_button;
    private Calendar time;


    private void sendMessage(Message message) {

        try {

            Gson gson = new Gson();
            URL url;
            URLConnection urlConn;
            DataOutputStream dos;
            DataInputStream dis;

            url = new URL("");
            urlConn = url.openConnection();
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setUseCaches(false);
            urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            dos = new DataOutputStream(urlConn.getOutputStream());
            dos.writeBytes(gson.toJson(message));
            dos.flush();
            dos.close();

        } catch (MalformedURLException mue) {
        } catch (IOException ioe) {
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELECOM_SERVICE);

        help_button = (Button) findViewById(R.id.danger_button);
        medicaid_button = (Button) findViewById(R.id.medicaid_button);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.danger_button:
                        //Message messageDanger = new Message(telephonyManager.getLine1Number(), new Address(), Message_Event.DANGER, time.getTime());
                        Message messageDanger = new Message("380997021685",new Address(),Message_Event.DANGER,time.getTime());
                        sendMessage(messageDanger);
                        break;
                    case R.id.medicaid_button:
                        //Message messageMedisine = new Message(telephonyManager.getLine1Number(), new Address(), Message_Event.MEDISINE, time.getTime());
                        Message messageMedisine = new Message("380997021685",new Address(),Message_Event.MEDISINE,time.getTime());
                        sendMessage(messageMedisine);
                        break;
                }

            }
        };

        help_button.setOnClickListener(onClickListener);
        medicaid_button.setOnClickListener(onClickListener);

    }
}
