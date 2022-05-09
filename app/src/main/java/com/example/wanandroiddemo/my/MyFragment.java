package com.example.wanandroiddemo.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.wanandroiddemo.LoginActivity;
import com.example.wanandroiddemo.R;
import com.example.wanandroiddemo.model.UserInformation;

/**
 * @author Zack
 * @Description
 * @CreateDate 2022/5/5
 */
public class MyFragment extends Fragment {
    private TextView tv_name,tv_coin;
    private ImageView pic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);
        UserInformation getUserInfo =(UserInformation) getActivity().getIntent().getSerializableExtra("userInfo");
        if(getUserInfo!=null&&getUserInfo.getData().getNickname()!=null){
            tv_name.setText(getUserInfo.getData().getNickname());
            tv_coin.setText(Integer.toString(getUserInfo.getData().getCoinCount()));
        }
        return view;
    }

    public void initView(View view) {
        tv_name = view.findViewById(R.id.tv_name);
        pic = view.findViewById(R.id.image);
        tv_coin = view.findViewById(R.id.tv_coin_mine_page);
        //setClick
        setOnClick();
    }

    private void setOnClick(){
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
