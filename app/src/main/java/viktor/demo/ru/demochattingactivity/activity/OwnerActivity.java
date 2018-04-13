package viktor.demo.ru.demochattingactivity.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import viktor.demo.ru.demochattingactivity.R;

/**
 * Created by Developer on 12.04.2018.
 */

public class OwnerActivity extends AppCompatActivity {
    private TabHost.TabSpec tabSpec;
    private TextView textViewDescriprion;
    private ImageView imageView;
    public static final String TAG_LISTENER = "tag";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_layout_container);

        TabHost tabHost = findViewById(R.id.owner_tab_host);
        tabHost.setup();

        tabSpec = tabHost.newTabSpec("anastasia_tag");
        tabSpec.setIndicator("Настя");
        tabSpec.setContent(tabContentFactory);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("marina_tag");
        tabSpec.setIndicator("Камила");
        tabSpec.setContent(tabContentFactory);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("viktor_tag");
        tabSpec.setIndicator("Виктор");
        tabSpec.setContent(tabContentFactory);
        tabHost.addTab(tabSpec);

        // Временное решение
        setCurrentTab(getIntent().getStringExtra(TAG_LISTENER), tabHost);

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


            View view = getLayoutInflater().inflate(R.layout.tab_owner_fragment_layout, null);

            textViewDescriprion = (TextView) view.findViewById(R.id.text_animal);
            imageView = (ImageView) view.findViewById(R.id.image_animal);
            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(OwnerActivity.this, AnimalActivity.class);
                    intent.putExtra(OwnerActivity.TAG_LISTENER, tag);
                    startActivity(intent);
                }
            };
            imageView.setOnClickListener(onClickListener);

            switch (tag) {
                case "anastasia_tag": {
                    textViewDescriprion.setText(R.string.anastasia_description);
                    imageView.setImageBitmap(getBitmapFromAssets("anastasia.png"));
                }
                break;
                case "marina_tag": {
                    textViewDescriprion.setText(R.string.marina_description);
                    imageView.setImageBitmap(getBitmapFromAssets("kamila.png"));
                }
                break;
                case "viktor_tag": {
                    textViewDescriprion.setText(R.string.viktor_description);
                    imageView.setImageBitmap(getBitmapFromAssets("viktor.png"));
                }
                break;

            }

            return view;
        }
    };

    private void setCurrentTab(String currentTab, TabHost tabHost) {
        switch (currentTab){
            case "Cat_tag":{
                tabHost.setCurrentTabByTag("anastasia_tag");
            } break;
            case "Dog_tag":{
                tabHost.setCurrentTabByTag("viktor_tag");
            } break;
            case "Bird_tag":{
                tabHost.setCurrentTabByTag("marina_tag");
            } break;
        }

    }
}
