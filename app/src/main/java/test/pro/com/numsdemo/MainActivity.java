package test.pro.com.numsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener {
    List<TextView> mylist = new ArrayList<TextView>();
    TextView tv0, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;
    private int count = 0;
    private String[] names = {"全城品牌", "自助积分", "良食局", "优惠", "热门团购", "美食", "电影", "寻找爱车", "抽奖"};
    private int[] color = {R.color.thistle, R.color.mediumorchid, R.color.hotpink, R.color.tomato,
            R.color.lightblue, R.color.darkgreen, R.color.colorPrimary, R.color.little_black, R.color.goldenrod};
    Map<String, Integer> map = new LinkedHashMap<String, Integer>();
    private int temp;
    private List<TextView> list = new ArrayList<TextView>();
    private List<Map.Entry<String, Integer>> infoIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tv0 = (TextView) findViewById(R.id.tv0);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);
        mylist.add(tv0);
        mylist.add(tv1);
        mylist.add(tv2);
        mylist.add(tv3);
        mylist.add(tv4);
        mylist.add(tv5);
        mylist.add(tv6);
        mylist.add(tv7);
        mylist.add(tv8);
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], 0);
        }
        for (int i = 0; i < names.length; i++) {
            mylist.get(i).setText(names[i]);
            mylist.get(i).setOnClickListener(MainActivity.this);
        }
    }

    @Override
    public void onClick(View v) {
        count++;
        if (count == 10) {
            count = 0;
            int pos = 0;
            //排序
            sort();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                //it.next()得到的是key，tm.get(key)得到obj
                names[pos] = (String) it.next();
                pos++;
            }
            for (int i = 0; i < names.length; i++) {
                switch (names[i]) {
                    case "全城品牌":
                        mylist.get(i).setBackgroundResource(color[0]);
                        break;
                    case "自助积分":
                        mylist.get(i).setBackgroundResource(color[1]);
                        break;
                    case "良食局":
                        mylist.get(i).setBackgroundResource(color[2]);
                        break;
                    case "优惠":
                        mylist.get(i).setBackgroundResource(color[3]);
                        break;
                    case "热门团购":
                        mylist.get(i).setBackgroundResource(color[4]);
                        break;
                    case "美食":
                        mylist.get(i).setBackgroundResource(color[5]);
                        break;
                    case "电影":
                        mylist.get(i).setBackgroundResource(color[6]);
                        break;
                    case "寻找爱车":
                        mylist.get(i).setBackgroundResource(color[7]);
                        break;
                    case "抽奖":
                        mylist.get(i).setBackgroundResource(color[8]);
                        break;
                }
                mylist.get(i).setText(names[i] + map.get(names[i]));
                map.put(names[i], 0);
            }
            return;
        }
        switch (v.getId()) {
            case R.id.tv0:
                temp = map.get(names[0]);
                temp++;
                map.put(names[0], temp);
                break;
            case R.id.tv1:
                temp = map.get(names[1]);
                temp++;
                map.put(names[1], temp);
                break;
            case R.id.tv2:
                temp = map.get(names[2]);
                temp++;
                map.put(names[2], temp);
                break;
            case R.id.tv3:
                temp = map.get(names[3]);
                temp++;
                map.put(names[3], temp);
                break;
            case R.id.tv4:
                temp = map.get(names[4]);
                temp++;
                map.put(names[4], temp);
                break;
            case R.id.tv5:
                temp = map.get(names[5]);
                temp++;
                map.put(names[5], temp);
                break;
            case R.id.tv6:
                temp = map.get(names[6]);
                temp++;
                map.put(names[6], temp);
                break;
            case R.id.tv7:
                temp = map.get(names[7]);
                temp++;
                map.put(names[7], temp);
                break;
            case R.id.tv8:
                temp = map.get(names[8]);
                temp++;
                map.put(names[8], temp);
                break;
        }
    }

    private void sort() {
        infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });
        map.clear();
        for (int i = 0; i < infoIds.size(); i++) {
            map.put(infoIds.get(i).getKey(), infoIds.get(i).getValue());
        }
    }
}
