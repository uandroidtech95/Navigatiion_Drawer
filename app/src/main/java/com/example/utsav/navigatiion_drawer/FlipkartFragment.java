package com.example.utsav.navigatiion_drawer;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;

import adapter.FlipkartAdapter;
import model.Flipkart;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlipkartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlipkartFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rvFlipkart;

    private ArrayList<Flipkart> flipkartArrayList = new ArrayList<>();


    public FlipkartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FlipkartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlipkartFragment newInstance(String param1, String param2) {
        FlipkartFragment fragment = new FlipkartFragment();
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
        return inflater.inflate(R.layout.fragment_flipkart, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFlipkart = (RecyclerView) view.findViewById(R.id.rv_flipkart);
     //   RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        RecyclerView.LayoutManager layoutManager1=new GridLayoutManager(getActivity(),2);
        rvFlipkart.setLayoutManager(layoutManager1);
        rvFlipkart.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        rvFlipkart.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));


        dummydata();
        FlipkartAdapter flipkartAdapter = new FlipkartAdapter(flipkartArrayList, getActivity());
        rvFlipkart.setAdapter(flipkartAdapter);


    }

    private void dummydata() {

        for (int i = 0; i < 10; i++) {

            Flipkart flipkart = new Flipkart();
            String url, name;
            Random random = new Random();

            flipkart.setMobilePrice("Now ₹ " + random.nextInt(72) + "," + random.nextInt(999));
            flipkart.setMobileOffer("Flat ₹ " + random.nextInt(1400) + " off");

            if (i == 2 || i == 4 || i == 8 || i == 10) {
                name = "Samsung Galaxy S8";
                url = "http://www.samsung.com/in/smartphones/galaxy-s8/images/gallery/galaxy-s8_gallery_front_black.jpg";
            } else if (i % 3 == 0) {
                name = "Iphone 7 Red Edition";
                url = "https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone7/model/iphone7-model-select-201703?wid=212&hei=293&fmt=png-alpha&qlt=95&.v=1489097365439";
            } else {
                name = "Nokia 6";
                url = "https://images.contentful.com/wcfotm6rrl7u/5eLOyoerrqY8Qumos64E6/406a4c771818ed61673bc79569e48e65/Nokia6-Matte-Black.jpg?fm=jpg&h=500";
            }
            flipkart.setMobileName(name);
            flipkart.setMobileUrl(url);
            flipkartArrayList.add(flipkart);
        }
    }
}
