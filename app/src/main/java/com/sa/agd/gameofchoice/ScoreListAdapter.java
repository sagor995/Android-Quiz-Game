package com.sa.agd.gameofchoice;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Sagor Ahamed on 6/17/2017.
 */

public class ScoreListAdapter extends ArrayAdapter<Scores> {
    private Context mcontext;
    int mResource;

    public ScoreListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Scores> objects) {
        super(context, resource, objects);
        mcontext= context;
        mResource = resource;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        Integer score = getItem(position).getScore();
        String category = getItem(position).getCategory();

        LayoutInflater inflater = LayoutInflater.from(mcontext);
        convertView =inflater.inflate(mResource,parent,false);

        Button nameTxt = (Button) convertView.findViewById(R.id.nameView);
        Button scoreTxt = (Button)convertView.findViewById(R.id.scoreView);
        Button categoryTxt = (Button)convertView.findViewById(R.id.categoryViews);

        nameTxt.setText(name);
        scoreTxt.setText(""+score);
        categoryTxt.setText(category);
        return convertView;
    }
}
