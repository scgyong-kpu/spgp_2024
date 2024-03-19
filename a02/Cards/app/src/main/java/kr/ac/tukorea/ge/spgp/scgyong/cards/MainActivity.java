package kr.ac.tukorea.ge.spgp.scgyong.cards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton previousImageButton;

    private static final int[] IMAGE_BTN_IDS = new int[] {
            R.id.card_00,R.id.card_01,R.id.card_02,R.id.card_03,
            R.id.card_10,R.id.card_11,R.id.card_12,R.id.card_13,
            R.id.card_20,R.id.card_21,R.id.card_22,R.id.card_23,
            R.id.card_30,R.id.card_31,R.id.card_32,R.id.card_33,
    };
    private static final int[] CARD_RES_IDS = new int[] {
            R.mipmap.card_as,R.mipmap.card_as,R.mipmap.card_2c,R.mipmap.card_2c,
            R.mipmap.card_3d,R.mipmap.card_3d,R.mipmap.card_4h,R.mipmap.card_4h,
            R.mipmap.card_5s,R.mipmap.card_5s,R.mipmap.card_jc,R.mipmap.card_jc,
            R.mipmap.card_qh,R.mipmap.card_qh,R.mipmap.card_kd,R.mipmap.card_kd,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        for (int i = 0; i < IMAGE_BTN_IDS.length; i++) {
            ImageButton ib = findViewById(IMAGE_BTN_IDS[i]);
            // #1
//            int resId = CARD_RES_IDS[i];
//            Integer intObj = new Integer(resId);
//            ib.setTag(intObj);
            // #2
//            int resId = CARD_RES_IDS[i];
//            Integer intObj = resId;
//            ib.setTag(intObj);
            // #3
            ib.setTag(CARD_RES_IDS[i]);
        }
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

        previousImageButton = imageButton;

    }
}