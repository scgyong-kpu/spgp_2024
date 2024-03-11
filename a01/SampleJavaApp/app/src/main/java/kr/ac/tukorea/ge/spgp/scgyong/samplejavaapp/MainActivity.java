package kr.ac.tukorea.ge.spgp.scgyong.samplejavaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnPushMe(View view) {
        TextView tv = findViewById(R.id.nameTextView);
        tv.setText("Push Me");
    }

    public void onBtnAnthoer(View view) {
        TextView tv = findViewById(R.id.nameTextView);
        tv.setText("Another");
    }
}
