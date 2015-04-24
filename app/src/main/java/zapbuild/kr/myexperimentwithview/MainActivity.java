package zapbuild.kr.myexperimentwithview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import zapbuild.kr.myexperimentwithview.common.BaseToolBarActivity;
import zapbuild.kr.myexperimentwithview.fancytoolbar.NotifyingScrollView;


public class MainActivity extends BaseToolBarActivity {

    @InjectView(R.id.content_image)
    ImageView mContentImage;
    @InjectView(R.id.notifyScroll)
    NotifyingScrollView mNotifyScroll;
    @InjectView(R.id.parentCotainer)
    LinearLayout mParentCotainer;
    private int mLastDampedScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mToolbar.getBackground().setAlpha(0);
        mNotifyScroll.setmNotifyingScrollListner(new NotifyingScrollView.NotifyingScrollListner() {
            @Override
            public void onScrollChanged(ScrollView scrollView, int l, int t, int oldl, int oldt) {
                final int headerHeight = findViewById(R.id.content_image).getHeight() - getResources().getDimensionPixelSize(R.dimen.toolbar_height);
                final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
                final int newAlpha = (int) (ratio * 255);
                mToolbar.getBackground().setAlpha(newAlpha);
                updateParallaxEffect(t);
            }
        });
    }

    private void updateParallaxEffect(int scrollPosition) {
        float damping = 0.75f;
        int dampedScroll = (int) (scrollPosition * damping);
        int offset = mLastDampedScroll - dampedScroll;
        mContentImage.offsetTopAndBottom(-offset);
        mLastDampedScroll = dampedScroll;
    }
}
