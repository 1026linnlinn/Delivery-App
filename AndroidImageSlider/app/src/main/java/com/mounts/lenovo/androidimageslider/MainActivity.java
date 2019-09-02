package com.mounts.lenovo.androidimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    SliderLayout sliderLayout;
    HashMap<String, String> Hash_file_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = findViewById(R.id.slider);

        Hash_file_maps.put("Android CupCake", String.valueOf(R.drawable.img1));
        Hash_file_maps.put("Android Eclair", String.valueOf(R.drawable.img2));
        Hash_file_maps.put("Android Froyo", String.valueOf(R.drawable.img3));
        Hash_file_maps.put("Android Donut", String.valueOf(R.drawable.img4));
        Hash_file_maps.put("Android Ginger", String.valueOf(R.drawable.img5));
//        Hash_file_maps.put("Android Donut", "https://media1.popsugar-assets.com/files/thumbor/vvgBh51WTjLEUjwzNqr6r67nkos/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2018/01/19/998/n/28443503/tmp_PTbtGB_643a8b7c86ece221_PS16_D1_Stills_5103.jpg");
//        Hash_file_maps.put("Android Eclair", "https://media1.popsugar-assets.com/files/thumbor/vvgBh51WTjLEUjwzNqr6r67nkos/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2018/01/19/998/n/28443503/tmp_PTbtGB_643a8b7c86ece221_PS16_D1_Stills_5103.jpg");
//        Hash_file_maps.put("Android Froyo", "https://media1.popsugar-assets.com/files/thumbor/vvgBh51WTjLEUjwzNqr6r67nkos/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2018/01/19/998/n/28443503/tmp_PTbtGB_643a8b7c86ece221_PS16_D1_Stills_5103.jpg");
//        Hash_file_maps.put("Android GingerBread", "https://media1.popsugar-assets.com/files/thumbor/vvgBh51WTjLEUjwzNqr6r67nkos/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2018/01/19/998/n/28443503/tmp_PTbtGB_643a8b7c86ece221_PS16_D1_Stills_5103.jpg");

        for (String name : Hash_file_maps.keySet()) {

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);
    }

    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
