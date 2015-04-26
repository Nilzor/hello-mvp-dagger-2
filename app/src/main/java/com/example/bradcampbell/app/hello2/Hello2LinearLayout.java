package com.example.bradcampbell.app.hello2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bradcampbell.app.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Hello2LinearLayout extends LinearLayout implements Hello2View {
    @Inject Hello2Presenter presenter;

    @InjectView(R.id.text) TextView textView;

    public Hello2LinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
    }

    @Override public void show(CharSequence stuff) {
        textView.setText(stuff);
    }
}
