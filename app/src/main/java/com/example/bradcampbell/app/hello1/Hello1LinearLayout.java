package com.example.bradcampbell.app.hello1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bradcampbell.app.R;
import com.example.bradcampbell.app.events.NavigateToHello2Event;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Hello1LinearLayout extends LinearLayout {
    @Inject Hello1Presenter presenter;
    @Inject Bus bus;

    @InjectView(R.id.text) TextView textView;

    public Hello1LinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
    }

    /** Sets the view data from the view model */
    public void update(Hello1ViewModel model) {
        textView.setText(model.updatedText);
    }

    public void goToNextScreen() {
        bus.post(new NavigateToHello2Event());
    }

    @OnClick(R.id.button) public void buttonPressed() {
        presenter.buttonPressed();
    }
}
