package com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int CENTER = 2;
    private final Context context;

    public ChatAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = null;
        switch (viewType) {
            case LEFT:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_left_forum_chat, viewGroup, false);
                break;
            case RIGHT:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_right_forum_chat, viewGroup, false);
                break;
            case CENTER:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_center_forum_chat, viewGroup, false);
                break;

        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
