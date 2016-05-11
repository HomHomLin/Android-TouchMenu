package lib.homhomlib.tm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by Linhh on 16/4/25.
 */
public class TouchMenuHelper implements GestureDetector.OnGestureListener,View.OnTouchListener{
    private GestureDetector mGestureDetector;
    private View mView;
    private View mMenuView;
    private int mMenuWidth,mMenuHeight;
    private View.OnTouchListener mOnTouchListener;

    private PopupWindow mPopupWindow;

//    public TouchMenuHelper(Context context){
//        this(context,null,null,0,0);
//    }

    public TouchMenuHelper(Context context, View view, View menuView, int menuWidth, int menuHeight){
        this(context,view,menuView,menuWidth,menuHeight,null);
    }

    public TouchMenuHelper(Context context, View view, View menuView, int menuWidth, int menuHeight, View.OnTouchListener onTouchListener){
        mGestureDetector = new GestureDetector(context, this);
        mView = view;
        mMenuView = menuView;
        mMenuHeight = menuHeight;
        mMenuWidth = menuWidth;
        mOnTouchListener = onTouchListener;
    }

    public void update(){
//        if(mView == null){
//            throw new Exception("mView is null");
//        }
//
//        if(mMenuView == null){
//            throw new Exception("mMenuView is null");
//        }

        mPopupWindow = new PopupWindow(mMenuView, mMenuWidth, mMenuHeight);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(mView.getContext().getResources().getDrawable(
                R.drawable.popwindow_bg));
        mPopupWindow.update();

        mView.setOnTouchListener(this);

    }

    public void setOnTouchListener(View.OnTouchListener listener){
        mOnTouchListener = listener;
    }

    public void setTarget(View view){
        mView = view;
    }

    public void setMenuView(View view){
        mMenuView = view;
    }

    public void setMenuWidth(int menuWidth){
        this.mMenuWidth = menuWidth;
    }

    public void setMenuHeight(int menuHeight){
        this.mMenuHeight = menuHeight;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        if (mView == null || mMenuView == null) {
            return;
        }

//        int[] location = new int[2];
//        mView.getLocationOnScreen(location);

//        if (mPopupWindow == null) {
//            mPopupWindow = new PopupWindow(mMenuView, mMenuWidth, mMenuHeight);
//            mPopupWindow.setFocusable(true);
//            mPopupWindow.setOutsideTouchable(true);
//            mPopupWindow.setBackgroundDrawable(mView.getContext().getResources().getDrawable(
//                    R.drawable.popwindow_bg));
//            mPopupWindow.update();
//        }
        if (!mPopupWindow.isShowing()) {
            mPopupWindow.showAtLocation(mView, Gravity.LEFT | Gravity.TOP, (int)event.getRawX(), (int)event.getRawY());
        }
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(mGestureDetector != null){
            mGestureDetector.onTouchEvent(event);
        }
        return mOnTouchListener == null ? false : mOnTouchListener.onTouch(v,event);
    }
}
