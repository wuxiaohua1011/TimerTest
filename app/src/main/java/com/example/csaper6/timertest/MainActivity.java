package com.example.csaper6.timertest;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
private TextView timeText;
    private Button startButton;
    private NumberPicker numberPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText=(TextView)findViewById(R.id.timeTextView);
        startButton=(Button)findViewById(R.id.button_start);
        numberPicker=(NumberPicker)findViewById(R.id.numberPicker);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(120);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int inputTimeInMiliSecond=numberPicker.getValue()*1000;
                new CountDownTimer(inputTimeInMiliSecond,1000) {
                    @Override
                    public void onTick(long milinitlFinished) {
                        timeText.setText("seconds remaining: "+ milinitlFinished/1000);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "Finished counting down "+ numberPicker.getValue()+" seconds", Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
    }


}
