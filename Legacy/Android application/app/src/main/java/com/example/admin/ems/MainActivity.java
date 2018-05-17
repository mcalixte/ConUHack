package com.example.admin.ems;

import android.content.ActivityNotFoundException;
import android.os.Bundle;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;




public class MainActivity extends AppCompatActivity {


    private Button openMic;
    private TextView showVoiceText;
    private final int REQ_CODE_SPEEH_OUTPUT = 143;

    //Making and connecting to the server
    Socket sendText = new Socket();
    PrintWriter pw;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openMic = (Button) findViewById(R.id.Button);
        showVoiceText = (TextView) findViewById(R.id.showVoiceOutput);

        openMic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                openMic();
            }

        });

        try {
            pw = new PrintWriter(sendText.getOutputStream());
            sendText = new Socket();
        }
        catch(IOException e) {
            e.printStackTrace();
            System.out.println("PrintWriter connection mistake");
        }


    }

    private void openMic() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hii Speak Now......");

        try {
            startActivityForResult(intent, REQ_CODE_SPEEH_OUTPUT);

        } catch (ActivityNotFoundException tim) {

           System.out.println("");

        }
    }
        @Override
        protected void onActivityResult(int requestCode,int resultCode, Intent data)
            {
            super.onActivityResult(requestCode, resultCode, data);

            switch(requestCode)
            {
                case REQ_CODE_SPEEH_OUTPUT:
                {
                    if (resultCode == RESULT_OK && (null != data))
                    {
                        ArrayList<String> voiceInText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                        pw.println(showVoiceText.setText(voiceInText.get(0));

                        pw.flush();
                    }
                    break;
                }
            }
        };





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
