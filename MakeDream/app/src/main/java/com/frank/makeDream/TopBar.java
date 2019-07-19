package com.frank.makeDream;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;


public class TopBar extends RelativeLayout {

    private Button leftButton,rightButton;
    private TextView tv_title;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColor;
    private String title;

    private LayoutParams leftParams,rightParams,titleParams;

    private topBarClickListener listener;

    public interface topBarClickListener{
        public void leftClick();
        public void rightClick();
    }

    public void setOnTopbarClickListener(topBarClickListener listener){
        this.listener = listener;
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.Topbar);

        leftTextColor = typedArray.getColor(R.styleable.Topbar_leftTextColor,0);
        leftBackground = typedArray.getDrawable(R.styleable.Topbar_leftBackground);
        leftText = typedArray.getString(R.styleable.Topbar_leftText);

        rightTextColor = typedArray.getColor(R.styleable.Topbar_rightTextColor,0);
        rightBackground = typedArray.getDrawable(R.styleable.Topbar_rightBackground);
        rightText = typedArray.getString(R.styleable.Topbar_rightText);

        titleTextSize = typedArray.getDimension(R.styleable.Topbar_titleTextSize,0);
        titleTextColor = typedArray.getColor(R.styleable.Topbar_titleTextColor,0);
        title = typedArray.getString(R.styleable.Topbar_title);

        typedArray.recycle();

        leftButton = new Button(context);
        rightButton = new Button(context);
        tv_title = new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        tv_title.setTextColor(titleTextColor);
        tv_title.setTextSize(titleTextSize);
        tv_title.setText(title);
        tv_title.setGravity(Gravity.CENTER);

        leftParams = new LayoutParams(60,60);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        leftParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        addView(leftButton,leftParams);

        rightParams = new LayoutParams(50,50);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        rightParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        addView(rightButton,rightParams);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(tv_title,titleParams);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });

    }

    public void setLeftIsvisible(boolean flag){
        if(flag){
            leftButton.setVisibility(View.VISIBLE);
        }else {
            leftButton.setVisibility(View.GONE);
        }
    }

    public void setTitle(String title){
        tv_title.setText(title);
    }
}
