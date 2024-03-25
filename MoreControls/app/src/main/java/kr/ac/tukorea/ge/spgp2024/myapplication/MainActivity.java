package kr.ac.tukorea.ge.spgp2024.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import kr.ac.tukorea.ge.spgp2024.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void onBtnDoIt(View view) {
        boolean isGood = binding.goodProgrammerCheckbox.isChecked();
        int strId = isGood ? R.string.you_get_one_grand : R.string.you_have_nothing;
        String msg = getString(strId);
        String name = binding.nameEditText.getText().toString().trim();
        if (name.isEmpty()) {
            name = getString(R.string.noname);
        }
        String text = getString(R.string.main_msg_fmt, name, msg);
        binding.pageTitleTextView.setText(text);
    }

    public void onCheckGoodProgrammer(View view) {
        boolean isGood = binding.goodProgrammerCheckbox.isChecked();
        int strId = isGood ? R.string.good_news : R.string.bad_news;
        binding.pageTitleTextView.setText(strId);
    }
}