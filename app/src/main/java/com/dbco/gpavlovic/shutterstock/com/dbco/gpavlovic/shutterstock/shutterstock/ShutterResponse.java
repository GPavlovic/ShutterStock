package com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShutterResponse
{
    @SerializedName("data")
    private List<ShutterImageInfo> mImageInfo;

    private String mMediumImageDownloadURL;

    public List<ShutterImageInfo> getImageInfo()
    {
        return mImageInfo;
    }
}
