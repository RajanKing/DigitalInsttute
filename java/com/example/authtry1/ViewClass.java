package com.example.authtry1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewClass extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_view_class, container, false);
        View view = inflater.inflate(R.layout.fragment_view_class, container, false);
        Intent i = new Intent(getActivity(),recycler.class);
        startActivity(i);
        return view;
    }
}