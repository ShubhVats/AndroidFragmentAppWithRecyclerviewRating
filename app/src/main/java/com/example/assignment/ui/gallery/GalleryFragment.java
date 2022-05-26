package com.example.assignment.ui.gallery;

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
import com.example.assignment.databinding.FragmentGalleryBinding;
import com.example.assignment.models.SavedMatches_Model;
import com.example.assignment.sqlite_db.Rating_DB;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    Rating_DB DB;


    private ArrayList<SavedMatches_Model> retriveArrayList = new ArrayList<>();
    private RecyclerView recyclerView;

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);

        DB = new Rating_DB(getContext());

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.galleryRecyclerView;
        setAdapter();
        getPrevData();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setAdapter() {
        Matches_Adapter adapter = new Matches_Adapter(retriveArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void getPrevData() {
        SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        String NameString = pref.getString("NameList", null);
        Log.e("Here", NameString);
        Cursor res = DB.getdata(NameString);
        if (res.getCount() == 0) {
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