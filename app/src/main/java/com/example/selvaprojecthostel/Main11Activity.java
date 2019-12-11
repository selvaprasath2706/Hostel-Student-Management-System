package com.example.selvaprojecthostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main11Activity extends AppCompatActivity {
    RecyclerView r;
    DatabaseReference databaseReference2;
    String date;
    FirebaseAuth mAuth;
    TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        date=getIntent().getStringExtra("date");
        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        setContentView(R.layout.activity_main11);
        r = findViewById(R.id.recycler);
        r.setHasFixedSize(true);
        r.setLayoutManager(new LinearLayoutManager(this));
        r.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        databaseReference2 = FirebaseDatabase.getInstance().getReference("licet").child("date").child(date);
        Toast.makeText(Main11Activity.this, "reached", Toast.LENGTH_SHORT).show();
        mAuth=FirebaseAuth.getInstance();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sss,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.my:
                Intent i1 = new Intent(Main11Activity.this, Main8Activity.class);
                startActivity(i1);
                break;

            case R.id.abs:
                Intent i2 = new Intent(Main11Activity.this, Main12Activity.class);
                startActivity(i2);
                break;

            case R.id.logout:
                mAuth.signOut();
                Intent i3 = new Intent(Main11Activity.this, MainActivity.class);
                startActivity(i3);
                break;
            case R.id.home:
                Intent i4 = new Intent(Main11Activity.this, Main3Activity.class);
                startActivity(i4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Date, Getdat> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Date,Getdat>(
                Date.class,
                R.layout.datedetails,
                Getdat.class,
                databaseReference2
        )
        {
            @Override
            protected void populateViewHolder(Getdat getdat, Date date, int i) {

                getdat.setReason(date.getReason());
                getdat.setTime(date.getTime());
                getdat.setName(date.getName());
                getdat.setAcc(date.getAcc());
            }

        };
        r.setAdapter(firebaseRecyclerAdapter);

    }



    public static class Getdat extends RecyclerView.ViewHolder {
        View mview;

        public Getdat(@NonNull View itemView) {
            super(itemView);
            mview =itemView;
        }

        public  void setName(String name) {
            TextView t1 = mview.findViewById(R.id.textView2);
            t1.setText(name);
        }

        public void setReason(String reason) {
            TextView t1 = mview.findViewById(R.id.textView3);
            t1.setText(reason);
        }


        public  void setTime(String time) {
            TextView t1 = mview.findViewById(R.id.textView4);
            t1.setText(time);
        }
        public  void setAcc(String account) {
            TextView t1 = mview.findViewById(R.id.textView1);
            t1.setText(account);
        }


    }
}