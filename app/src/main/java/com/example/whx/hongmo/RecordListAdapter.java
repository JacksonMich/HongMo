package com.example.whx.hongmo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by whx on 2015/11/11.
 */
public class RecordListAdapter extends BaseAdapter{

    private Context context;
    private String[] titles,subtitles,lingquzhuangtai,lingqujine;

    public RecordListAdapter(){

    }
    public RecordListAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(context,R.layout.record_item,null);

        TextView title = (TextView)view.findViewById(R.id.record_item_title);
        title.setText(titles[position]);
        TextView subtitle = (TextView)view.findViewById(R.id.record_item_subtitle);
        subtitle.setText(subtitles[position]);
        TextView lingquz = (TextView)view.findViewById(R.id.lingquzhuangtai);
        lingquz.setText(lingquzhuangtai[position]);
        TextView lingquj = (TextView)view.findViewById(R.id.lingqujine);
        lingquj.setText(lingqujine[position]);

        return view;
    }

    public void setSource(String[] titles,String[] subtitles,String[] lingquzhuangtai,String[] lingqujine){

        this.lingqujine = lingqujine;
        this.lingquzhuangtai = lingquzhuangtai;
        this.titles = titles;
        this.subtitles = subtitles;
    }
}
