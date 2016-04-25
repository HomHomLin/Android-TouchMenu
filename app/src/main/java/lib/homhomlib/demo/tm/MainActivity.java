package lib.homhomlib.demo.tm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import lib.homhomlib.tm.TouchMenuHelper;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.btnToggle);
        relativeLayout = (RelativeLayout) findViewById(R.id.root);
        TouchMenuHelper.setTarget(button, View.inflate(button.getContext(), R.layout.menu, null));
    }
}
