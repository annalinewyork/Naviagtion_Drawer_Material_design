package fun_house.appbar_demo1;

import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created on 8/24/15.
 */
public class Activity_A extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         *  We will not use setContentView in this activty
         *  Rather than we will use layout inflater to add view in FrameLayout of our base activity layout*/

        /**
         * Adding our layout to parent class frame layout.
         */
        getLayoutInflater().inflate(R.layout.activity_a, frameLayout);

        /**
         * Setting title and itemChecked
         */
        mDrawerList.setItemChecked(position, true);
        setTitle(titles[position]);

//        ((ImageView)findViewById(R.id.image_view)).setBackgroundResource(R.drawable.image1);
    }

}
