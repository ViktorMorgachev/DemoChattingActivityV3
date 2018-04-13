package viktor.demo.ru.demochattingactivity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import viktor.demo.ru.demochattingactivity.R;
import viktor.demo.ru.demochattingactivity.fragments.FragmentBird;
import viktor.demo.ru.demochattingactivity.fragments.FragmentCat;
import viktor.demo.ru.demochattingactivity.fragments.FragmentDog;
import viktor.demo.ru.demochattingactivity.fragments.FragmentOwnerBird;
import viktor.demo.ru.demochattingactivity.fragments.FragmentOwnerCat;
import viktor.demo.ru.demochattingactivity.fragments.FragmentOwnerDog;
import viktor.demo.ru.demochattingactivity.interactors.AnimalInteractor;
import viktor.demo.ru.demochattingactivity.interactors.OwnerInteractor;
import viktor.demo.ru.demochattingactivity.interactors.StaticFieldInteractor;
import viktor.demo.ru.demochattingactivity.interfaces.AnimalListener;

/**
 * Created by Developer on 12.04.2018.
 */

public class AnimalActivity extends AppCompatActivity implements AnimalListener {



    private ViewPager mViewPager;
    private SectionsPagerAdapter sectionsPagerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_layout_container);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);



        // Я так понял связываем их
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        mViewPager.setCurrentItem(getIntent()
                .getIntExtra(StaticFieldInteractor.StaticField.ANIMAL, AnimalInteractor.AnimalField.Cat));

    }




    @Override
    public void showCatOwner() {
        Intent intent = new Intent(this, OwnerActivity.class);
        intent.putExtra(StaticFieldInteractor.StaticField.OWNER, OwnerInteractor.OwnerField.ANASTASIA);
        startActivity(intent);
    }

    @Override
    public void showDogOwner() {
        Intent intent = new Intent(this, OwnerActivity.class);
        intent.putExtra(StaticFieldInteractor.StaticField.OWNER, OwnerInteractor.OwnerField.VIKTOR);
        startActivity(intent);
    }

    @Override
    public void showBirdOwner() {
        Intent intent = new Intent(this, OwnerActivity.class);
        intent.putExtra(StaticFieldInteractor.StaticField.OWNER, OwnerInteractor.OwnerField.MARINA);
        startActivity(intent);
    }


    private class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                // getItem is called to instantiate the fragment for the given page.
                // Return a PlaceholderFragment (defined as a static inner class below).
                //return Main2Activity.PlaceholderFragment.newInstance(position + 1);
                switch (position) {
                    case AnimalInteractor.AnimalField.Cat: {
                        return new FragmentCat();
                    }
                    case AnimalInteractor.AnimalField.Dog: {
                        return new FragmentDog();
                    }
                    case AnimalInteractor.AnimalField.Bird: {
                        return new FragmentBird();
                    }
                }

                return null;
            }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
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

}


