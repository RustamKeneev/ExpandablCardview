package com.onlineapteka.expandablcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mExpandableLayout;
    private Button mArrowButton;
    private CardView mCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mExpandableLayout = findViewById(R.id.expandable_constraint_layout);
        mArrowButton = findViewById(R.id.drop_down_button);
        mCardView = findViewById(R.id.card_view);

        mArrowButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                if (mExpandableLayout.getVisibility()== View.GONE){
                    TransitionManager.beginDelayedTransition(mCardView,new AutoTransition());
                    mExpandableLayout.setVisibility(View.VISIBLE);
                    mArrowButton.setBackgroundResource(R.drawable.ic_arrow_up);
                }else {
                    TransitionManager.beginDelayedTransition(mCardView,new AutoTransition());
                    mExpandableLayout.setVisibility(View.GONE);
                    mArrowButton.setBackgroundResource(R.drawable.ic_arrow_down);
                }
            }
        });
    }
}