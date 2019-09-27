package com.mounts.lenovo.delivery3.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.activity.Details;
import com.mounts.lenovo.delivery3.fragment.CategoriesFragment;

public class ImageAdapter extends PagerAdapter {
//    Context mContext;
//    int images[];
//    LayoutInflater layoutInflater;
//
//    public ImageAdapter(Context context, int images[]) {
//        this.mContext = context;
//        this.images = images;
//        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == ((LinearLayout) object);
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, final int position) {
//        View itemView = layoutInflater.inflate(R.layout.item, container, false);
//        ImageView imageView = itemView.findViewById(R.id.imageViewItem);
//        imageView.setImageResource(images[position]);
//        container.addView(itemView);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//         Toast.makeText(mContext, "clicked" + (position + 1), Toast.LENGTH_LONG).show();
//                mContext.startActivity(new Intent(mContext, Details.class));
//            }
//        });
//        return itemView;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView((LinearLayout) object);
//    }
//
//    @Override
//    public int getCount() {
//        return images.length;
//    }

    Context mContext;

    public ImageAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    private int[] sliderImageId = new int[]{
            R.drawable.img1, R.drawable.images1, R.drawable.img4, R.drawable.donut, R.drawable.img5};

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(sliderImageId[position]);
        ((ViewPager) container).addView(imageView, 0);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "clicked the image" + (position + 1), Toast.LENGTH_LONG).show();
                mContext.startActivity(new Intent(mContext, Details.class));//when click the image from view pager,intent to "Details.java"
                Log.e("Clicked", "view pager");
            }
        });
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return sliderImageId.length;
    }
}
