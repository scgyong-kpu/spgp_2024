package kr.ac.tukorea.ge.spgp.scgyong.cards;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

import kr.ac.tukorea.ge.spgp.scgyong.cards.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ImageButton previousImageButton;

    private static final int[] IMAGE_BTN_IDS = new int[] {
            R.id.card_00,R.id.card_01,R.id.card_02,R.id.card_03,
            R.id.card_10,R.id.card_11,R.id.card_12,R.id.card_13,
            R.id.card_20,R.id.card_21,R.id.card_22,R.id.card_23,
            R.id.card_30,R.id.card_31,R.id.card_32,R.id.card_33,
    };
    private int[] cardResIds = new int[] {
            R.mipmap.card_as,R.mipmap.card_as,R.mipmap.card_2c,R.mipmap.card_2c,
            R.mipmap.card_3d,R.mipmap.card_3d,R.mipmap.card_4h,R.mipmap.card_4h,
            R.mipmap.card_5s,R.mipmap.card_5s,R.mipmap.card_jc,R.mipmap.card_jc,
            R.mipmap.card_qh,R.mipmap.card_qh,R.mipmap.card_kd,R.mipmap.card_kd,
    };
    private Random random = new Random();
    private ActivityMainBinding binding;
    private int flips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        startGame();
    }

    private void startGame() {
//        for (int i = 0; i < cardResIds.length; i++) {
//            int ti = random.nextInt(cardResIds.length);
//            int resId = cardResIds[i];
//            cardResIds[i] = cardResIds[ti];
//            cardResIds[ti] = resId;
//        }

        for (int i = 0; i < IMAGE_BTN_IDS.length; i++) {
            ImageButton ib = findViewById(IMAGE_BTN_IDS[i]);
            ib.setVisibility(View.VISIBLE);
            ib.setImageResource(R.mipmap.card_blue_back);
            ib.setTag(cardResIds[i]);
        }

        previousImageButton = null;
        setFlips(0);
    }

    public void onBtnCard(View view) {
        Log.d("Tag", "Card!!" + view.getId());

        ImageButton imageButton = (ImageButton) view;
        if (previousImageButton == imageButton) {
            return;
        }

        int resId = (Integer)imageButton.getTag();

        if (previousImageButton != null) {
            int prevResId = (Integer)previousImageButton.getTag();
            if (resId == prevResId) {
                // remove 2 cards
                previousImageButton.setVisibility(View.INVISIBLE);
                imageButton.setVisibility(View.INVISIBLE);
                previousImageButton = null;
                return;
            }
            previousImageButton.setImageResource(R.mipmap.card_blue_back);
        }

        imageButton.setImageResource(resId);

        setFlips(flips + 1);

        previousImageButton = imageButton;

    }

    private void setFlips(int flips) {
        this.flips = flips;
        String text = String.format("Flips: %d", flips);
        binding.scoreTextView.setText(text);
    }

    public void onBtnRestart(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Restart")
                .setMessage("Do you really want to restart?")
                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startGame();
                    }
                })
                .setNegativeButton("No", null)
                .create()
                .show();
    }
}