package com.example.bradcampbell.app.hello1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bradcampbell.app.R;
import com.example.bradcampbell.app.events.NavigateToHello2Event;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.example.bradcampbell.app.App.getBus;

public class Hello1LinearLayout extends LinearLayout implements Hello1View {
    @Inject Hello1Presenter presenter;

    @InjectView(R.id.text) TextView textView;

    public Hello1LinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
    }

    @Override public void show(CharSequence stuff) {
        textView.setText(stuff);
    }

    @Override public void goToNextScreen() {
        getBus(getContext()).post(new NavigateToHello2Event());
    }

    @OnClick(R.id.button) public void buttonPressed() {
        presenter.buttonPressed();
    }
}
