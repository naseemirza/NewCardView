package com.example.naseem.newcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    public static final String ORIENTATION="orientation";
    private RecyclerView mRecyclerview;
    private Boolean mHorizontal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        //Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        //toolbar.inflateMenu(R.menu.main);


        //toolbar.setOnMenuItemClickListener(this);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setHasFixedSize(true);

        if (savedInstanceState==null){
            mHorizontal=true;

        }else {
            mHorizontal=savedInstanceState.getBoolean(ORIENTATION);
        }
        setupAdapter();

    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION,mHorizontal);
    }


    private void setupAdapter(){
        List<App> apps=getApps();
        SnapAdapter snapAdapter=new SnapAdapter();
        if(mHorizontal){
            snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL,"Apple Products",apps));
            snapAdapter.addSnap(new Snap(Gravity.START,"Apple Products",apps));
            snapAdapter.addSnap(new Snap(Gravity.END,"Apple Products",apps));
            snapAdapter.addSnap(new Snap(Gravity.END,"Apple Products",apps));
            //snapAdapter.addSnap(new Snap(Gravity.CENTER,"Apple Products",apps));
        }else {

            snapAdapter.addSnap(new Snap(Gravity.CENTER_VERTICAL,"Apple Products",apps));
            snapAdapter.addSnap(new Snap(Gravity.TOP,"Apple Products",apps));
            snapAdapter.addSnap(new Snap(Gravity.BOTTOM,"Apple Products",apps));
        }
        mRecyclerview.setAdapter(snapAdapter);

    }

    private List<App> getApps(){
        List<App> apps=new ArrayList<>();
        apps.add(new App("iPhone5+",R.drawable.apple,4.6f));
        apps.add(new App("iPhone6+",R.drawable.apple,4.6f));
        apps.add(new App("iPhone7+",R.drawable.apple,4.6f));
        apps.add(new App("iPhone8+",R.drawable.apple,4.6f));
        apps.add(new App("iPhone9+",R.drawable.apple,4.6f));
        apps.add(new App("iPhone10+",R.drawable.apple,4.6f));
        apps.add(new App("iPhone5+",R.drawable.apple,4.6f));
        apps.add(new App("iPhone5+",R.drawable.apple,4.6f));
        apps.add(new App("iPhone5+",R.drawable.apple,4.6f));
        apps.add(new App("iPhone5+",R.drawable.apple,4.6f));

return apps;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item){
        if (item.getItemId()==R.id.LayoutType){
            mHorizontal=!mHorizontal;
            setupAdapter();
            item.setTitle((mHorizontal ?"Vertical":"Horizontal"));

        }
        return false;
    }


}
