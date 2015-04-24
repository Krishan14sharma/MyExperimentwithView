package zapbuild.kr.myexperimentwithview.fancytoolbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Krishan on 23/4/15.
 * Based on Cyril Mottier's example "Pushing the ActionBar to the Next Level"
 */
public class NotifyingScrollView extends ScrollView {

    public void setmNotifyingScrollListner(NotifyingScrollListner mNotifyingScrollListner) {
        this.mNotifyingScrollListner = mNotifyingScrollListner;
    }

    public NotifyingScrollListner getmNotifyingScrollListner() {
        return mNotifyingScrollListner;
    }

    private NotifyingScrollListner mNotifyingScrollListner;

    public NotifyingScrollView(Context context) {
        super(context);
    }

    public NotifyingScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NotifyingScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NotifyingScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public interface NotifyingScrollListner {
        void onScrollChanged(ScrollView scrollView,int l,int t,int oldl,int oldt);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(mNotifyingScrollListner!=null){
            mNotifyingScrollListner.onScrollChanged(this,l,t,oldl,oldt);
        }

    }
}
