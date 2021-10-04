package com.penguinstech.fooddeliveryapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavouriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavouriteFragment extends Fragment {


    private ArrayList<Food> listOfFoods;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FavouriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavouriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavouriteFragment newInstance(String param1, String param2) {
        FavouriteFragment fragment = new FavouriteFragment();
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

        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        init(view);
        return view;
    }

    private void init (View view) {

        listOfFoods = new ArrayList<>();
        loadFavorites();
        FoodAdapter foodAdapter = new FoodAdapter(getContext(), listOfFoods);
        GridView gridView = view.findViewById(R.id.favorites_grid_view);
        gridView.setAdapter(foodAdapter);
    }

    private void loadFavorites() {

        listOfFoods.add(new Food(R.drawable.pizza, "Chicken Pizza","Kshs. 800", "4/5", true, "12.10 pm", "Bamboo Hotel"));
        listOfFoods.add(new Food(R.drawable.burger, "Chicken Pizza","Kshs. 800", "4/5", true, "yesterday", "Bamboo Hotel"));
        listOfFoods.add(new Food(R.drawable.spaghetti, "Chicken Pizza","Kshs. 800", "4/5", true, "March 2", "Bamboo Hotel"));

    }
}