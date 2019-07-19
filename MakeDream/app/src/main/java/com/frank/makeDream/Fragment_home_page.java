package com.frank.makeDream;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.frank.makeDream.adapter.ViewPageAdapter;

import java.util.ArrayList;

public class Fragment_home_page extends android.support.v4.app.Fragment implements View.OnClickListener {
    @Nullable

    public Button btn_kao_yan;
    private Button btn_kao_zheng;
    private Button btn_chu_guo;
    private Button btn_qi_ye;
    private Button btn_jian_zhi;
    private Button btn_jiao_you;
    private Button btn_shi_xi;
    private Button btn_guang_chang;
    private ImageView circle_1;
    private ImageView circle_2;
    private ImageView circle_3;

    private View view;
    private ArrayList<View> alist;
    private ViewPager pager_home;
    private ViewPager pager_notice;
    private ViewPageAdapter viewPageAdapter;

    private int lastPointPosition = 0;
    private boolean isRunning = false;


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            pager_home.setCurrentItem(pager_home.getCurrentItem() + 1);
            if(isRunning){
                handler.sendEmptyMessageDelayed(0,4000);
            }
        }
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.view_home_page,container,false);
        initView();
        initAdapeter_school();
        initAdapeter_notice();
        isRunning = true;
        handler.sendEmptyMessageDelayed(0,4000);
        return view;

    }

    /**
     * 初始化控件
     */
    private void initView(){
        btn_kao_zheng = view.findViewById(R.id.btn_kao_zheng);
        btn_kao_zheng.setOnClickListener(this);
        btn_kao_yan = view.findViewById(R.id.btn_kao_yan);
        btn_kao_yan.setOnClickListener(this);
        btn_chu_guo = view.findViewById(R.id.btn_chu_guo);
        btn_chu_guo.setOnClickListener(this);
        btn_qi_ye = view.findViewById(R.id.btn_qi_ye);
        btn_qi_ye.setOnClickListener(this);
        btn_jian_zhi = view.findViewById(R.id.btn_jian_zhi);
        btn_jian_zhi.setOnClickListener(this);
        btn_jiao_you = view.findViewById(R.id.btn_jiao_you);
        btn_jiao_you.setOnClickListener(this);
        btn_shi_xi = view.findViewById(R.id.btn_shi_xi);
        btn_shi_xi.setOnClickListener(this);
        btn_guang_chang = view.findViewById(R.id.btn_guang_chang);
        btn_guang_chang.setOnClickListener(this);

        pager_home = view.findViewById(R.id.view_pages);
        pager_notice = view.findViewById(R.id.view_page_notice);

        /**
         * ViewPage的监听事件
         */
        pager_home.setOnTouchListener(new View.OnTouchListener() {
            int flag=0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        flag = 0;
                        break;
                    case MotionEvent.ACTION_UP:
                        if(flag==0){
                            int item  = pager_home.getCurrentItem();
                            if (item==0){
                                Toast.makeText(getActivity(), "你点击的是广告位0", Toast.LENGTH_SHORT).show();
                            }else if(item==1){
                                Toast.makeText(getActivity(), "你点击的是广告位1", Toast.LENGTH_SHORT).show();
                            }else if (item==2){
                                Toast.makeText(getActivity(), "你点击的是广告位2", Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        flag = 1;
                        break;
                }
                return false;
            }
        });

        circle_1 = view.findViewById(R.id.circle_1);
        circle_2 = view.findViewById(R.id.circle_2);
        circle_3 = view.findViewById(R.id.circle_3);

        /**
         * 圆点的切换（颜色变化）
         */
        pager_home.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                position = position % alist.size();
                lastPointPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    /**
     * 监听点击事件
     * @param
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_kao_zheng:
                Toast.makeText(getActivity(),"你点击的是考证",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_kao_yan:
                Toast.makeText(getActivity(),"你点击的是考研",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_chu_guo:
                Toast.makeText(getActivity(),"你点击的是出国",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_qi_ye:
                Toast.makeText(getActivity(),"你点击的是企业纳英",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_jian_zhi:
                Toast.makeText(getActivity(),"你点击的是课外兼职",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_jiao_you:
                Toast.makeText(getActivity(),"你点击的是实名交友",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_shi_xi:
                Toast.makeText(getActivity(),"你点击的是实习招聘",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_guang_chang:
                Toast.makeText(getActivity(),"你点击的是校园广场",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 初始化顶部学校广告区适配器
     */
    private void initAdapeter_school(){
        alist = new ArrayList<View>();
        LayoutInflater layoutInflater = getLayoutInflater();
        alist.add(layoutInflater.inflate(R.layout.view_one,null,false));
        alist.add(layoutInflater.inflate(R.layout.view_two,null,false));
        alist.add(layoutInflater.inflate(R.layout.view_three,null,false));
        viewPageAdapter = new ViewPageAdapter(alist,getActivity());
        pager_home.setAdapter(viewPageAdapter);
        pager_home.setCurrentItem(Integer.MAX_VALUE/2 - ((Integer.MAX_VALUE /2) % alist.size()));
    }

    /**
     * 初始化动态通知框适配器
     */
    private void initAdapeter_notice(){
        alist = new ArrayList<View>();
        LayoutInflater layoutInflater = getLayoutInflater();
        alist.add(layoutInflater.inflate(R.layout.notice_view_page_1,null));
        alist.add(layoutInflater.inflate(R.layout.notice_view_page_2,null));
        alist.add(layoutInflater.inflate(R.layout.notice_view_page_3,null));
        viewPageAdapter = new ViewPageAdapter(alist,getActivity());
        pager_notice.setAdapter(viewPageAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }
}
