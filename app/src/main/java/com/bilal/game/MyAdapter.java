package com.bilal.game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bilal.game.HistorStringModel;
import com.bilal.game.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    ArrayList<HistorStringModel>historStringModels;

    public MyAdapter(ArrayList<HistorStringModel> historStringModels) {
        this.historStringModels=historStringModels;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

       viewHolder.count_holder.setText("Total correct answers = "+this.historStringModels.get(position).getCount());
       viewHolder.correct_answer.setText("Correct answers: "+this.historStringModels.get(position).getRigths());
       viewHolder.your_answers.setText("Your answers: "+this.historStringModels.get(position).getYours());



    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView correct_answer,your_answers,count_holder;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
           correct_answer=itemLayoutView.findViewById(R.id.correct_answers);
           your_answers=itemLayoutView.findViewById(R.id.your_answers);
           count_holder=itemLayoutView.findViewById(R.id.count_holder);
        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.historStringModels.size();
    }
}