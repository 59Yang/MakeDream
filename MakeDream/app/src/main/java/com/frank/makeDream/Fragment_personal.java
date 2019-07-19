package com.frank.makeDream;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Fragment_personal extends android.support.v4.app.Fragment implements View.OnClickListener {

    private View view;
    //private ImageView setting;
    private RelativeLayout Li_sh;
    private LinearLayout Li_shipin,Li_huodong,Li_dizhi,Li_shouhou,Li_jifen,Li_ed,Li_kefu,Li_fankui;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.view_personal,container,false);
        initView();
        return view;
    }

    private void initView() {
        //setting=view.findViewById(R.id.setting);
        Li_sh=view.findViewById(R.id.Li_sh);
        Li_shipin=view.findViewById(R.id.Li_sihpin);
        Li_huodong=view.findViewById(R.id.Li_houdong);
        Li_dizhi=view.findViewById(R.id.Li_dizhi);
        Li_shouhou=view.findViewById(R.id.Li_shouhou);
        Li_jifen=view.findViewById(R.id.Li_jifen);
        Li_ed=view.findViewById(R.id.Li_ed);
        Li_kefu=view.findViewById(R.id.Li_kefu);
        Li_fankui=view.findViewById(R.id.Li_fankui);
        //setting.setOnClickListener(this);
        Li_sh.setOnClickListener(this);
        Li_shipin.setOnClickListener(this);
        Li_huodong.setOnClickListener(this);
        Li_dizhi.setOnClickListener(this);
        Li_shouhou.setOnClickListener(this);
        Li_jifen.setOnClickListener(this);
        Li_ed.setOnClickListener(this);
        Li_kefu.setOnClickListener(this);
        Li_fankui.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.Li_sh:
                Toast.makeText(getActivity(),"学校认证",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.Li_sihpin:
                Toast.makeText(getActivity(),"视频",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Li_houdong:
                Toast.makeText(getActivity(),"活动",Toast.LENGTH_SHORT ).show();
                break;
            case R.id.Li_dizhi:
                Toast.makeText(getActivity(), "地址",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Li_shouhou:
                Toast.makeText(getActivity(), "售后",Toast.LENGTH_SHORT) .show();
                break;
            case R.id.Li_jifen:
                Toast.makeText(getActivity(),"信誉积分",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Li_ed:
                Toast.makeText(getActivity(),"信誉额度",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Li_kefu:
                Toast.makeText(getActivity(),"我的客服",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Li_fankui:
                Toast.makeText(getActivity(),"我的反馈",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
