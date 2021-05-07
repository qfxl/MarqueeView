package com.qfxl.marquee;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.qfxl.marquee.adapter.FirstAdapter;
import com.qfxl.marquee.adapter.SecondAdapter;
import com.qfxl.marquee.adapter.TaoBaoAdapter;
import com.qfxl.marquee.adapter.ThirdAdapter;
import com.qfxl.marquee.entity.AdvEntity;
import com.qfxl.marquee.entity.TaoBaoEntity;
import com.qfxl.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //first
        MarqueeView marqueeView1 = findViewById(R.id.mqv_main);
        final List<String> list = new ArrayList<>();
        list.add("床前明月光");
        list.add("疑似地上霜");
        list.add("举头望明月");
        list.add("低头思故乡");

        marqueeView1.setAdapter(new FirstAdapter(list));
        marqueeView1.start();


        //second
        MarqueeView marqueeView2 = findViewById(R.id.mqv_main2);
        final List<Pair<String, String>> list2 = new ArrayList<>();
        list2.add(Pair.create("窗前明月光", "疑似地上霜"));
        list2.add(Pair.create("举头望明月", "低头思故乡"));

        marqueeView2.setAdapter(new SecondAdapter(list2));
        marqueeView2.start();

        //third
        MarqueeView marqueeView3 = findViewById(R.id.mqv_main3);
        final List<AdvEntity> advEntityList = new ArrayList<>();
        AdvEntity entity1 = new AdvEntity("299.99", "199.00", "羽绒服xxx，恰逢双十一，低价售卖温暖，一年仅有的一次。降温抵不过降价，与这个秋冬的约会，你还差几件衣服？");
        AdvEntity entity2 = new AdvEntity("1199.99", "699.00", "毛呢大衣xxx，恰逢双十二，低价售卖温暖，一年仅有的一次。降温抵不过降价，与这个秋冬的约会，你还差几件衣服？");
        AdvEntity entity3 = new AdvEntity("99.00", "9.90", "袜子大促销，降温抵不过降价，与这个秋冬的约会，你还差几件衣服？");

        advEntityList.add(entity1);
        advEntityList.add(entity2);
        advEntityList.add(entity3);
        marqueeView3.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, "当前价格仅需" + advEntityList.get(position).getPromotionalPrice(), Toast.LENGTH_SHORT).show();
            }
        });
        marqueeView3.setAdapter(new ThirdAdapter(advEntityList));
        marqueeView3.start();

        //taobao
        MarqueeView taobaoMarqueeView = findViewById(R.id.mqv_taobao);
        final List<TaoBaoEntity> taobaoDataList = new ArrayList<>();
        taobaoDataList.add(new TaoBaoEntity("热门", "三星S10真机曝光,美呆了"));
        taobaoDataList.add(new TaoBaoEntity("精华", "越来越多人卫生间不装浴房了"));
        taobaoDataList.add(new TaoBaoEntity("手机", "5G资费已确定,人人都用"));
        taobaoMarqueeView.setAdapter(new TaoBaoAdapter(taobaoDataList));
        taobaoMarqueeView.start();
    }

}
