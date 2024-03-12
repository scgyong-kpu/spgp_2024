package kr.ac.tukorea.ge.spgp.scgyong.samplejavaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTextView = findViewById(R.id.nameTextView);
    }

    // #4. onClick XML attr 이용
    public void onBtnPushMe(View sender) {
        nameTextView.setText("PushMe");
    }

    public void onBtnAnother(View view) {
        nameTextView.setText("Another");
    }
}