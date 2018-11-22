package com.qfxl.marquee;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qfxl.marqueeview.BaseMarqueeAdapter;
import com.qfxl.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MarqueeView marqueeView = findViewById(R.id.mqv_main);

        final List<AdvEntity> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            AdvEntity entity = new AdvEntity();
            entity.setContent("Item" + i);
            list.add(entity);
        }
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, "click position = " + position + "内容 = " + list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        marqueeView.setAdapter(new SimpleAdapter(list));

        marqueeView.start();
    }

    class SimpleAdapter extends BaseMarqueeAdapter {

        private List<AdvEntity> list;

        public SimpleAdapter(List<AdvEntity> list) {
            this.list = list;
        }

        @Override
        public View getView(int position, Context context, ViewGroup parent) {
            TextView defaultView = new TextView(context);
            defaultView.setText(list.get(position).getContent());
            defaultView.setTextColor(Color.WHITE);
            defaultView.setGravity(Gravity.CENTER);
            return defaultView;
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
