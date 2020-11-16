package com.example.project_v1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewFragment extends Fragment
{
    TextView textView,textView1;
    ViewPager viewPager;
    MyFragmentPagerAdapter myFragmentPagerAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.view_fragment, container, false);

        textView=view.findViewById(R.id.view1);

        textView1=view.findViewById(R.id.view2);

        viewPager=view.findViewById(R.id.vp1);

        myFragmentPagerAdapter=new MyFragmentPagerAdapter(getFragmentManager(),2);//here it should be getSupportFragmentManager
        viewPager.setAdapter(myFragmentPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position)
            {
                colorChangeOnTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

        return view;
    }

     void colorChangeOnTab(int position)
     {
         if(position==0)
         {
             textView.setTextSize(24);
             textView.setTextColor(getResources().getColor((R.color.focus_colour)));

             textView1.setTextSize(20);
             textView1.setTextColor(getResources().getColor((R.color.othertabcolor)));
         }
         else if(position==1)
         {
             textView.setTextSize(20);
             textView.setTextColor(getResources().getColor((R.color.othertabcolor)));

             textView1.setTextSize(25);
             textView1.setTextColor(getResources().getColor((R.color.focus_colour)));
         }
     }



    static class MyFragmentPagerAdapter extends FragmentPagerAdapter
    {
        int tabs_count;
        MyFragmentPagerAdapter(FragmentManager fragmentManager,int tabs_count)//remember 2nd parameter remove cheyyali
        {
            super(fragmentManager);
            this.tabs_count=tabs_count;
        }

        @NonNull
        @Override
        public Fragment getItem(int position)
        {
            Fragment fragment=null;

            if(position==0)
            {
                fragment=new ViewCustomFragment();
            }
            else if(position==1)
            {
                fragment=new ViewAllFragment();
            }
            return fragment;
        }

        @Override
        public int getCount()
        {
            return tabs_count;
        }


    }

}
