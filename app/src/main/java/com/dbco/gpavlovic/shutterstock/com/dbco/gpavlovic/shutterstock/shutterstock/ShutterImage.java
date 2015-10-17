package com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock;

import com.google.gson.annotations.SerializedName;

public class ShutterImage
{
    @SerializedName("url")
    private String mImageDownloadURL;

    public String getImageDownloadURL()
    {
        return mImageDownloadURL;
    }
}
