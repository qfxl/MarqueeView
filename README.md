# MarqueeView

可水平、垂直翻页View，适用于任意View，由开发者自由定义内部View。找了几个类似效果，对于想要自定义内部View的操作比较繁琐，所以写了该库。

## 效果图
![sample][1]

## Gradle

```groovy
implementation 'com.qfxl:marqueeview:1.0.0'
```

## 自定义属性

MarqueeView继承自ViewFlipper，所以ViewFlipper的自定义属性全部支持。

|Attribute|Description|类型|默认值|
|:-:|:-:|:-:|:-:|
|mvDirection|滚动方向|enum[left_to_right(0),top_to_bottom(1),right_to_left(2),bottom_to_top(3)]|left_to_right(0)|

下面是ViewFliper的自定义属性

|Attribute|Description|类型|默认值|
|:-:|:-:|:-:|:-:|
|flipInterval|滚动间隔时间(ms)|int|3000|
|autoStart|自动开启滚动|boolean|false|
|inAnimation|View进入时的动画|reference|0|
|outAnimation|View离开时的动画|reference|0|
|animateFirstView|ViewFliper可见时当前View是否执行进入动画|boolean|true|

## 声明MarqueeView

```xml
  <com.qfxl.marqueeview.MarqueeView
        android:id="@+id/mqv_taobao"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:background="#e8e8e8"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:mv_direction="bottom_to_top" />
```

## 设置数据

```java
MarqueeView taobaoMarqueeView = findViewById(R.id.mqv_taobao);
final List<TaoBaoEntity> taobaoDataList = new ArrayList<>();
taobaoDataList.add(new TaoBaoEntity("热门", "三星S10真机曝光,美呆了"));
taobaoDataList.add(new TaoBaoEntity("精华", "越来越多人卫生间不装浴房了"));
taobaoDataList.add(new TaoBaoEntity("手机", "5G资费已确定,人人都用"));
taobaoMarqueeView.setAdapter(new TaoBaoAdapter(taobaoDataList));
aobaoMarqueeView.start();
```

内部View及数据由Adapter提供，继承自[BaseMarqueeAdapter][2]即可。

```java
public class TaoBaoAdapter extends BaseMarqueeAdapter {
    private List<TaoBaoEntity> mList;

    public TaoBaoAdapter(List<TaoBaoEntity> list) {
        mList = list;
    }

    @Override
    public View getView(int position, Context context, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_taobao_marquee, null);
        ViewHolder holder = new ViewHolder(itemView);
        holder.tvTitle.setText(mList.get(position).getTitle());
        holder.tvContent.setText(mList.get(position).getContent());
        return itemView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    class ViewHolder {
        TextView tvTitle;
        TextView tvContent;

        ViewHolder(View itemView) {
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
```

## 设置监听
```java
 marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
          
            }
        });
```

如果有特殊需要处理的效果，可以提PR或者ISSUE。

  [1]: https://github.com/qfxl/MarqueeView/blob/master/gif/sample.gif?raw=true
  [2]: https://github.com/qfxl/MarqueeView/blob/master/marqueeview/src/main/java/com/qfxl/marqueeview/BaseMarqueeAdapter.java
