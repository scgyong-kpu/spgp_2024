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

        // #2
        Button btn = findViewById(R.id.pushMeButton);
        btn.setOnClickListener(pushMeOnClickListener);
        Button btn2 = findViewById(R.id.anotherButton);
        btn2.setOnClickListener(anotherOnClickListener);
    }
    private View.OnClickListener pushMeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv = findViewById(R.id.nameTextView);
            tv.setText("PushMe");
        }
    };
    private View.OnClickListener anotherOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv = findViewById(R.id.nameTextView);
            tv.setText("Another");
        }
    };
}