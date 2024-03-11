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

        Button btn = (Button)findViewById(R.id.pushMeButton);
        btn.setOnClickListener(this);

        Button btn2 = (Button)findViewById(R.id.anotherButton);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView tv = findViewById(R.id.nameTextView);
        if (view.getId() == R.id.pushMeButton) {
            tv.setText("Push Me");
        } else if (view.getId() == R.id.anotherButton) {
            tv.setText("Another");
        }
    }
}
