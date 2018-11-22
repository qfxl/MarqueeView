package com.qfxl.marquee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.qfxl.marquee.adapter.MyAdapter;
import com.qfxl.marquee.entity.AdvEntity;
import com.qfxl.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MarqueeView marqueeView = findViewById(R.id.mqv_main);
        final List<AdvEntity> dataList = new ArrayList<>();

        dataList.add(new AdvEntity("热门", "三星S10真机曝光,美呆了"));
        dataList.add(new AdvEntity("精华", "越来越多人卫生间不装浴房了"));
        dataList.add(new AdvEntity("手机", "5G资费已确定,人人都用"));
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, dataList.get(position).getContent(), Toast.LENGTH_SHORT).show();
            }
        });
        marqueeView.setAdapter(new MyAdapter(dataList));
        marqueeView.start();
    }

}
