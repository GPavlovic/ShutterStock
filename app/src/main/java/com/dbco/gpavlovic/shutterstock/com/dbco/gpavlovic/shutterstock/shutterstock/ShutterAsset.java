package com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock;

import com.google.gson.annotations.SerializedName;

public class ShutterAsset
{
    @SerializedName("preview")
    private AssetInfo mPreviewAsset;

    public AssetInfo getPreviewAsset()
    {
        return mPreviewAsset;
    }

    public class AssetInfo
    {
        @SerializedName("display_name")
        private String displayName;

        @SerializedName("height")
        private int height;

        @SerializedName("width")
        private int width;

        @SerializedName("url")
        private String url;

        public String getDisplayName()
        {
            return displayName;
        }

        public int getHeight()
        {
            return height;
        }

        public int getWidth()
        {
            return width;
        }

        public String getUrl()
        {
            return url;
        }
    }
}
