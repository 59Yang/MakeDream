package com.frank.makeDream;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        replaceFragment(new Fragment_home_page());
    }

    //初始化控件
    private void initView(){
        //初始化底部菜单栏控件
        bottomNavigationView = findViewById(R.id.bnv_menu);
        //设置删除默认动画效果（显示图标下的文字）
        bottomNavigationView.setLabelVisibilityMode(1);
        //设置初始选中
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        //底部菜单栏监听事件
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_home_page:
                        replaceFragment(new Fragment_home_page());
                        break;
                    case R.id.item_mall:
                        replaceFragment(new Fragment_fen_lei());
                        break;
                    case R.id.item_like:
                        replaceFragment(new Fragment_fen_lei());
                        break;
                    case R.id.item_msg:
                        replaceFragment(new Fragment_fen_lei());
                        break;
                    case R.id.item_person:
                        replaceFragment(new Fragment_personal());
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_home,fragment);
        transaction.commit();
    }



}
