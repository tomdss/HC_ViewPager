package com.t3h.hc_viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class FaceAdapter extends PagerAdapter {

    private ArrayList<Face> listFace;

    private LayoutInflater inflater;

    public FaceAdapter(Context context,ArrayList<Face> listFace) {
        this.listFace = listFace;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listFace.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //1.XML->view
        View v = inflater.inflate(R.layout.item_page,container,false);
        //2.Anh xa view
        ImageView imgBg = v.findViewById(R.id.img_bg);
        ImageView imIcon = v.findViewById(R.id.im_icon);
        TextView tvName = v.findViewById(R.id.tv_name);
        //3.Do du lieu
        Face face = listFace.get(position);

        imgBg.setImageResource(face.getColor());
        imIcon.setImageResource(face.getFaceId());
        tvName.setText(face.getName());
        //4.them vao container
        container.addView(v);
        return v;
    }





    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
