package ru.bodya.popov.ciceronetry;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HelloJavaFragment extends Fragment {

    public static HelloJavaFragment newInstance() {

        Bundle args = new Bundle();

        HelloJavaFragment fragment = new HelloJavaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.java_fragment, container, false);
    }
}
