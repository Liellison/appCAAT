package com.liellison.caat.caatapi16;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liellison.caat.caatapi16.fragments.CalendarioFragment;
import com.liellison.caat.caatapi16.fragments.DenunciaFragment;
import com.liellison.caat.caatapi16.fragments.MediaFragment;
import com.liellison.caat.caatapi16.fragments.NoticiasFragment;
import com.liellison.caat.caatapi16.fragments.QuemSFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;

    /*private final int[] tabIcons = {
            R.drawable.ic_action_home,
            R.drawable.ic_today_black_48dp,
            R.drawable.ic_group_black_48dp,
            R.drawable.ic_contact_mail_black_48dp
    };*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));

        tableLayout = (TabLayout) findViewById(R.id.tabLayout);
        tableLayout.setupWithViewPager(viewPager);
       // setupTabIcons();
        setupTabString();
        tableLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    /*private void setupTabIcons() {
        tableLayout.getTabAt(0).setIcon(tabIcons[0]);
        tableLayout.getTabAt(1).setIcon(tabIcons[1]);
        tableLayout.getTabAt(2).setIcon(tabIcons[2]);
        tableLayout.getTabAt(3).setIcon(tabIcons[3]);
    }*/
    private void setupTabString(){
        tableLayout.getTabAt(0).setText("Noticias");
        tableLayout.getTabAt(1).setText("Materias");
        tableLayout.getTabAt(2).setText("Denuncia");
        tableLayout.getTabAt(3).setText("Datas");
        tableLayout.getTabAt(4).setText("Nos");

    }

    private class CustomAdapter extends FragmentPagerAdapter {

        private final String[] fragments = {"1", "2", "3", "4", "Calendario"};

        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new NoticiasFragment();
                case 1:
                    return new MediaFragment();
                case 2:
                    return new DenunciaFragment();
                case 3:
                    return new CalendarioFragment();
                case 4:
                    return new QuemSFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}

