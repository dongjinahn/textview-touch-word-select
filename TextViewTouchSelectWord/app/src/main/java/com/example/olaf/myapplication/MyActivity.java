package com.example.olaf.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends Activity {
    private TextView mTxt;
    private TextView mTxtOffset;
    private TextView mTxtWord;
    private static final String TAG = MyActivity.class.getSimpleName();

    int mOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mTxt = (TextView) findViewById(R.id.txt);
        mTxtOffset = (TextView) findViewById(R.id.txt_offset);
        mTxtWord = (TextView) findViewById(R.id.txt_selected_word);


        mTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    mOffset = mTxt.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    mTxtOffset.setText("" + mOffset);
                    mTxtWord.setText(mTxt.getText().toString().substring(mOffset));
                }
                return false;
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
