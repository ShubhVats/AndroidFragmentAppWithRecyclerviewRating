package com.example.assignment.ui.home;

import static com.example.assignment.adapters.Matches_Adapter.convertArrayToString;
import static com.example.assignment.adapters.Matches_Adapter.convertStringToArray;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.adapters.Matches_Adapter;
import com.example.assignment.databinding.FragmentHomeBinding;
import com.example.assignment.models.Matches_Model;
import com.example.assignment.models.SavedMatches_Model;
import com.example.assignment.rest_api.APIs;
import com.example.assignment.rest_api.RetrofitClient;
import com.example.assignment.sqlite_db.Rating_DB;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    Rating_DB DB;

    private FragmentHomeBinding binding;

    private ArrayList<SavedMatches_Model> retriveArrayList = new ArrayList<>();
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        DB = new Rating_DB(getContext());


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.SavedMatchesRecyclerView;


        getPrevData();
        retriveData();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void retriveData() {
        Call<JsonObject> bando_api = RetrofitClient.getRetrofitInstance().create(APIs.class).getMatches("search?ll=40.7484,-73.9857&oauth_token=NPKYZ3WZ1VYMNAZ2FLX1WLECAWSMUVOQZOIDBN53F3LVZBPQ&v=20180616");
        bando_api.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                try {
                    if (response.body() == null) {
                    } else {

                        JsonObject jsonElements = response.body();
                        Matches_Model singledata = new Gson().fromJson(jsonElements, Matches_Model.class);
                        for (int i = 0; i < singledata.getResponse().getVenues().length; i++) {
                            SavedMatches_Model savedMatches_model;
                            if (singledata.getResponse().getVenues(i).getLocation().getAddress() == null) {
                                savedMatches_model = new SavedMatches_Model(singledata.getResponse().getVenues(i).getName(), " ", 0);

                            } else {

                                savedMatches_model = new SavedMatches_Model(singledata.getResponse().getVenues(i).getName(), singledata.getResponse().getVenues(i).getLocation().getAddress(), 0);
                            }


                            retriveArrayList.add(savedMatches_model);
                        }
                        String[] NameArray = new String[retriveArrayList.size()];
                        for (int i = 0; i < retriveArrayList.size(); i++) {
                            NameArray[i] = retriveArrayList.get(i).getName();
                        }
                        String NameString = convertArrayToString(NameArray);
                        SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("NameList", NameString);
                        editor.apply();
                        getPrevData();
                        setAdapter();
                    }

                } catch (Exception e) {
                    Log.e("Here", e.toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                Log.e("Here", "Error: " + t);
            }
        });
        return;
    }

    private void setAdapter() {
        Matches_Adapter adapter = new Matches_Adapter(retriveArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void getPrevData() {
        String NameArray[] = new String[retriveArrayList.size()];
        for (int i = 0; i < retriveArrayList.size(); i++) {
            NameArray[i] = retriveArrayList.get(i).getName().toString();
        }
        String NameString = convertArrayToString(NameArray);


        Cursor res = DB.getdata(NameString);
        if (res.getCount() == 0) {
            DB.getprevdata();
            Toast.makeText(getContext(), "New", Toast.LENGTH_SHORT).show();
            return;
        }
        while (res.moveToNext()) {
            String nameString = res.getString(0);
            String ratingString = res.getString(1);
            String addressString = res.getString(2);
            String[] nameArray, ratingArray, addressArray;
            nameArray = convertStringToArray(nameString);
            ratingArray = convertStringToArray(ratingString);
            addressArray = convertStringToArray(addressString);
            retriveArrayList.clear();

            for (int i = 0; i < nameArray.length; i++) {
                SavedMatches_Model newRetriveList = new SavedMatches_Model(nameArray[i], addressArray[i], Float.parseFloat(ratingArray[i]));
                retriveArrayList.add(newRetriveList);
                setAdapter();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        //Get Local Data
        getPrevData();
    }

    @Override
    public void onPause() {
        super.onPause();
        DB.close();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        DB.close();
    }
}