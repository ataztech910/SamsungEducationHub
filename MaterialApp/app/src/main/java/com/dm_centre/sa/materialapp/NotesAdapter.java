package com.dm_centre.sa.materialapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Loki on 02.09.15.
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>
{
    private String[] mDataset;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }
    public NotesAdapter(String[] myDataset) {
        mDataset = myDataset;
    }
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext()) .inflate(R.layout.note_view, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
    }
    @Override
    public int getItemCount() {
        return mDataset.length;
    } }
