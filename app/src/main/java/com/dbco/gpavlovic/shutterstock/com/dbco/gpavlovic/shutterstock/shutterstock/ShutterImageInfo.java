package com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock;

import com.google.gson.annotations.SerializedName;

public class ShutterImageInfo
{
    @SerializedName("id")
    private String mImageId;

    @SerializedName("aspect")
    private double mAspect;

    @SerializedName("assets")
    private ShutterAsset mAsset;

    private String mMediumImageDownloadURL = null;

    public String getImageId()
    {
        return mImageId;
    }

    public double getAspect()
    {
        return mAspect;
    }

    public ShutterAsset getAsset()
    {
        return mAsset;
    }

    public String getPreviewURL()
    {
       return mAsset.getPreviewAsset().getUrl();
    }
}
