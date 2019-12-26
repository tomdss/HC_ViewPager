package com.t3h.hc_viewpager;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

public class Face {
    private int color;
    private int faceId;
    private String name;

    public Face(int color, int faceId, String name) {
        this.color = color;
        this.faceId = faceId;
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getFaceId() {
        return faceId;
    }

    public void setFaceId(int faceId) {
        this.faceId = faceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

