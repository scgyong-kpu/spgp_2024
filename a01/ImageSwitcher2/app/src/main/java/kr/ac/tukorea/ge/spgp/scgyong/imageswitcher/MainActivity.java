package kr.ac.tukorea.ge.spgp.scgyong.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import kr.ac.tukorea.ge.spgp.scgyong.imageswitcher.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    int page;

    private static int[] resIds = new int[] {
            R.mipmap.cat_1, R.mipmap.cat_2, R.mipmap.cat_3,
            R.mipmap.cat_4, R.mipmap.cat_5, R.mipmap.cat_6,
    };
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setPage(1);
    }

    private void setPage(int page) {
        if (page < 1 || page > resIds.length) {
            return;
        }
        this.page = page;
        binding.mainImageView.setImageResource(resIds[page - 1]);
        binding.pageTextView.setText(page + " / " + resIds.length);

        binding.prevButton.setEnabled(page > 1);
        binding.nextButton.setEnabled(page < resIds.length);
    }

    public void onBtnPrevious(View view) {
        setPage(page - 1);
    }

    public void onBtnNext(View view) {
        setPage(page + 1);
    }
}