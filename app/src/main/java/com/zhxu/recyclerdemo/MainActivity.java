package com.zhxu.recyclerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView ;
    private List<DataBean> datas ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas = new ArrayList<>() ;

        for(int i = 0 ; i < Data.icons.length ; i ++){
            datas.add(new DataBean(Data.icons[i],"图片"+(i+1))) ;
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        loadListData(false,LinearLayoutManager.VERTICAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId() ;
        switch (id){
            case R.id.item_list_normal:
                //list标准展示
                loadListData(false,LinearLayoutManager.VERTICAL);
                break ;
            case R.id.item_list_vertical_reverse:
                //list垂直反向展示
                loadListData(true,LinearLayoutManager.VERTICAL) ;
                break ;
            case R.id.item_list_horizontal:
                //水平展示
                loadListData(false,LinearLayoutManager.HORIZONTAL);
                break ;
            case R.id.item_list_horizontal_reverse:
                //水平反向展示
                loadListData(true,LinearLayoutManager.HORIZONTAL);
                break ;

            case R.id.item_grid_normal:
                //grid标准展示
                loadGridData(false,LinearLayoutManager.VERTICAL);
                break ;

            case R.id.item_grid_vertical_reverse:
                //grid垂直反向展示
                loadGridData(true,LinearLayoutManager.VERTICAL) ;
                break ;
            case R.id.item_grid_horizontal:
                //水平展示
                loadGridData(false,LinearLayoutManager.HORIZONTAL);
                break ;
            case R.id.item_grid_horizontal_reverse:
                //水平反向展示
                loadGridData(true,LinearLayoutManager.HORIZONTAL);
                break ;


            case R.id.item_staggered_normal:
                //瀑布流标准展示
                loadStaggeredData(false,StaggeredGridLayoutManager.VERTICAL);
                break ;

            case R.id.item_staggered_vertical_reverse:
                //瀑布流垂直反向展示
                loadStaggeredData(true,StaggeredGridLayoutManager.VERTICAL) ;
                break ;
            case R.id.item_staggered_horizontal:
                //瀑布流水平展示
                loadStaggeredData(false,StaggeredGridLayoutManager.HORIZONTAL);
                break ;
            case R.id.item_staggered_horizontal_reverse:
                //瀑布流水平反向展示
                loadStaggeredData(true,StaggeredGridLayoutManager.HORIZONTAL);
                break ;
        }

        return true;
    }

    public void loadListData(){
        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this) ;
        //垂直布局
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //为RecyclerView设置数据
        mRecyclerView.setAdapter(new ListAdapter(this,datas));
    }




    public void loadListData(boolean reverse,int orientation){

        //加载数据
        //1、设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this) ;
        layoutManager.setReverseLayout(reverse);
        layoutManager.setOrientation(orientation);
        mRecyclerView.setLayoutManager(layoutManager);
        //2、适配模式
        mRecyclerView.setAdapter(new ListAdapter(this,datas));
    }

    public void loadGridData(boolean reverse,int orientation){

        GridLayoutManager layoutManager = new GridLayoutManager(this,2) ;
        layoutManager.setReverseLayout(reverse);
        layoutManager.setOrientation(orientation);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new GridAdapter(this,datas));
    }


    public void loadStaggeredData(boolean reverse,int orientation){

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,orientation) ;
        layoutManager.setReverseLayout(reverse);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new StaggeredAdapter(this,datas));
    }
}
