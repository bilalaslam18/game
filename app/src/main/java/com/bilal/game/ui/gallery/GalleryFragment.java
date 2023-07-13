package com.bilal.game.ui.gallery;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bilal.game.DBHelper;
import com.bilal.game.HistorStringModel;
import com.bilal.game.MyAdapter;
import com.bilal.game.R;
import com.bilal.game.databinding.FragmentGalleryBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    DBHelper dbHelper;
    //HistorStringModel historStringModel;
    TextView right_answers;
    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
        // 1. get a reference to recyclerView
        rv = (RecyclerView) rootView.findViewById(R.id.recycleView);

        // 2. set layoutManger
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));


        dbHelper=new DBHelper(rootView.getContext());
        ArrayList<HistorStringModel> historStringModels=dbHelper.GetHistory();

        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(historStringModels);
        // 4. set adapter
        rv.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        rv.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view,@NonNull Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);

       /*
        RecyclerView recyclerView=view.findViewById(R.id.recycleView);

        Log.i(TAG, historStringModels.get(0).getYours());

        MyAdapter myAdapter=new MyAdapter(view.getContext(),historStringModels);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        */

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}