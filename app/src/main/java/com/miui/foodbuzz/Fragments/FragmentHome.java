package com.miui.foodbuzz.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.miui.foodbuzz.Adapter.categoryItemAdapter;
import com.miui.foodbuzz.Adapter.itemDataFetchAdapter;
import com.miui.foodbuzz.Classes.recyclerViewItemDomain;
import com.miui.foodbuzz.R;
import com.miui.foodbuzz.dataFetch.apiController;
import com.miui.foodbuzz.dataFetch.responseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */

public class FragmentHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Variables
    RecyclerView rview_categories, rview_popular;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public FragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHome.
     */
    // TODO: Rename and change types and number of parameters

    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        rview_categories = view.findViewById(R.id.recyclerView_categories);
        rview_popular = view.findViewById(R.id.recyclerView_popular);

        rview_categories.setLayoutManager(new LinearLayoutManager(getContext()));
        rview_popular.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewCategory();
        recyclerViewPopular();


        return view;
    }


    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rview_categories.setLayoutManager(linearLayoutManager);

        ArrayList<recyclerViewItemDomain> category = new ArrayList<>();
        category.add(new recyclerViewItemDomain("Pizza", "ic_pizza"));
        category.add(new recyclerViewItemDomain("Burger", "ic_burger"));
        category.add(new recyclerViewItemDomain("Hotdog", "ic_hotdog"));
        category.add(new recyclerViewItemDomain("Pasta", "ic_pasta"));
        category.add(new recyclerViewItemDomain("Dessert", "ic_dessert"));
        category.add(new recyclerViewItemDomain("Donut", "ic_donut"));
        category.add(new recyclerViewItemDomain("Drink", "ic_drink"));

        adapter = new categoryItemAdapter(category);
        rview_categories.setAdapter(adapter);

    }


    private void recyclerViewPopular() {
        layoutManager = new GridLayoutManager(getContext(), 3);
        rview_popular.setLayoutManager(layoutManager);


        Call<List<responseModel>> call = apiController.getInstance().getApi().getData();

        call.enqueue(new Callback<List<responseModel>>() {
            @Override
            public void onResponse(Call<List<responseModel>> call, Response<List<responseModel>> response) {
                List<responseModel> data = response.body();
                itemDataFetchAdapter adapter = new itemDataFetchAdapter(data);


                try {
                    rview_popular.setAdapter(adapter);
                }catch (Exception e){
                    Toast.makeText(getContext(), ""+e, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<responseModel>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}