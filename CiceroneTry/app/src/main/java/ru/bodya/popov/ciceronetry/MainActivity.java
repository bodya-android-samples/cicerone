package ru.bodya.popov.ciceronetry;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import static ru.bodya.popov.ciceronetry.MainActivityActions.JAVA_ACTION;
import static ru.bodya.popov.ciceronetry.MainActivityActions.KOTLIN_ACTION;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SampleApplication.INSTANCE.getNavigationHolder().setNavigator(mNavigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SampleApplication.INSTANCE.getNavigationHolder().removeNavigator();
    }

    private void initViews() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private Navigator mNavigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.main_activity_container) {
        @Override
        protected Fragment createFragment(@MainActivityActions String screenKey, Object data) {
            switch (screenKey) {
                case JAVA_ACTION:
                    return HelloJavaFragment.newInstance();
                case KOTLIN_ACTION:
                    return HelloKotlinFragment.newInstance();
                default:
                    throw new RuntimeException("Unknown screen key!");
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_java:
                    SampleApplication.INSTANCE.getRouter().replaceScreen(JAVA_ACTION);
                    return true;
                case R.id.navigation_kotlin:
                    SampleApplication.INSTANCE.getRouter().replaceScreen(KOTLIN_ACTION);
                    return true;
            }
            return false;
        }
    };


}
