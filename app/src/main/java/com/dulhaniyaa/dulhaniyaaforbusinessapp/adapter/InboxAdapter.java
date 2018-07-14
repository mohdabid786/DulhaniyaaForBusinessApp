package com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> implements View.OnClickListener {
    private final Context context;

    public InboxAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.a_inbox, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.inboxTitleTv.setSingleLine();
        holder.inboxTitleTv.setSelected(true);
        holder.inboxLl.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inbox_main_ll:
               /* Intent intent1 = new Intent(context, ChatActivity.class);
                context.startActivity(intent1);*/
                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView inboxIv;
        private final TextView inboxTitleTv;
        private final LinearLayout inboxLl;

        public ViewHolder(View itemView) {
            super(itemView);
            inboxIv = itemView.findViewById(R.id.inbox_iv);
            inboxTitleTv = itemView.findViewById(R.id.inbox_tv);
            inboxLl = itemView.findViewById(R.id.inbox_main_ll);
        }
    }
}
