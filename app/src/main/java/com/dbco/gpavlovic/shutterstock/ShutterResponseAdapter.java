package com.dbco.gpavlovic.shutterstock;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock.ShutterImageInfo;
import com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock.ShutterResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShutterResponseAdapter extends RecyclerView.Adapter<ShutterResponseAdapter.ViewHolder>
{
    private List<ShutterImageInfo> mImageList;
    private Context mContext;
    private AdapterView.OnItemClickListener mOnItemClockListener;

    ShutterResponseAdapter(Context context, List<ShutterImageInfo> imageList)
    {
        mContext = context;
        mImageList = imageList;
    }

    public void setOnItemClockListener(AdapterView.OnItemClickListener onItemClockListener)
    {
        this.mOnItemClockListener = onItemClockListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_grid_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        ShutterImageInfo currImage = mImageList.get(position);
        Picasso.with(mContext).load(currImage.getPreviewURL()).into(holder.imageIV);
    }

    @Override
    public int getItemCount()
    {
        return mImageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private final ImageView imageIV;

        ViewHolder(View v)
        {
            super(v);

            imageIV = (ImageView) v.findViewById(R.id.grid_item_imageview);
        }

        @Override
        public void onClick(View v)
        {

        }
    }
}
