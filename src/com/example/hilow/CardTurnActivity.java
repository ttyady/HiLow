package com.example.hilow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;

public class CardTurnActivity extends Activity{

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout layoutT = new LinearLayout(this);
        layoutT.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView( layoutT);
        LinearLayout layoutM = new LinearLayout(this);
        layoutM.setOrientation(LinearLayout.HORIZONTAL);
        layoutM.setGravity( Gravity.RIGHT);
        layout.addView( layoutM);
        LinearLayout layoutB = new LinearLayout(this);
        layoutB.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView( layoutB);

        layoutT.addView( new CardView(this,0));
        layoutT.addView( new CardView(this,1));
        layoutT.addView( new CardView(this,2));
        layoutT.addView( new CardView(this,3));
        layoutT.addView( new CardView(this,4));
        layoutB.addView( new CardView(this,5));
        layoutB.addView( new CardView(this,6));
        layoutB.addView( new CardView(this,7));
        layoutB.addView( new CardView(this,8));
        layoutB.addView( new CardView(this,9));
        layoutM.addView( new CardView(this,-1));

        setContentView(layout);
    }
}