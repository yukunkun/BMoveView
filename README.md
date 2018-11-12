#### BMoveView mRadioGroup添加移动的特效的View
#### 相信你喜欢直接了当一点
[使用方法](http://www.jianshu.com/p/4a6dfe1b7e59)
#### 上图
![1493335479979.mp4_1493336353.gif](http://upload-images.jianshu.io/upload_images/3001453-02f7e2a8724dacd9.gif?imageMogr2/auto-orient/strip)
####  `BMoveView`修改之后，可以实现多个button的点击移动动画，四个，五个，六个皆可以，对于之前是实现方式做了修改，进一步完成多点实现

![S81112-15260812.jpg](https://upload-images.jianshu.io/upload_images/3001453-eb35f9ea1e353b9d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![S81112-15263231.jpg](https://upload-images.jianshu.io/upload_images/3001453-7831fe85a36445c8.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![S81112-15280658.jpg](https://upload-images.jianshu.io/upload_images/3001453-fd4cf44e30af6dea.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![S81112-15275978.jpg](https://upload-images.jianshu.io/upload_images/3001453-74762e784a912c5a.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

|属性   |含义 |
|----------|------------- |
|circleColor|圆环的颜色|
|lineColor|下面的线条的颜色|
|lineDuration|线条头的移动时间(单位ms)|
|lineWidth|线条的宽度|
|circleDuration|圆圈的动画时间(单位ms)|
|circleCenterColor|圆圈中心的颜色(可以不和背景一样)|
|circlemRadio|圆圈的半径|
|buttonCount|button个数|

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
            yk:circlemRadio="25"
            />
        <mRadioGroup
            android:id="@+id/rg_group"
            android:gravity="center"
            android:weightSum="3"
            android:orientation="horizontal"
            android:layout_width="match_parent"
            android:layout_height="60dp">
            <mRadioButton
                android:id="@+id/rb_first"
                android:button="@null"
                android:text="索引"
                android:layout_weight="1"
                android:textColor="@drawable/rb_button"
                android:textSize="18sp"
                android:gravity="center"
                android:layout_width="0dp"
                android:layout_height="match_parent"/>
            <mRadioButton
                android:id="@+id/rb_second"
                android:button="@null"
                android:text="热门"
                android:layout_weight="1"
                android:textColor="@drawable/rb_button"
                android:textSize="18sp"
                android:gravity="center"
                android:layout_width="0dp"
                android:layout_height="match_parent"/>
            <mRadioButton
                android:id="@+id/rb_third"
                android:button="@null"
                android:text="我的"
                android:layout_weight="1"
                android:textColor="@drawable/rb_button"
                android:textSize="18sp"
                android:gravity="center"
                android:layout_width="0dp"
                android:layout_height="match_parent"/>
        </mRadioGroup>
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
          yk:circlemRadio="25"/>
#### 为主要的布局,是我们的自定义的BMoveView
#### 在Activity里,如下:
      public class BMoveViewActivity extends Activity {
        private int mFirstPos; //上一次的mRadiobutton位置
        private int mLastPos;  //点击的mRadiobutton位置
        private BMoveView mBMoveView;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bmove_view);
            bMoveInit();
        }
    
        private void bMoveInit() {
            mBMoveView = (BMoveView) findViewById(R.id.bmoveview);
            mRadioGroup mRadioGroup= (mRadioGroup) findViewById(R.id.rg_group);
            ((mRadioButton) (mRadioGroup.getChildAt(0))).setChecked(true);
            mFirstPos = 0;
            mBMoveView.startAnim();
            mRadioGroup.setOnCheckedChangeListener(new mRadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(mRadioGroup group, int checkedId) {
                    for (int i = 0; i < group.getChildCount(); i++) {
                        boolean checked = ((mRadioButton) (group.getChildAt(i))).isChecked();
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
