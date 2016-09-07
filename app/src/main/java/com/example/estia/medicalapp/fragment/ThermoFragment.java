package com.example.estia.medicalapp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.estia.medicalapp.R;
import com.example.estia.medicalapp.model.Thermo;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

public class ThermoFragment extends Fragment {

    private ArrayList<Thermo> thermos;

    public ThermoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_thermo, container, false);

        thermos = Thermo.generateThermo();

        LineChart chart = (LineChart) view.findViewById(R.id.chart1);
        chart.setData(generateDataLine(0));

        System.out.println("create");

        ListView listView = (ListView) view.findViewById(R.id.listview);
        ArrayList<String> names = new ArrayList<String>();
        names.clear();
        for(int i = 0; i < 6; i++) {
            names.add(i, "10/10/16 -- Valore Thermo: "+thermos.get(i).getValue());
        }
        ArrayAdapter<String> namesAA = new ArrayAdapter<String>( view.getContext(), android.R.layout.simple_list_item_1, names );
        listView.setAdapter(namesAA);
        return view;
    }


    private LineData generateDataLine(int cnt) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < 6; i++) {
            e1.add(new Entry(i+1, thermos.get(i).getValue()));

        }

        LineDataSet d1 = new LineDataSet(e1, "New DataSet " + cnt + ", (1)");
        d1.setLineWidth(2.5f);
        d1.setCircleRadius(4.5f);
        d1.setHighLightColor(Color.rgb(244, 117, 117));
        d1.setDrawValues(false);

        ArrayList<Entry> e2 = new ArrayList<Entry>();

        for (int i = 0; i < 6; i++) {
            e2.add(new Entry(i+1, 37));
        }

        LineDataSet d2 = new LineDataSet(e2, "New DataSet " + cnt + ", (2)");
        d2.setLineWidth(2.5f);
        d2.setCircleRadius(4.5f);
        d2.setHighLightColor(Color.rgb(244, 117, 117));
        d2.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        d2.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        d2.setDrawValues(false);

        ArrayList<ILineDataSet> sets = new ArrayList<ILineDataSet>();
        sets.add(d1);
        sets.add(d2);

        LineData cd = new LineData(sets);
        return cd;
    }

    private int generateRandom(){
        Random r = new Random();
        int Low = 35;
        int High = 40;
        int Result = r.nextInt(High-Low) + Low;
        return Result;
    };

}
