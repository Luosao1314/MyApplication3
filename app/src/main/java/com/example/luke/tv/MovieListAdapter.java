package com.example.luke.tv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MoiveViewHolder> implements View.OnClickListener {
    private String[] datas;
    private OnItemClickListener mOnItemClickListener = null;
    private ImageView i1;
    private int[] icon = {
            R.drawable.c1,
            R.drawable.c2,
            R.drawable.c3,
            R.drawable.c4,
            R.drawable.c5,
            R.drawable.c6,
            R.drawable.c7,
            R.drawable.j1,
            R.drawable.e1,
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
    };

    @NonNull
    @Override
    public MoiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View container = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.movie_view, parent, false);

        MoiveViewHolder vh = new MoiveViewHolder(container);
        container.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MoiveViewHolder holder, int i) {
        String name = MovieLab.get().getMovie(i);
        holder.bind(name);
//        holder.moiveName.setText(datas[i]);
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(i);
        i1 = holder.itemView.findViewById(R.id.imglist);
        i1.setImageResource(icon[i]);
    }

    @Override
    public int getItemCount() {
        return MovieLab.get().getSize();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public class MoiveViewHolder extends RecyclerView.ViewHolder {
        public TextView moiveName;

        public MoiveViewHolder(View container) {
            super(container);
            moiveName = container.findViewById(R.id.movieName);
        }

        public void bind(String movieName) {
            this.moiveName.setText(movieName);
        }
    }

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}

