package kr.ac.tukorea.ge.spgp.scgyong.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnPrev(View view) {
        ImageView iv = findViewById(R.id.mainImageView);
        iv.setImageResource(R.mipmap.cat_1);
    }

    public void onBtnNext(View view) {
        ImageView iv = findViewById(R.id.mainImageView);
        iv.setImageResource(R.mipmap.cat_2);
    }
}