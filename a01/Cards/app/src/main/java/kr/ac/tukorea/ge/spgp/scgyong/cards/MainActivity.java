package kr.ac.tukorea.ge.spgp.scgyong.cards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView previousCardImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnCard(View view) {
        Log.d("Tag", "Card clicked. ID=" + view.getId());

        ImageView imageView = (ImageView)view;
        if (imageView == previousCardImageView) {
            return;
        }
        if (previousCardImageView != null) {
            previousCardImageView.setImageResource(R.mipmap.card_blue_back);
        }

        imageView.setImageResource(R.mipmap.card_as);

        previousCardImageView = imageView;

    }
}