package kr.ac.tukorea.ge.spgp.scgyong.cards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton previousImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnCard(View view) {
        Log.d("Tag", "Card!!" + view.getId());

        ImageButton imageButton = (ImageButton) view;
        if (previousImageButton == imageButton) {
            return;
        }

        if (previousImageButton != null) {
            previousImageButton.setImageResource(R.mipmap.card_blue_back);
        }

        imageButton.setImageResource(R.mipmap.card_as);

        previousImageButton = imageButton;

    }
}