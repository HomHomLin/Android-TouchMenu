package lib.homhomlib.tm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by Linhh on 16/4/25.
 */
public class TouchMenuHelper {

    public static void setTarget(View view, final View menuView){
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Object obj = v.getTag(v.getId());
                PopupWindow popupWindow;

                int[] location = new int[2];

                if (v != null) {
                    v.getLocationOnScreen(location);
                }

                if (obj == null) {
                    popupWindow = new PopupWindow(menuView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setFocusable(true);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setBackgroundDrawable(v.getContext().getResources().getDrawable(
                            R.drawable.popwindow_bg));
                    popupWindow.update();
                    v.setTag(v.getId(), popupWindow);
                } else {
                    popupWindow = (PopupWindow) obj;
                }

                if (null != popupWindow) {
                    if (!popupWindow.isShowing()) {

                        popupWindow.showAtLocation(v, Gravity.LEFT | Gravity.TOP, (int)event.getRawX(), (int)event.getRawY());
                    }
//                    else {
//                        popupWindow.dismiss();
//                    }
                }
                return false;
            }
        });

    }
}
