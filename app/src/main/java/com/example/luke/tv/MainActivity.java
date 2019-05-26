package com.example.luke.tv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RecyclerView movieList;
    private MovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = findViewById(R.id.list1);
        movieListAdapter = new MovieListAdapter();
        movieList.setLayoutManager(new LinearLayoutManager(this));
        movieList.setAdapter(movieListAdapter);
        movieListAdapter.setOnItemClickListener(new MovieListAdapter.OnItemClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this, "点击了第"+String.format("点击了第%s", position)
//                        +"条item", 600).show();
                Intent intent = new Intent(MainActivity.this, Play.class);
                intent.putExtra("name", position);
                startActivity(intent);
            }
        });
        movieList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        setTitle("MYTV");
    }
}
