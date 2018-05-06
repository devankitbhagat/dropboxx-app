package in.drunkenbee.app.dropboxx;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import ss.com.bannerslider.Slider;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.tiffin, "Tiffin"))
                .addItem(new BottomNavigationItem(R.drawable.order, "Order"))
                .addItem(new BottomNavigationItem(R.drawable.cart, "Cart"))
                .setActiveColor("#FFFFFF")
                .setBarBackgroundColor(R.color.colorPrimary)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){

            android.support.v4.app.Fragment fragment;
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

            @Override
            public void onTabSelected(int position) {
                switch (position){
                    case 0: fragment = new Home();

                        android.support.v4.app.FragmentTransaction fthome = fragmentManager.beginTransaction();
                        fthome.replace(R.id.fragment_holder, fragment);
                        fthome.commit();
                        break;
                    case 1: fragment = new Category();
                        android.support.v4.app.FragmentTransaction fttiffin = fragmentManager.beginTransaction();
                        fttiffin.replace(R.id.fragment_holder, fragment);
                        fttiffin.commit();
                        break;

                    case 2: fragment = new Order();
                        android.support.v4.app.FragmentTransaction ftorder = fragmentManager.beginTransaction();
                        ftorder.replace(R.id.fragment_holder, fragment);
                        ftorder.commit();
                        break;

                    case 3: fragment = new Cart();
                        android.support.v4.app.FragmentTransaction ftcart = fragmentManager.beginTransaction();
                        ftcart.replace(R.id.fragment_holder, fragment);
                        ftcart.commit();
                        break;
                }
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });

    }
}
