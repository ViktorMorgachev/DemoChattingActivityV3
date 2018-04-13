package viktor.demo.ru.demochattingactivity.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.io.IOException;
import java.io.InputStream;

import viktor.demo.ru.demochattingactivity.R;
import viktor.demo.ru.demochattingactivity.fragments.FragmentBird;
import viktor.demo.ru.demochattingactivity.fragments.FragmentCat;
import viktor.demo.ru.demochattingactivity.fragments.FragmentDog;
import viktor.demo.ru.demochattingactivity.interfaces.AnimalListener;

/**
 * Created by Developer on 12.04.2018.
 */

public class AnimalActivity extends AppCompatActivity implements AnimalListener {

    private TabHost.TabSpec tabSpec;
    private TextView textViewDescriprion;
    private ImageView imageView;
    private TabHost tabHost;
    public static final String TAG_LISTENER = "tag";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_layout_container);

        tabHost = findViewById(R.id.animal_tab_host);
        tabHost.setup();

        tabSpec = tabHost.newTabSpec("Cat_tag");
        tabSpec.setIndicator("Кошка");
        tabSpec.setContent(tabContentFactory);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Dog_tag");
        tabSpec.setIndicator("Собака");
        tabSpec.setContent(tabContentFactory);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Bird_tag");
        tabSpec.setIndicator("Птица");
        tabSpec.setContent(tabContentFactory);
        tabHost.addTab(tabSpec);

       /* Intent intent = getIntent();
        if (intent != null)
            if(intent.getExtras().getString(TAG_LISTENER) != null)
            tabHost.setCurrentTabByTag(intent.getStringExtra(TAG_LISTENER));*/
        // Временное решение
        if (getIntent().getStringExtra(AnimalActivity.TAG_LISTENER) != null)
            setTabContent(getIntent().getStringExtra(TAG_LISTENER));
    }




    // Custom method to get assets folder image as bitmap
    private Bitmap getBitmapFromAssets(String fileName) {

        AssetManager am = getAssets();
        InputStream is = null;
        try {
            is = am.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bitmap bitmap = BitmapFactory.decodeStream(is);
        return bitmap;
    }




/*
        FragmentPagerItemAdapter fragmentPagerAdapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(R.string.cat, FragmentCat.class)
                .add(R.string.dog, FragmentDog.class)
                .add(R.string.bird, FragmentBird.class).create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.animal_view_pager);
        viewPager.setAdapter(fragmentPagerAdapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);*/

    TabHost.TabContentFactory tabContentFactory = new TabHost.TabContentFactory() {
        @Override
        public View createTabContent(final String tag) {


            View view = getLayoutInflater().inflate(R.layout.tab_animal_fragment_layout, null);

            textViewDescriprion = (TextView) view.findViewById(R.id.text_animal);
            imageView = (ImageView) view.findViewById(R.id.image_animal);
            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AnimalActivity.this, OwnerActivity.class);
                    intent.putExtra(OwnerActivity.TAG_LISTENER, tag);
                    startActivity(intent);
                }
            };
            imageView.setOnClickListener(onClickListener);


            switch (tag) {
                case "Cat_tag": {

                    textViewDescriprion.setText(R.string.cat_description);
                    imageView.setImageBitmap(getBitmapFromAssets("cat.png"));
                }
                break;
                case "Dog_tag": {

                    textViewDescriprion.setText(R.string.dog_description);
                    imageView.setImageBitmap(getBitmapFromAssets("dog.png"));
                }
                break;
                case "Bird_tag": {

                    textViewDescriprion.setText(R.string.bird_description);
                    imageView.setImageBitmap(getBitmapFromAssets("bird.png"));
                }
                break;

            }

            return view;
        }
    };

    @Override
    public void showCat() {
        tabHost.setCurrentTabByTag("Cat_tag");
    }

    @Override
    public void showDog() {
        tabHost.setCurrentTabByTag("Dog_tag");
    }

    @Override
    public void showBird() {
        tabHost.setCurrentTabByTag("Bird_tag");
    }

    public void setTabContent(String tabContent) {
        switch (tabContent) {
            case "anastasia_tag": {
                showCat();
                break;
            }
            case "viktor_tag": {
                showDog();
                break;
            }
            case "marina_tag": {
                showBird();
                break;
            }
        }
    }
}


