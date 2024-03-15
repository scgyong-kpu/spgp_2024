package kr.ac.tukorea.ge.spgp.scgyong.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button prevButton;
    private Button nextButton;
    private TextView pageTextView;
    private ImageView mainImageView;
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

        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        pageTextView = findViewById(R.id.pageTextView);
        mainImageView = findViewById(R.id.mainImageView);

        setPage(1);
    }

    private void setPage(int page) {
        if (page < 1 || page > resIds.length) {
            return;
        }
        this.page = page;
        mainImageView.setImageResource(resIds[page-1]);
        prevButton.setEnabled(page > 1);
        nextButton.setEnabled(page < resIds.length);

        pageTextView.setText(page + " / " + resIds.length);
    }

    public void onBtnPrev(View view) {
        setPage(page - 1);
    }

    public void onBtnNext(View view) {
        setPage(page + 1);
    }
}
