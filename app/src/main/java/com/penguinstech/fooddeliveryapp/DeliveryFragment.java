package com.penguinstech.fooddeliveryapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeliveryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeliveryFragment extends Fragment {

    private boolean isActiveDeliveries = true;
    private Chip activeDeliveriesChip;
    private Chip completeDeliveriesChip;
    private ArrayList<Food> listOfFoods;
    private FoodAdapter foodAdapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeliveryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeliveryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeliveryFragment newInstance(String param1, String param2) {
        DeliveryFragment fragment = new DeliveryFragment();
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
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);
        init(view);
        return view;
    }

    private void init(View view) {

        activeDeliveriesChip = view.findViewById(R.id.activeDeliveries);
        completeDeliveriesChip = view.findViewById(R.id.completeDeliveries);
        GridView gridView = view.findViewById(R.id.deliveries_grid_view);
        listOfFoods = new ArrayList<>();
        foodAdapter = new FoodAdapter(getContext(), listOfFoods);
        gridView.setAdapter(foodAdapter);

        activeDeliveriesChip.setOnClickListener(v -> {
            isActiveDeliveries = true;
            loadData();
        });
        completeDeliveriesChip.setOnClickListener(v -> {
            isActiveDeliveries = false;
            loadData();
        });

        loadData();

    }

    private void loadData() {
        listOfFoods.clear();
        if(isActiveDeliveries){

            activeDeliveriesChip.setChipBackgroundColorResource(R.color.red);
            activeDeliveriesChip.setTextColor(getResources().getColor(R.color.white));
            completeDeliveriesChip.setChipBackgroundColorResource(R.color.grey);
            completeDeliveriesChip.setTextColor(getResources().getColor(R.color.black));
            loadActiveDeliveries();

        }else {

            activeDeliveriesChip.setChipBackgroundColorResource(R.color.grey);
            activeDeliveriesChip.setTextColor(getResources().getColor(R.color.black));
            completeDeliveriesChip.setChipBackgroundColorResource(R.color.red);
            completeDeliveriesChip.setTextColor(getResources().getColor(R.color.white));
            loadCompleteDeliveries();
        }
        foodAdapter.notifyDataSetChanged();
    }

    private void loadCompleteDeliveries() {

        listOfFoods.add(new Food(R.drawable.pizza, "Chicken Pizza","Kshs. 800", "4/5", true, "12.10 pm", "Bamboo Hotel"));
        listOfFoods.add(new Food(R.drawable.burger, "Chicken Pizza","Kshs. 800", "4/5", true, "yesterday", "Bamboo Hotel"));
        listOfFoods.add(new Food(R.drawable.spaghetti, "Chicken Pizza","Kshs. 800", "4/5", true, "March 2", "Bamboo Hotel"));
        listOfFoods.add(new Food(R.drawable.pork, "Chicken Pizza","Kshs. 800", "4/5", true, "3 yrs", "Bamboo Hotel"));
        listOfFoods.add(new Food(R.drawable.nuggets, "Chicken Pizza","Kshs. 800", "4/5", true, "5 yrs", "Bamboo Hotel"));

        listOfFoods.add(new Food(R.drawable.pizza, "Chicken Pizza","Kshs. 800", "4/5", true, "12.10 pm", "Bamboo Hotel"));
        listOfFoods.add(new Food(R.drawable.burger, "Chicken Pizza","Kshs. 800", "4/5", true, "yesterday", "Bamboo Hotel"));
        listOfFoods.add(new Food(R.drawable.spaghetti, "Chicken Pizza","Kshs. 800", "4/5", true, "March 2", "Bamboo Hotel"));
        listOfFoods.add(new Food(R.drawable.pork, "Chicken Pizza","Kshs. 800", "4/5", true, "3 yrs", "Bamboo Hotel"));
        listOfFoods.add(new Food(R.drawable.nuggets, "Chicken Pizza","Kshs. 800", "4/5", true, "5 yrs", "Bamboo Hotel"));
    }

    private void loadActiveDeliveries() {

        listOfFoods.add(new Food(R.drawable.pizza, "Chicken Pizza","Kshs. 800", "4/5", false, "20 mins", "Pizza inn"));
        listOfFoods.add(new Food(R.drawable.burger, "Chicken Pizza","Kshs. 800", "4/5", false, "20 mins", "Bamboo resort"));
        listOfFoods.add(new Food(R.drawable.spaghetti, "Chicken Pizza","Kshs. 800", "4/5", false, "20 mins", "Intercontinental Hotel"));
    }
}