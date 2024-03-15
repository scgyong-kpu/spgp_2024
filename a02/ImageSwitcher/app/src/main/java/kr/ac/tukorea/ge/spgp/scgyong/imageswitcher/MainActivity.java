package kr.ac.tukorea.ge.spgp.scgyong.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int page;
    private int[] resIds = new int[] {
            R.mipmap.cat_1,
            R.mipmap.cat_2,
            R.mipmap.cat_3,
            R.mipmap.cat_4,
            R.mipmap.cat_5,
            R.mipmap.cat_6,
    };
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