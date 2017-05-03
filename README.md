#### BMoveView RadioGroup添加移动的特效的View
#### 相信你喜欢直接了当
[使用方法](http://www.jianshu.com/p/4a6dfe1b7e59)
#### 上图
![1493335479979.mp4_1493336353.gif](http://upload-images.jianshu.io/upload_images/3001453-02f7e2a8724dacd9.gif?imageMogr2/auto-orient/strip)
|属性   |含义|
|----------|--- ---------- |
|circleColor|圆环的颜色|
|lineColor|下面的线条的颜色|
|lineDuration|线条头的移动时间(单位ms)|
|lineWidth|线条的宽度|
|circleDuration|圆圈的动画时间(单位ms)|
|circleCenterColor|圆圈中心的颜色(可以不和背景一样)|
|circleRadio|圆圈的半径|
#### 以上就是所有的属性
#### 可以设置不同的移动效果,根据个人需求来实现
#### 使用
#### 在布局文件XML里
    <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="60dp">
        <com.yk.myselfview.views.BMoveView
            android:id="@+id/bmoveview"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            yk:circleColor="#fd4040"
            yk:lineColor="#fd4040"
            yk:lineDuration="150"
            yk:lineWidth="3"
            yk:circleDuration="500"
            yk:circleCenterColor="#FFFFFF"
            yk:circleRadio="25"
            />
        <RadioGroup
            android:id="@+id/rg_group"
            android:gravity="center"
            android:weightSum="3"
            android:orientation="horizontal"
            android:layout_width="match_parent"
            android:layout_height="60dp">
            <RadioButton
                android:id="@+id/rb_first"
                android:button="@null"
                android:text="索引"
                android:layout_weight="1"
                android:textColor="@drawable/rb_button"
                android:textSize="18sp"
                android:gravity="center"
                android:layout_width="0dp"
                android:layout_height="match_parent"/>
            <RadioButton
                android:id="@+id/rb_second"
                android:button="@null"
                android:text="热门"
                android:layout_weight="1"
                android:textColor="@drawable/rb_button"
                android:textSize="18sp"
                android:gravity="center"
                android:layout_width="0dp"
                android:layout_height="match_parent"/>
            <RadioButton
                android:id="@+id/rb_third"
                android:button="@null"
                android:text="我的"
                android:layout_weight="1"
                android:textColor="@drawable/rb_button"
                android:textSize="18sp"
                android:gravity="center"
                android:layout_width="0dp"
                android:layout_height="match_parent"/>
        </RadioGroup>
    </RelativeLayout>
#### 其中
      <com.yk.myselfview.views.BMoveView
          android:id="@+id/bmoveview"
          android:layout_width="match_parent"
          android:layout_height="60dp"
          yk:circleColor="#fd4040"
          yk:lineColor="#fd4040"
          yk:lineDuration="150"
          yk:lineWidth="3"
          yk:circleDuration="500"
          yk:circleCenterColor="#FFFFFF"
          yk:circleRadio="25"/>
#### 为主要的布局,是我们的自定义的BMoveView
#### 在Activity里,如下:
      public class BMoveViewActivity extends Activity {
        private int mFirstPos; //上一次的radiobutton位置
        private int mLastPos;  //点击的radiobutton位置
        private BMoveView mBMoveView;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bmove_view);
            bMoveInit();
        }
    
        private void bMoveInit() {
            mBMoveView = (BMoveView) findViewById(R.id.bmoveview);
            RadioGroup radioGroup= (RadioGroup) findViewById(R.id.rg_group);
            ((RadioButton) (radioGroup.getChildAt(0))).setChecked(true);
            mFirstPos = 0;
            mBMoveView.startAnim();
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    for (int i = 0; i < group.getChildCount(); i++) {
                        boolean checked = ((RadioButton) (group.getChildAt(i))).isChecked();
                        if(checked){
                            mLastPos = i; //当前的点击位置
                            mBMoveView.setTwoPos(mFirstPos, mLastPos);
                            mFirstPos = mLastPos; //记录上一次的点击位置,更新位置
                        }
                    }
                }
            });
        }
    }
#### 是不是很简单,主要是记录两次的位置,就能实现这个效果了