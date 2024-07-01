package com.uos.myapplication;

import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class ListView extends ArrayAdapter<TV_Shows> {

    private ArrayList<TV_Shows> tvShows;
    public ListView(@NonNull Context context, int resource, @NonNull ArrayList<TV_Shows> objects) {
            //context is going to be the main activity
        //resource is going to be linked to the tv show list item layout
        //objects refers to the array of shows
        super(context, resource, (List<TV_Shows>) objects);
        this.tvShows = objects;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tv_shows_items, parent, false);

        //now we get the ild data from exisiting view here

        ImageView i = convertView.findViewById(R.id.image);
        TextView show_title = convertView.findViewById(R.id.name);
        TextView rating = convertView.findViewById(R.id.rating);
        RatingBar ratingBar = convertView.findViewById(R.id.bar);
        TextView date = convertView.findViewById(R.id.date);
        TextView genre = convertView.findViewById(R.id.genre);


        //TV_Shows tv_shows = tvShows.get(position);

        show_title.setText(tvShows.get(position).getTitle());
        i.setImageResource(tvShows.get(position).getImage_id());
        rating.setText(tvShows.get(position).getRating());
        date.setText(tvShows.get(position).getYear());
        genre.setText(tvShows.get(position).getGenre());
        //

        float ratingValueOutOf10 = Float.parseFloat(tvShows.get(position).getRating());
        float ratingValueOutOf5 = (ratingValueOutOf10 / 2.0f);
        ratingBar.setRating(ratingValueOutOf5);
        //since my ratings are out of 10 on the mainactivity, i had to do divide the rating by 2
        // because the stars are 5, so the app wont understand it

        return convertView;

    }


}
