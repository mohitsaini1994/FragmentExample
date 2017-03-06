package com.example.mohitsaini.fragmentexample.part_3;


import android.support.annotation.Nullable;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.opengl.Visibility;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;

/**
 * Created by mohitsaini on 28/1/17.
 */

public class FloatingViewService extends Service {

    ListView listView;
    private WindowManager mWindowManager;
    private View mFloatingView;
    String[] list = {"Androidhive Retrofit Example",
            "AnonymousInner Class Example",
            "Async Task Example",
            "Customize List View",
            "Expendable List View",
            "Floating Button Example",
            "Main Activity",
            "Main Activity 2",
            "Multilevel List",
            "My JSON Example",
            "My Retrofit Example",
            "Navigation Drawer",
            "NotificationExample",
            "Picasso Example",
            "Picasso Simple",
            "Potrait Landscape Example",
            "Register Activity",
            "Retrofit Example",
            "Send Data Using Volley",
            "Swipe View With RecyclerView",
            "TabHost Example",
            "With RecyclerView"};
    String[] list_going = {"android.hive.retrofit.RetMainActivity",
            "part_1.AnonymousInnerClassExample",
            "part_2.AsyncTaskExample",
            "part_2.CustomizeListView",
            "part_2.ExpendableListView",
            "part_1.FloatingButtonExample",
            "part_1.MainActivity",
            "part_1.MainActivity2",
            "android.multilevel.listview.MultilevelList",
            "part_1.MyJSONExample",
            "part_2.MyRetrofitExample",
            "part_3.NavigationDrawer",
            "part_2.NotificationExample",
            "android.picasso.PicassoExample",
            "android.picasso.PicassoSimple",
            "part_2.PotraitLandscapeExample",
            "part_1.RegisterActivity",
            "part_2.RetrofitExample",
            "android.learn2crack.send.MainActivity",
            "part_3.SwipeViewWithRecyclerView",
            "part_1.TabHostExample",
            "part_1.WithRecyclerView"};

    public FloatingViewService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mFloatingView = LayoutInflater.from(this).inflate(R.layout.activity_floating_widget_example, null);

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        //Specify the view position
        params.gravity = Gravity.TOP | Gravity.LEFT;        //Initially view will be added to top-left corner
        params.x = 0;
        params.y = 100;

        //Add the view to the window
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);

        //The root element of the collapsed view layout
        final View collapsedView = mFloatingView.findViewById(R.id.collapse_view);
        //The root element of the expanded view layout
        final View expandedView = mFloatingView.findViewById(R.id.expanded_container);
        final View f_w_scroll = mFloatingView.findViewById(R.id.float_widget_scroll);

        //Set the close button
//        ImageView closeButtonCollapsed = (ImageView) mFloatingView.findViewById(R.id.close_btn);
//        closeButtonCollapsed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //close the service and remove the from from the window
//                stopSelf();
//            }
//        });

//        listView = (ListView)mFloatingView.findViewById(R.id.floating_widget_list);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
//        listView.setAdapter(arrayAdapter);

//        Set the close button
//        ImageView closeButton = (ImageView) mFloatingView.findViewById(R.id.close_button);
//        closeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                collapsedView.setVisibility(View.VISIBLE);
//                expandedView.setVisibility(View.GONE);
//            }
//        });

        //////////////////////////////////////////////////////////////////////////////////////////////////
        LinearLayout myLinearLayout = (LinearLayout)mFloatingView.findViewById(R.id.expanded_container);
        final int N = list.length; // total number of textviews to add

        final TextView[] myTextViews = new TextView[N]; // create an empty array;

        for (int i = 0; i < N; i++) {
            // create a new textview
            final TextView rowTextView = new TextView(this);

            // set some properties of rowTextView or something
            rowTextView.setHeight(100);
            rowTextView.setText(list[i]);

            // add the textview to the linearlayout
            myLinearLayout.addView(rowTextView);

            // save a reference to the textview for later
            myTextViews[i] = rowTextView;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////

        mFloatingView.findViewById(R.id.root_container).setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        //remember the initial position.
                        initialX = params.x;
                        initialY = params.y;

                        //get the touch location
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int Xdiff = (int) (event.getRawX() - initialTouchX);
                        int Ydiff = (int) (event.getRawY() - initialTouchY);


                        //The check for Xdiff <10 && YDiff< 10 because sometime elements moves a little while clicking.
                        //So that is click event.
                        if (Xdiff < 10 && Ydiff < 10) {
                            if (isViewCollapsed()) {
                                //When user clicks on the image view of the collapsed layout,
                                //visibility of the collapsed layout will be changed to "View.GONE"
                                //and expanded view will become visible.
                                collapsedView.setVisibility(View.GONE);
                                expandedView.setVisibility(View.VISIBLE);
                                f_w_scroll.setVisibility(View.VISIBLE);
                            }
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        //Calculate the X and Y coordinates of the view.
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);


                        //Update the layout with new X & Y coordinate
                        mWindowManager.updateViewLayout(mFloatingView, params);
                        return true;
                }
                return false;
            }
        });
    }

    /**
     * Detect if the floating view is collapsed or expanded.
     *
     * @return true if the floating view is collapsed.
     */
    private boolean isViewCollapsed() {
        return mFloatingView == null || mFloatingView.findViewById(R.id.collapse_view).getVisibility() == View.VISIBLE;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFloatingView != null) mWindowManager.removeView(mFloatingView);
    }
}
