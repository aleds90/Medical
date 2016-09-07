package com.example.estia.medicalapp.fragment;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.example.estia.medicalapp.R;

import java.util.ArrayList;
import java.util.List;

public class StatFragment extends Fragment {

    Spinner sp_stat;
    FrameLayout fragment;

    public StatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_stat, container, false);

        fragment = (FrameLayout)view.findViewById(R.id.stat_fragment);

        Fragment newFragment = new AllStatsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.stat_fragment, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        sp_stat     = (Spinner) view.findViewById(R.id.sp_stat_fragment);
        List<String> list = new ArrayList<String>();
        list.add("All Stats");
        list.add("Thermo");
        list.add("Tensio");
        list.add("Oxy");
        list.add("Scale");
        list.add("Gluco");
        list.add("ECG");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_stat.setAdapter(dataAdapter);

        spinnerOnChange();
        return view;
    }

    private void spinnerOnChange(){

        sp_stat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Fragment allStatsFragment = new AllStatsFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.stat_fragment, allStatsFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                if (i == 1) {
                    Fragment thermoFragment = new ThermoFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.stat_fragment, thermoFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                if (i == 2){
                    Fragment tensioFragment = new TensioFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.stat_fragment, tensioFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                if (i == 3) {
                    Fragment oxyFragment = new OxyFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.stat_fragment, oxyFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                if (i == 4)
                    System.out.println(i);
                if (i == 5)
                    System.out.println(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
