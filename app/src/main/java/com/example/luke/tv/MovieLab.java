package com.example.luke.tv;

import java.util.ArrayList;
import java.util.List;

public class MovieLab {
    private static MovieLab instance = null;
    private List<String> movies;

    private MovieLab() { //构造方法

        init();
    }

    public static MovieLab get() {
        if (null == instance) {
            instance = new MovieLab();
        }
        return instance;
    }

    public int getSize() {
        return movies.size();
    }

    public String getMovie(int n) {
        return movies.get(n);
    }

    private void init() {
        movies = new ArrayList<>();
        movies.add("CCTV-1 综合");
        movies.add("CCTV-2 财经");
        movies.add("CCTV-3 综艺");
        movies.add("CCTV-4 中文国际");
        movies.add("CCTV-5 体育");
        movies.add("CCTV-6 电影");
        movies.add("CCTV-7 军事农业");
        movies.add("济南影视");
        movies.add("峨眉电影");
        movies.add("四川文化");
        movies.add("四川经济");
        movies.add("四川影视");
        movies.add("四川公共");
    }


}
