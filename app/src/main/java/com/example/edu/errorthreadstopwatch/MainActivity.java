package com.example.edu.errorthreadstopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//에뮬이 에러래.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String TAG ="ErrorThreadActivity Tag";
        long endTime=System.currentTimeMillis()+20*5000;
        Log.i(TAG,"Thread running!");
        TextView threadValue=(TextView)findViewById(R.id.threadValue);
        while (System.currentTimeMillis()<endTime){
            synchronized (this){
                Log.i(TAG,"Thread running!");
                threadValue.setText(String.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
