package com.example.utsav.navigatiion_drawer;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.joda.time.DateTime;

import java.util.ArrayList;

import adapter.WhatsappAdapter;
import io.bloco.faker.Faker;
import io.bloco.faker.FakerData;
import model.Whatsapp;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WhatsappFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WhatsappFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    DateTime now;
    private RecyclerView rvWhatsapp;
    private ArrayList<Whatsapp> whatsappArrayList = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public WhatsappFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WhatsappFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WhatsappFragment newInstance(String param1, String param2) {
        WhatsappFragment fragment = new WhatsappFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_whatsapp, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        now = DateTime.now();


        rvWhatsapp = (RecyclerView) view.findViewById(R.id.rv_whatsapp);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rvWhatsapp.setLayoutManager(layoutManager);
        createDummyData();
        WhatsappAdapter whatsappAdapter = new WhatsappAdapter(getActivity(), whatsappArrayList);
        rvWhatsapp.setAdapter(whatsappAdapter);


    }

    private void createDummyData() {
        for (int i = 0; i < 20; i++) {

            String[] u = new String[i];

            Whatsapp whatsapp = new Whatsapp();
            whatsapp.setName("utsav shah");
            whatsapp.setMessage("hello 123 testing");
            whatsapp.setMessagecounter("" + i);
            whatsapp.setProfileUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTd8VBYEGBNRlLpWTSGXIWweogfUwQuSoZzZtMHXsI5sCyBqVJz3w");
            whatsapp.setTime("" + now.getHourOfDay() + ":" + now.getMinuteOfHour());
            whatsappArrayList.add(whatsapp);

        }


    }
}
