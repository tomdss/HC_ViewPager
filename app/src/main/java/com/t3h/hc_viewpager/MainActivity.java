package com.t3h.hc_viewpager;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import jp.shts.android.storiesprogressview.StoriesProgressView;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements StoriesProgressView.StoriesListener, ViewPager.OnPageChangeListener {

    private static final int PROGRESS_COUNT = 5;
    private ArrayList<Face> listFace;

    private ViewPager vpPager;
    private int currentItem = 0;

    //    private CircleIndicator ciDemo;
    private StoriesProgressView storiesProgressView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initData();
        initViews();
    }

    private void initData() {
        listFace = new ArrayList<>();
        listFace.add(new Face(imageSet(R.color.colorAccent), R.drawable.happy, "Happy Smile"));
        listFace.add(new Face(imageSet(R.color.colorAs), R.drawable.muted, "No Smile"));
        listFace.add(new Face(imageSet(R.color.colorAb), R.drawable.crying, "Crying ..."));
        listFace.add(new Face(imageSet(R.color.colorPrimary), R.drawable.kiss, "Kiss ..."));
        listFace.add(new Face(imageSet(R.color.colorPrimaryDark), R.drawable.sad, "Sad so much"));
    }

    private Drawable imageSet(int img) {
        Drawable d = getResources().getDrawable(img);
        return d;
    }

    private void initViews() {
        vpPager = findViewById(R.id.vp_pager);
        FaceAdapter adapter = new FaceAdapter(this, listFace);
        vpPager.setAdapter(adapter);
//        ciDemo = findViewById(R.id.ci_demo);
//        ciDemo.setViewPager(vpPager);
        storiesProgressView = (StoriesProgressView) findViewById(R.id.stories);
        storiesProgressView.setStoriesCount(PROGRESS_COUNT); // <- set stories
        storiesProgressView.setStoryDuration(2500L); // <- set a story duration
        storiesProgressView.setStoriesListener(this); // <- set listener
        storiesProgressView.startStories(); // <- start progress

        vpPager.addOnPageChangeListener(this);

    }

    @Override
    public void onNext() {
        Toast.makeText(this, "onNext", Toast.LENGTH_SHORT).show();
        if(currentItem<4){
            currentItem++;
            vpPager.setCurrentItem(currentItem);
        }
    }

    @Override
    public void onPrev() {
        // Call when finished revserse animation.
        Toast.makeText(this, "onPrev", Toast.LENGTH_SHORT).show();
        if(currentItem>0){
            currentItem--;
            vpPager.setCurrentItem(currentItem);
        }
    }

    @Override
    public void onComplete() {
        Toast.makeText(this, "onComplete", Toast.LENGTH_SHORT).show();
        currentItem = 0;
        vpPager.setCurrentItem(currentItem);
        storiesProgressView.startStories();
    }



    @Override
    protected void onDestroy() {
        // Very important !
        storiesProgressView.destroy();
        super.onDestroy();
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        Log.d("vpr onPageScrolled : ","i="+i+" v="+v+" i1="+i1);
    }

    @Override
    public void onPageSelected(int i) {
        Log.d("vpr onPageSelected : ","i="+i);
        storiesProgressView.startStories(i);

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        Log.d("vpr onStateChanged : ","i="+i);
    }
}
