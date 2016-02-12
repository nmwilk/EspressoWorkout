package com.nmwilkinson.espressoworkout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by neil on 11/02/16.
 */
public class SimpleListAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    private final List<String> items;
    private final SelectionListener clickListener;

    public SimpleListAdapter(final List<String> items, final SelectionListener clickListener) {
        this.items = items;
        this.clickListener = clickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ListItemViewHolder(view, (ImageView) view.findViewById(R.id.icon), (TextView) view.findViewById(R.id.value), this);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final ListItemViewHolder listItemViewHolder = (ListItemViewHolder) holder;
        listItemViewHolder.itemView.setTag(position);
        listItemViewHolder.value.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(final View v) {
        clickListener.valueSelected(items.get((Integer) v.getTag()));
    }

    public interface SelectionListener {
        void valueSelected(String value);
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {
        private final ImageView icon;
        private final TextView value;

        public ListItemViewHolder(final View view, final ImageView icon, final TextView value, final View.OnClickListener clickListener) {
            super(view);
            view.setOnClickListener(clickListener);
            this.icon = icon;
            this.value = value;
        }
    }
}
