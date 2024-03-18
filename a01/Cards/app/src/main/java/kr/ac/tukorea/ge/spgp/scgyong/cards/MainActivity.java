package kr.ac.tukorea.ge.spgp.scgyong.cards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

import kr.ac.tukorea.ge.spgp.scgyong.cards.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ImageButton previousCardImageButton;

    private int[] resIds = new int[] {
            R.mipmap.card_2c, R.mipmap.card_3d, R.mipmap.card_4h, R.mipmap.card_5s,
            R.mipmap.card_jc, R.mipmap.card_qh, R.mipmap.card_kd, R.mipmap.card_as,
            R.mipmap.card_2c, R.mipmap.card_3d, R.mipmap.card_4h, R.mipmap.card_5s,
            R.mipmap.card_jc, R.mipmap.card_qh, R.mipmap.card_kd, R.mipmap.card_as,
    };
    private static int[] VIEW_IDS = new int[] {
            R.id.card_00, R.id.card_01, R.id.card_02, R.id.card_03,
            R.id.card_10, R.id.card_11, R.id.card_12, R.id.card_13,
            R.id.card_20, R.id.card_21, R.id.card_22, R.id.card_23,
            R.id.card_30, R.id.card_31, R.id.card_32, R.id.card_33,
    };
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        startGame();
    }

    Random random = new Random();
    private void startGame() {
        for (int i = 0; i < VIEW_IDS.length; i++) {
            int swap = random.nextInt(VIEW_IDS.length);
            int resId = resIds[i];
            resIds[i] = resIds[swap];
            resIds[swap] = resId;
        }
        //new Random().s
        for (int i = 0; i < VIEW_IDS.length; i++) {
            ImageView iv = findViewById(VIEW_IDS[i]);
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(R.mipmap.card_blue_back);
            iv.setTag(resIds[i]);
        }
        setFlips(0);
    }

    public void onBtnCard(View view) {
        Log.d("Tag", "Card clicked. ID=" + view.getId());

        ImageButton imageButton = (ImageButton)view;
        if (imageButton == previousCardImageButton) {
            return;
        }

        int imgRes = (Integer)imageButton.getTag();
        if (previousCardImageButton != null) {
            int prevImgRes = (Integer) previousCardImageButton.getTag();
            if (imgRes == prevImgRes) {
                imageButton.setVisibility(View.INVISIBLE);
                previousCardImageButton.setVisibility(View.INVISIBLE);
                previousCardImageButton = null;
                return;
            }
            previousCardImageButton.setImageResource(R.mipmap.card_blue_back);
        }

        imageButton.setImageResource(imgRes);

        previousCardImageButton = imageButton;

        setFlips(flips + 1);

    }

    int flips;
    private void setFlips(int flips) {
        this.flips = flips;
        String text = String.format("Flips: %d", flips);
        binding.scoreTextView.setText(text);
    }

    public void onBtnRestart(View view) {
        startGame();
    }
}