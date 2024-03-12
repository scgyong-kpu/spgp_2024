package kr.ac.tukorea.ge.spgp.scgyong.samplejavaapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String id = idInput.text;
//        String id = idInput.getText();
//        //tv.text = "Loaded";
        TextView tv = findViewById(R.id.nameTextView);
        tv.setText("Loaded");
    }
}