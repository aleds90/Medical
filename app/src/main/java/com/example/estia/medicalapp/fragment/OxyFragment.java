package com.example.estia.medicalapp.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.estia.medicalapp.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class OxyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public OxyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_oxy, container, false);
        BarChart chart = (BarChart) view.findViewById(R.id.chart1);
        chart.setData(generateDataBar(7));

        System.out.println("create");

        ListView listView = (ListView) view.findViewById(R.id.listview);
        ArrayList<String> names = new ArrayList<String>();
        names.clear();
        names.add(0, "10/10/16 -- Valore Oxy: 140°");
        names.add(1, "01/10/16 -- Valore Oxy: 130°");
        names.add(2, "28/09/16 -- Valore Oxy: 134°");
        names.add(3, "24/09/16 -- Valore Oxy: 188°");
        names.add(4, "23/09/16 -- Valore Oxy: 117°");
        ArrayAdapter<String> namesAA = new ArrayAdapter<String>( view.getContext(), android.R.layout.simple_list_item_1, names );
        listView.setAdapter(namesAA);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("start");
    }

    private BarData generateDataBar(int cnt) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < 12; i++) {
            entries.add(new BarEntry(i, (int) (Math.random() * 70) + 30));
        }

        BarDataSet d = new BarDataSet(entries, "New DataSet " + cnt);
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);

        BarData cd = new BarData(d);
        cd.setBarWidth(0.9f);
        return cd;
    }
}
