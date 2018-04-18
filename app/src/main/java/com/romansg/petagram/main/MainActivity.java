package com.romansg.petagram.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.romansg.petagram.R;

public class MainActivity extends AppCompatActivity implements MainView {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);
        presenter = new MainPresenterImpl(this, this);
    }

    @Override
    public void setupPagerAdapter(Fragment[] fragments, String[] tabTitles) {
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), fragments, tabTitles));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mContacto:
                presenter.verContacto();
                break;

            case R.id.mBiografia:
                presenter.verBiografia();
                break;

            case R.id.mReiniciar:
                presenter.reiniciarLikesMascotas();
                break;

            case R.id.mFavoritas:
                presenter.verMascotasFavoritas();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
