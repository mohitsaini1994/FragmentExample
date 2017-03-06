package com.example.mohitsaini.fragmentexample.part_3;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

import java.util.ArrayList;

/**
 * Created by mohitsaini on 21/1/17.
 */

public class SwipeViewWithRecyclerView extends AppCompatActivity implements View.OnClickListener{

    private ArrayList countries =  new ArrayList<>();
    private SwipeViewAdapter adapter;
    private RecyclerView recyclerView;
    private AlertDialog.Builder alertDialog;
    private EditText et_country;
    private int edit_position;
    private View view;
    private boolean add = false;
    private Paint p = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_json_example);

        initViews();
        initDialog();
    }

    private void initViews(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        ListView lv = (ListView)findViewById(R.id.lv);
        lv.setVisibility(View.GONE);
        fab.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SwipeViewAdapter(countries);
        recyclerView.setAdapter(adapter);
        countries.add("Australia");
        countries.add("India");
        countries.add("United States of America");
        countries.add("Germany");
        countries.add("Russia");
        adapter.notifyDataSetChanged();
        initSwipe();

    }
    private void initSwipe(){
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                if (direction == ItemTouchHelper.LEFT){
                    adapter.removeItem(position);
                } else {
                    removeView();
                    edit_position = position;
                    alertDialog.setTitle("Edit Country");
                    et_country.setText(""+countries.get(position));
                    alertDialog.show();
                }
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                Bitmap icon;
                if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){

                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height / 3;

                    if(dX > 0){
                        p.setColor(Color.parseColor("#388E3C"));
                        RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX,(float) itemView.getBottom());
                        c.drawRect(background,p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_edit_white);
                        RectF icon_dest = new RectF((float) itemView.getLeft() + width ,(float) itemView.getTop() + width,(float) itemView.getLeft()+ 2*width,(float)itemView.getBottom() - width);
                        c.drawBitmap(icon,null,icon_dest,p);
                    } else {
                        p.setColor(Color.parseColor("#D32F2F"));
                        RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(),(float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(background,p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_delete_white);
                        RectF icon_dest = new RectF((float) itemView.getRight() - 2*width ,(float) itemView.getTop() + width,(float) itemView.getRight() - width,(float)itemView.getBottom() - width);
                        c.drawBitmap(icon,null,icon_dest,p);
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
    private void removeView(){
        if(view.getParent()!=null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
    private void initDialog(){
        alertDialog = new AlertDialog.Builder(this);
        view = getLayoutInflater().inflate(R.layout.fragment_register,null);
        alertDialog.setView(view);
        alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(add){
                    add =false;
                    adapter.addItem(et_country.getText().toString());
                    dialog.dismiss();
                } else {
                    countries.set(edit_position,et_country.getText().toString());
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }

            }
        });
        et_country = (EditText)view.findViewById(R.id.et_name);
        EditText e1 = (EditText)view.findViewById(R.id.et_email);
        EditText e2 = (EditText)view.findViewById(R.id.et_password);
        Button b = (Button)view.findViewById(R.id.btn_register);
        TextView t = (TextView) view.findViewById(R.id.tv_login);
        TextView t2 = (TextView)view.findViewById(R.id.learn2crack);
        TextInputLayout til = (TextInputLayout)view.findViewById(R.id.text_input_layout);
        e1.setVisibility(View.GONE);
        e2.setVisibility(View.GONE);
        b.setVisibility(View.GONE);
        t.setVisibility(View.GONE);
        til.setVisibility(View.GONE);
        t2.setText("Add Country");
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.fab:
                removeView();
                add = true;
                alertDialog.show();
                break;
        }
    }
}