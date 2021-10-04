package com.penguinstech.fooddeliveryapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        setUpCarousel(view);
        setUpChipMenu(view);
        setUpRestaurants(view);
        return view;
    }


    private void setUpCarousel (View view) {
        RecyclerView recyclerView = view.findViewById(R.id.carouselView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<Carousel> list = new ArrayList<>();
        list.add(new Carousel(R.drawable.burger, "Burger", "30% Discount"));
        list.add(new Carousel(R.drawable.pizza, "Pizza", "New"));
        list.add(new Carousel(R.drawable.spaghetti, "Spaghetti", "Popular"));
        list.add(new Carousel(R.drawable.pork, "Pork", "Favorite"));

        CarouselAdapter adapter = new CarouselAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
    }

    private void setUpChipMenu (View view) {
        RecyclerView recyclerView = view.findViewById(R.id.chipsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<ChipInfo> list = new ArrayList<>();
        list.add(new ChipInfo(R.drawable.ic_baseline_restaurant_24, "Kenyan Dishes"));
        list.add(new ChipInfo(R.drawable.ic_baseline_restaurant_menu_24, "Ugandan Dishes"));
        list.add(new ChipInfo(R.drawable.ic_baseline_emoji_food_beverage_24, "Nigerian Dishes"));
        list.add(new ChipInfo(R.drawable.ic_baseline_food_bank_24, "Nigerian Dishes"));
        list.add(new ChipInfo(R.drawable.ic_baseline_fastfood_24, "Italian Dishes"));
        list.add(new ChipInfo(R.drawable.ic_baseline_restaurant_menu_24, "Mexican Dishes"));

        ChipAdapter adapter = new ChipAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
    }


    private void setUpRestaurants (View view) {
        RecyclerView recyclerView = view.findViewById(R.id.restaurantsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        ArrayList<Restaurant> list = new ArrayList<>();
        list.add(new Restaurant(R.drawable.burger, "Burger King",
                "08.00 A.M - 09.00 P.M", "4/5", "333, Kimathi street - Nairobi"));
        list.add(new Restaurant(R.drawable.pizza, "Pizza King",
                "08.00 A.M - 09.00 P.M", "4/5", "333, Kimathi street - Nairobi"));
        list.add(new Restaurant(R.drawable.nuggets, "KFC",
                "08.00 A.M - 09.00 P.M", "4/5", "333, Kimathi street - Nairobi"));
        list.add(new Restaurant(R.drawable.pork, "Pork Choma",
                "08.00 A.M - 09.00 P.M", "4/5", "333, Kimathi street - Nairobi"));

        RestaurantAdapter adapter = new RestaurantAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
    }
}