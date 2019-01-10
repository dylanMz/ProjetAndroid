package com.example.dmendez.projet_android_dylan_julian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter {

    private Context mcontext;
    private gestionBdd unegestion;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Name = new ArrayList<String>();
    private ArrayList<String> Score = new ArrayList<String>();
    private ArrayList<String> Niveau = new ArrayList<String>();

    public Adapter(Context c,ArrayList<String> name,ArrayList<String> score){
        mcontext = c;
        //this.Id = id;
        this.Name  =name;
        this.Score = score;


    }
    @Override
    public int getCount() {
        return Name.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final viewHolder holder;
        unegestion =new gestionBdd(mcontext);
        LayoutInflater layoutInflater;
        if (view == null) {
            layoutInflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.layout, null);
            holder = new viewHolder();
            //holder.id = (TextView) view.findViewById(R.id.tvid);
            holder.name = (TextView) view.findViewById(R.id.tvname);
            holder.score = (TextView) view.findViewById(R.id.tvscore);
            view.setTag(holder);
        } else {
            holder = (viewHolder) view.getTag();
        }
        //holder.id.setText(Id.get(i));
        holder.name.setText(Name.get(i));
        holder.score.setText(Score.get(i));
        return view;
    }
    public class viewHolder {
        //TextView id;
        TextView name;
        TextView score;
    }

    }
