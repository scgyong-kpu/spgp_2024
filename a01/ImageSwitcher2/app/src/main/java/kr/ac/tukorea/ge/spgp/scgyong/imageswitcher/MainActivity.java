package kr.ac.tukorea.ge.spgp.scgyong.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView mainImageView;
    private TextView pageTextView;
    private Button prevButton;
    private Button nextButton;

    int page;

    private static int[] resIds = new int[] {
            R.mipmap.cat_1, R.mipmap.cat_2, R.mipmap.cat_3,
            R.mipmap.cat_4, R.mipmap.cat_5, R.mipmap.cat_6,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainImageView = findViewById(R.id.mainImageView);
        pageTextView = findViewById(R.id.pageTextView);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        setPage(1);
    }

    private void setPage(int page) {
        if (page < 1 || page > resIds.length) {
            return;
        }
        this.page = page;
        mainImageView.setImageResource(resIds[page - 1]);
        pageTextView.setText(page + " / " + resIds.length);

        prevButton.setEnabled(page > 1);
        nextButton.setEnabled(page < resIds.length);
    }

    public void onBtnPrevious(View view) {
        setPage(page - 1);
    }

    public void onBtnNext(View view) {
        setPage(page + 1);
    }
}