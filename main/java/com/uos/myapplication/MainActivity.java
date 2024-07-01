package com.uos.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ListView listView; //this is for the listview
    private ArrayList<TV_Shows> tv_shows; //this is fo[

    private int lastRandomIndex = -1; // Initialize to an invalid value
    //i will be using this to add new tv shows for longclick,
    // and new tv shows will be randomly added
    //however i dont want to add same random show


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview); //the listview from activity_main.xml

        tv_shows = new ArrayList<TV_Shows>();
        tv_shows.add(new TV_Shows("Breaking Bad", "2008 - 2013", "9.5", "Serial, Crime, Thriller", R.drawable.bb));
        tv_shows.add(new TV_Shows("Better Call Saul", "2015 - 2022", "9.0", "Serial, Crime, Drama", R.drawable.bcs));
        tv_shows.add(new TV_Shows("Prison Break", "2015 - 2017", "8.3", "Suspense, Action", R.drawable.pb));
        tv_shows.add(new TV_Shows("Dark", "2017 - 2020", "8.7", "Mystery, Drama", R.drawable.dark));
        tv_shows.add(new TV_Shows("Sopranos", "1999 - 2007", "9.2", "Serial, Crime, Drama", R.drawable.sop));
        tv_shows.add(new TV_Shows("Daredevil", "2015 - 2018", "8.6", "Action, Adventure", R.drawable.dd));
        tv_shows.add(new TV_Shows("Mr Robot", "2015 - 2019", "8.5", "Mystery, Drama", R.drawable.robot));
        tv_shows.add(new TV_Shows("Invincible", "2021 - current", "8.7", "Fantasy, Action", R.drawable.in));
        tv_shows.add(new TV_Shows("Rise of Ottoman Empire", "2020-2022", "7.9", "History, Drama", R.drawable.ottomon));
        tv_shows.add(new TV_Shows("Chernobyl", "2019", "9.3", "History Drama", R.drawable.cher));

        ArrayAdapter<TV_Shows> arrayAdapter = new com.uos.myapplication.ListView(MainActivity.this, R.layout.tv_shows_items, tv_shows);
        //in the brackets (), what i need to add is
        // (where i want to show the list, how i want to show it, what i want to show)
        //always remember that to show how it should be on display, the refrence goes by R.layout.thexmlname. since last time i added android along with it.
        listView.setAdapter(arrayAdapter); //here i should call the listview from the xml file, not the names of the list i added in this main activity file

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Provide visual feedback for the click action, grayed out meaning already checked, can be of differnet color
                view.setBackgroundColor(Color.GRAY);

                // i can also perform other actions based on the click event
                TV_Shows clickedShow = tv_shows.get(position);
                // Handle the click action for the clicked TV show
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // i can add a new TV show or use a dialog/input for user input
                String[] titles = {"The Mandolorian", "Peaky Blinders", "The Last of US" , "The Witcher"};
                String[] dates = {"2019 - current", "2013-2022", "2023 - current", "2019- current"};
                String[] ratings = {"8.7", "8.8", "8.8", "8.0"};
                String[] genres = {"Action, Fantasy", "History, Drama", "Fantasy, Survivval", "Fantasy"};
                int[] images = {R.drawable.man, R.drawable.pk, R.drawable.lastofus, R.drawable.witcher};

                int randomIndex;

                //a loop to prevent random same tv show to be added
                //each time it shold be diff
                do {
                    randomIndex = new Random().nextInt(titles.length);
                } while (randomIndex == lastRandomIndex);

                lastRandomIndex = randomIndex; // here this will updte the last random index

                TV_Shows newShow = new TV_Shows(
                        titles[randomIndex],
                        dates[randomIndex],
                        ratings[randomIndex],
                        genres[randomIndex],
                        images[randomIndex]
                );

                // adding the new TV show to the list at the position after the long-clicked item,
                //it will be on the next postion of the list clicked, liike for example if i click on darevil,
                //the next random item will be added affter it
                tv_shows.add(position + 1, newShow);

                // Notify the adapter that the data has changed
                ((ArrayAdapter<TV_Shows>) listView.getAdapter()).notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), "Cool TV Show added", Toast.LENGTH_SHORT).show();


                return true; // Return true to indicate that the long click event is consumed
            }
        });


    }
}