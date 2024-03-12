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

    // #4. onClick XML attr 이용
    public void onBtnPushMe(View sender) {
        TextView tv = findViewById(R.id.nameTextView);
        tv.setText("PushMe");
    }

    public void onBtnAnother(View view) {
        TextView tv = findViewById(R.id.nameTextView);
        tv.setText("Another");
    }
}