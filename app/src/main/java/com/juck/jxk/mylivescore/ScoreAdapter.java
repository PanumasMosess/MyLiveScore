package com.juck.jxk.mylivescore;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.juck.jxk.mylivescore.Model.Fixture;

import java.sql.Time;
import java.util.List;

/**
 * Created by JXK on 18/11/2560.
 */

public class ScoreAdapter  extends ArrayAdapter<Fixture> {
    List<Fixture> fixtures;
    Context context;
    private LayoutInflater mInflater;


    public ScoreAdapter( Context context,  List<Fixture> object) {
        super(context,0, object);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        fixtures = object;
    }
    @Override
    public Fixture getItem(int position)
    {
        return fixtures.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.row_layout, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        String  Finish = "FINISHED";
        String in_play = "IN_PLAY";
        String Times = "TIMED";
        Fixture item = getItem(position);
        String  Statuss = item.getStatus();

        if(Statuss.equals(Times)){
            vh.textViewName.setText(item.getStatus());
            vh.textViewName.setTextColor(Color.BLUE);
        }else if (Statuss.equals(in_play)){
            vh.textViewName.setText(item.getStatus());
            vh.textViewName.setTextColor(Color.GREEN);
        }else {
            vh.textViewName.setText(item.getStatus());
            vh.textViewName.setTextColor(Color.RED);
        }

        vh.textViewHomeName.setText(item.getHomeTeamName());
        vh.textViewAwayName.setText(item.getAwayTeamName());
        vh.textViewGoalHome.setText(String.valueOf(item.getResult().getGoalsHomeTeam()));
        vh.textViewGoalAway.setText(String.valueOf(item.getResult().getGoalsAwayTeam()));

        return vh.rootView;
    }
    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final TextView textViewName;
        public final TextView textViewHomeName;
        public final TextView textViewAwayName;
        public final TextView textViewGoalHome;
        public final TextView textViewGoalAway;

        private ViewHolder(RelativeLayout rootView, TextView textViewName,TextView textViewHomeName,TextView textViewAwayName,TextView textViewGoalHome,TextView textViewGoalAway) {
            this.rootView = rootView;
            this.textViewName = textViewName;
            this.textViewHomeName = textViewHomeName;
            this.textViewAwayName = textViewAwayName;
            this.textViewGoalHome = textViewGoalHome;
            this.textViewGoalAway = textViewGoalAway;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView textViewName = (TextView) rootView.findViewById(R.id.textStatus);
            TextView textViewHomeName = (TextView)rootView.findViewById(R.id.texthomeTeamName);
            TextView textViewAwayName = (TextView)rootView.findViewById(R.id.textawayTeamName);
            TextView textViewGoalHome = (TextView)rootView.findViewById(R.id.textHomeTeamGoal);
            TextView textViewGoalAway =   (TextView)rootView.findViewById(R.id.textAwayTeamGoal);
            return new ViewHolder(rootView,textViewName,textViewHomeName,textViewAwayName,textViewGoalHome,textViewGoalAway);
        }
    }
}
