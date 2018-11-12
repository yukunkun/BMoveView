package com.yk.bmoveview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private int mFirstPos;
    private int mLastPos;
    private BMoveView mBMoveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bMoveInit();
    }

    private void bMoveInit() {
        mBMoveView = (BMoveView) findViewById(R.id.bmoveview);
        RadioGroup mRadioGroup= (RadioGroup) findViewById(R.id.rg_group);
        ((RadioButton) (mRadioGroup.getChildAt(0))).setChecked(true);
        mFirstPos = 0;
        mBMoveView.setButonCount(4);
        mBMoveView.startAnim();
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < group.getChildCount(); i++) {
                    boolean checked = ((RadioButton) (group.getChildAt(i))).isChecked();
                    if(checked){
                        mLastPos = i;
                        mBMoveView.setTwoPos(mFirstPos, mLastPos);
                        mFirstPos = mLastPos;
                    }
                }
            }
        });
    }
}
