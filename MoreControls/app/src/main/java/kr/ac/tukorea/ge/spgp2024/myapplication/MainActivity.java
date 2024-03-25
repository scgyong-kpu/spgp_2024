package kr.ac.tukorea.ge.spgp2024.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import kr.ac.tukorea.ge.spgp2024.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void onBtnDoIt(View view) {
        boolean isGood = binding.goodProgrammerCheckbox.isChecked();
        int strId = isGood ? R.string.you_get_one_grand : R.string.you_have_nothing; // Alt+Enter here
        binding.pageTitleTextView.setText(strId);
    }
}