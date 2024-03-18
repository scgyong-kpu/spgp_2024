package kr.ac.tukorea.ge.spgp.scgyong.cards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageButton previousCardImageView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        for (int i = 0; i < VIEW_IDS.length; i++) {
            ImageView iv = findViewById(VIEW_IDS[i]);
            iv.setTag(resIds[i]);
        }
    }

    public void onBtnCard(View view) {
        Log.d("Tag", "Card clicked. ID=" + view.getId());

        ImageButton imageButton = (ImageButton)view;
        if (imageButton == previousCardImageView) {
            return;
        }

        int imgRes = (Integer)imageButton.getTag();
        if (previousCardImageView != null) {
            previousCardImageView.setImageResource(R.mipmap.card_blue_back);
        }

        imageButton.setImageResource(imgRes);

        previousCardImageView = imageButton;

    }
}