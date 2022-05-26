package com.example.assignment.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.R;
import com.example.assignment.models.SavedMatches_Model;
import com.example.assignment.sqlite_db.Rating_DB;

import java.util.ArrayList;

public class Matches_Adapter extends RecyclerView.Adapter<Matches_Adapter.MyViewHolder> {
    public static String strSeparator = "__,__";
    Rating_DB DB;
    private ArrayList<SavedMatches_Model> SavedMatches_modelArrayList;

    public Matches_Adapter(ArrayList<SavedMatches_Model> SavedMatches_modelArrayList) {
        this.SavedMatches_modelArrayList = SavedMatches_modelArrayList;
    }

    @NonNull
    @Override
    public Matches_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.matches_unit, parent, false);

        return new MyViewHolder(itemView);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameValue;
        private TextView addressValue;
        private RatingBar starsValue;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameValue = itemView.findViewById(R.id.match_Name);
            addressValue = itemView.findViewById(R.id.match_Address);
            starsValue = itemView.findViewById(R.id.match_Stars);

            DB = new Rating_DB(itemView.getContext());

//            if(starsValue.getNumStars()==0){
//                itemView.setVisibility(View.GONE);
//            }

        }


    }

    @Override
    public void onBindViewHolder(@NonNull Matches_Adapter.MyViewHolder holder, int position) {
        SavedMatches_Model savedMatches_model = SavedMatches_modelArrayList.get(position);
        holder.nameValue.setText(savedMatches_model.getName());
        holder.addressValue.setText(savedMatches_model.getAddress());
        holder.starsValue.setRating(savedMatches_model.getStars());

        holder.starsValue.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            // Called when the user swipes the RatingBar
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String NameArray[] = new String[SavedMatches_modelArrayList.size()];
                String RatingArray[] = new String[SavedMatches_modelArrayList.size()];
                String AddressArray[] = new String[SavedMatches_modelArrayList.size()];
                for (int i = 0; i < SavedMatches_modelArrayList.size(); i++) {
                    if (SavedMatches_modelArrayList.get(i).getName() == null || String.valueOf(SavedMatches_modelArrayList.get(i).getStars()) == null || SavedMatches_modelArrayList.get(i).getAddress() == null) {
                        NameArray[i] = " ";
                        AddressArray[i] = " ";
                        RatingArray[i] = " ";
                    }
                    NameArray[i] = SavedMatches_modelArrayList.get(i).getName().toString();
                    RatingArray[i] = String.valueOf(SavedMatches_modelArrayList.get(i).getStars());
                    AddressArray[i] = SavedMatches_modelArrayList.get(i).getAddress().toString();
                }

                String NameString = convertArrayToString(NameArray);
                String RatingString = convertArrayToString(RatingArray);
                String AddressString = convertArrayToString(AddressArray);
                if (holder.nameValue.getText() != null && holder.addressValue.getText() != null && holder.starsValue != null && NameString != null) {
                    Log.e("Here", holder.getAdapterPosition() + " " + rating + " " + fromUser + " " + holder.nameValue.getText());
                    SavedMatches_Model currModel = new SavedMatches_Model(holder.nameValue.getText().toString(), holder.addressValue.getText().toString(), rating);
                    SavedMatches_modelArrayList.set(holder.getAdapterPosition(), currModel);
                    Boolean checkinsertdata = DB.saveData(NameString, RatingString, AddressString);
                    DB.close();
                    if (checkinsertdata == true)
                        Log.e("Here", "New Entry Inserted");
                    else
                        Log.e("Here", "New Entry Not Inserted");

                }
            }

        });
    }

    @Override
    public int getItemCount() {
        return SavedMatches_modelArrayList.size();
    }

    public static String convertArrayToString(String[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str = str + array[i];
            // Do not append comma at the end of last element
            if (i < array.length - 1) {
                str = str + strSeparator;
            }
        }
        return str;
    }

    public static String[] convertStringToArray(String str) {
        String[] arr = str.split(strSeparator);
        return arr;
    }
}
