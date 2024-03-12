package kr.ac.tukorea.ge.spgp.scgyong.samplejavaapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.pushMeButton);
        // #1
        btn.setOnClickListener(this);

        Button btn2 = findViewById(R.id.anotherButton);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pushMeButton) {
            TextView tv = findViewById(R.id.nameTextView);
            tv.setText("PushMe");
        } else if (id == R.id.anotherButton) {
            TextView tv = findViewById(R.id.nameTextView);
            tv.setText("Another");
        }
    }
}