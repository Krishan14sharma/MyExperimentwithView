package zapbuild.kr.myexperimentwithview;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import zapbuild.kr.myexperimentwithview.common.BaseToolBarActivity;
import zapbuild.kr.myexperimentwithview.fancytoolbar.NotifyingScrollView;


public class MainActivity2 extends BaseToolBarActivity {

    @InjectView(R.id.parentCotainer)
    RelativeLayout mParentCotainer;
    @InjectView(R.id.notifyScroll)
    NotifyingScrollView mNotifyScroll;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.tetxview2)
    TextView mTetxview2;
    //    @InjectView(R.id.parent)
//    FrameLayout mParent;
    @InjectView(R.id.fake_header)
    LinearLayout mFakeHeader;
    @InjectView(R.id.replaceable_toolbar)
    LinearLayout mReplaceableToolbar;
    @InjectView(R.id.toolbar_title)
    TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        ButterKnife.inject(this);
        mToolbar.setNavigationIcon(null);
        mToolbar.setTitle("");
        mToolbarTitle.setScaleX(1f);
        mToolbarTitle.setScaleY(1f);
        final float initPivot = mParentCotainer.getPivotY();
        mNotifyScroll.setmNotifyingScrollListner(new NotifyingScrollView.NotifyingScrollListner() {
            @Override
            public void onScrollChanged(ScrollView scrollView, int l, int t, int oldl, int oldt) {
//                final int headerHeight = findViewById(R.id.content_image).getHeight() - getResources().getDimensionPixelSize(R.dimen.toolbar_full_height);
//                final float ratio = (float) Math.min(Math.max(t, 0), getResources().getDimensionPixelSize(R.dimen.toolbar_full_height)) / getResources().getDimensionPixelSize(R.dimen.toolbar_full_height);
//                final int newAlpha = (int) (ratio * 255);
//                mToolbar.getBackground().setAlpha(newAlpha);
                int trnslationy = Math.min(t, getResources().getDimensionPixelSize(R.dimen.toolbar_height));
//                mFakeHeader.setTranslationY(-trnslationy);
//                mParentCotainer.setTranslationY(-trnslationy);
//                int dt = t - oldt;

                mReplaceableToolbar.setTranslationY(-trnslationy);
                float height=getResources().getDimensionPixelSize(R.dimen.toolbar_height);
                float ratio=(trnslationy / height);
                float v = 1 - (0.5f / height)*trnslationy;

                mToolbarTitle.setScaleX(v);
                mToolbarTitle.setScaleY(v);
                mToolbarTitle.setTranslationX(-trnslationy);
            }
        });
    }

}
