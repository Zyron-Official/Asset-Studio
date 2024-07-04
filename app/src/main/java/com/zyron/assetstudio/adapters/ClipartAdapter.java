package com.zyron.assetstudio.adapters;

import androidx.recyclerview.widget.GridLayoutManager; 
import java.util.List; 
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.zyron.assetstudio.R;

public class ClipartAdapter {
	
}

/*
public class ClipartAdapter extends RecyclerView.Adapter<ClipartAdapter.MyViewHolder> {

    private List<Item> data;
    private static final int NUM_COLUMNS = 7; // Change this to desired number of icons per row

    public ClipartAdapter(List<Item> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item item = data.get(position);
        holder.imageView.setImageResource(item.getDrawableId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return position % NUM_COLUMNS == 0 ? NUM_COLUMNS : 1;
                }
            });
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.clipartIcon); // Assuming the image view ID in your layout
        }
    }
}*/
