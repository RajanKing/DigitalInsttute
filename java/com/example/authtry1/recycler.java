package com.example.authtry1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



import android.os.Bundle;

public class recycler extends AppCompatActivity {
    public RecyclerView mRecyclerView2;
    FirebaseDatabase mFirebaseDatabase2;
    DatabaseReference mref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mRecyclerView2 = findViewById(R.id.video_recycler_view);
        mRecyclerView2.setHasFixedSize(true);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this));
        mFirebaseDatabase2 = FirebaseDatabase.getInstance();
        mref2 = mFirebaseDatabase2.getReference("video");
    }@Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Model2> options =
                new FirebaseRecyclerOptions.Builder<Model2>()
                        .setQuery(mref2,Model2.class)
                        .build();

        FirebaseRecyclerAdapter<Model2,Viewholder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model2, Viewholder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull Viewholder holder, int position, @NonNull Model2 model) {

                        holder.setDetails2(getApplication(),model.getName(),model.getUrl());
                    }

                    @NonNull
                    @Override
                    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.activity_row,parent,false);


                        return new Viewholder(view);
                    }
                };

        firebaseRecyclerAdapter.startListening();
        mRecyclerView2.setAdapter(firebaseRecyclerAdapter);





    }



}
