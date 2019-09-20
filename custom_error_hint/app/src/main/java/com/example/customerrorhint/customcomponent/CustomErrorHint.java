package com.example.customerrorhint.customcomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.customerrorhint.R;

public class CustomErrorHint extends FrameLayout {

    private TextView error;
    private View errorHint;

    public CustomErrorHint(Context context) {
        super(context);
        initView(context);
    }

    public CustomErrorHint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CustomErrorHint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public CustomErrorHint(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context) {
        errorHint = inflate(context, R.layout.custom_hint, null);
        error = errorHint.findViewById(R.id.tv_texto);
    }

    public void addViewError(){
        removeAllViews();
        addView(errorHint);
    }

    public void removeViewError(){
        removeView(errorHint);
    }

    public void setError(String errorText){
        error.setText(errorText);
    }
}
