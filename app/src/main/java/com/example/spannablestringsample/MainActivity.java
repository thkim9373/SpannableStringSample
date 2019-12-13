package com.example.spannablestringsample;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.example.spannablestringsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        CharSequence charSequence = getString(R.string.hoony_spannable_string_sample);
        Spannable spannable = new SpannableString(charSequence);
        Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_android);
        if (drawable != null)
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable);
        spannable.setSpan(imageSpan,
                0,
                0,
                Spanned.SPAN_COMPOSING);
        binding.tvContent.setText(spannable);
    }
}
