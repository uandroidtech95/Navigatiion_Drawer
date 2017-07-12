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
import java.util.Random;

import adapter.YoutubeAdapter;
import model.Youtube;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link YoutubeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YoutubeFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView rvYoutube;
    private ArrayList<Youtube> youtubeArrayList = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public YoutubeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment YoutubeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static YoutubeFragment newInstance(String param1, String param2) {
        YoutubeFragment fragment = new YoutubeFragment();
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
        return inflater.inflate(R.layout.fragment_youtube, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvYoutube = (RecyclerView) view.findViewById(R.id.rv_youtube);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvYoutube.setLayoutManager(layoutManager);
        dummyData();

        YoutubeAdapter youtubeAdapter = new YoutubeAdapter(getActivity(), youtubeArrayList);
        rvYoutube.setAdapter(youtubeAdapter);


    }

    private void dummyData() {
        for (int i = 0; i < 11; i++) {
            String title, profileUrl, youtubeUrl;
            Random random = new Random();

            Youtube youtube = new Youtube();
            DateTime dateTime = DateTime.now();
            youtube.setTime(dateTime.toLocalTime().toString());
            youtube.setYoutubeStream("Streamed " + random.nextInt(10) + "hours ago");
            youtube.setYoutubeOwner("Utsav shah");
            youtube.setTime("" + random.nextInt(12) + ":" + random.nextInt(59) + ":" + random.nextInt(59));
            if (i % 2 == 0) {
                title = "kapil sharma show";
                profileUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMjExNzA4MDYxN15BMl5BanBnXkFtZTcwOTI1MDAxOQ@@._V1_UY317_CR7,0,214,317_AL_.jpg";
                youtubeUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtOlYXVJ6P8M0Up9t-yDYTcVd7no0HgwFGR1oPm0PH1EgAOcrC2g";
            } else {
                title = "Tarak Mehta ka ooltha Chasma";
                profileUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdpdNjhlV3jjKQNJMhKKyk20v2Iy43zgrZ7QCFYKe-jT7Rn-9-";
                youtubeUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnJ34rA4pMBi234emWarYRz_ktweI0Dm1JxVMp-a11wrNYDoZl";
            }
            youtube.setYoutubeTitle(title);
            youtube.setProfileUrl(profileUrl);
            youtube.setYoutubeUrl(youtubeUrl);
            youtubeArrayList.add(youtube);
        }
    }
}
