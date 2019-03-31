package com.example.reham.booksborrowing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reham.booksborrowing.fragment.BooksFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class BooksListRecyclerAdapter extends RecyclerView.Adapter<BooksListRecyclerAdapter.ViewHolder> {

    private final List<String> mImages;
    private final List<String> mTitles;
    private final List<String> mIds;
    Context mContext;
    private final OnListFragmentInteractionListener mListener;

    public BooksListRecyclerAdapter(Context context,List<String> Images,List<String> Titles,List<String> ids, OnListFragmentInteractionListener listener) {
        mContext=context;
        mImages = Images;
        mTitles =Titles;
        mIds=ids;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
       holder.mContentView.setText(mTitles.get(position).toString());
        Picasso.with(mContext).load(mImages.get(position)).into(holder.imageView);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction("id",mIds.get(position).toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView imageView;
        public final TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageView= (ImageView) view.findViewById(R.id.image);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
