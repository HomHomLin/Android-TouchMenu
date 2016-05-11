package lib.homhomlib.demo.tm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import lib.homhomlib.tm.TouchMenuHelper;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TouchMenuHelper mTouchMenuHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.btnToggle);
        mTouchMenuHelper = new TouchMenuHelper(this,button,View.inflate(button.getContext(), R.layout.menu, null), ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,null);
        mTouchMenuHelper.update();
    }
}
