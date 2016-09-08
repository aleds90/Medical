package com.example.estia.medicalapp.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.estia.medicalapp.R;
import com.example.estia.medicalapp.model.Thermo;
import com.example.estia.medicalapp.model.ThermoDAO;

import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class HomeFragment extends Fragment {


    public HomeFragment() {

    }

    Button btn_thermo, btn_tensio, btn_oxy, btn_scale, btn_gluco, btn_ecg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn_thermo = (Button)view.findViewById(R.id.btn_thermo);
        btn_tensio = (Button)view.findViewById(R.id.btn_tensio);
        btn_oxy = (Button)view.findViewById(R.id.btn_oxy);
        btn_scale = (Button)view.findViewById(R.id.btn_scale);
        btn_gluco = (Button)view.findViewById(R.id.btn_gluco);
        btn_ecg = (Button)view.findViewById(R.id.btn_ecg);

        btn_thermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThermoDAO thermoDAO = new ThermoDAO(getContext());
                int value = generateRandom();
                thermoDAO.save(new Thermo(value));
                new SweetAlertDialog(view.getContext(), SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Thermo calculated")
                        .setContentText("Your thermo is: "+value+"°")
                        .setCancelText("OK")
                        .showCancelButton(true)
                        .setConfirmText("DETTAGLIO")
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                                startDialog();
                            }
                        })
                        .show();
            }
        });

        btn_tensio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(view.getContext(), SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Tensio calculated")
                        .setContentText("Your tensio is: 62/124")
                        .show();
            }
        });

        btn_oxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(view.getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Fail During Calcutation")
                        .setContentText("Be sure your device work correctly")
                        .setConfirmText("Close and Retrive")
                        .show();

            }
        });

        btn_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(view.getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Fail During Calcutation")
                        .setContentText("Be sure your device work correctly")
                        .setConfirmText("Close and Retrive")
                        .show();

            }
        });

        btn_gluco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(view.getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Fail During Calcutation")
                        .setContentText("Be sure your device work correctly")
                        .setConfirmText("Close and Retrive")
                        .show();

            }
        });

        btn_ecg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(view.getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Fail During Calcutation")
                        .setContentText("Be sure your device work correctly")
                        .setConfirmText("Close and Retrive")
                        .show();

            }
        });

        return view;
    }

    private void startDialog(){
        final Dialog dialog = new Dialog(getView().getContext());
        dialog.setContentView(R.layout.detail_dialog);
        dialog.setTitle("RESOCONTO");
        //Button dialogButton = (Button) dialog.findViewById(R.id.dialog_home);
        // if button is clicked, close the custom dialog
        /*dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button dialogButton1 = (Button) dialog.findViewById(R.id.dialog_ok);
        // if button is clicked, close the custom dialog
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });*/
        dialog.show();

    }

    private int generateRandom(){
        Random r = new Random();
        int Low = 35;
        int High = 40;
        int Result = r.nextInt(High-Low) + Low;
        return Result;
    };
}
