package com.example.selvaprojecthostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main10Activity extends AppCompatActivity {
    RecyclerView r;
    String acc;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        r=findViewById(R.id.recycler);
        r.setHasFixedSize(true);
        r.setLayoutManager(new LinearLayoutManager(this));
        r.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        acc=getIntent().getStringExtra("acc");
        databaseReference= FirebaseDatabase.getInstance().getReference("licet").child("student").child(acc).child("leave");
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
                Intent i1 = new Intent(Main10Activity.this, Main8Activity.class);
                startActivity(i1);
                break;

            case R.id.abs:
                Intent i2 = new Intent(Main10Activity.this, Main12Activity.class);
                startActivity(i2);
                break;

            case R.id.logout:
                mAuth.signOut();
                Intent i3 = new Intent(Main10Activity.this, MainActivity.class);
                startActivity(i3);
                break;
            case R.id.home:
                Intent i4 = new Intent(Main10Activity.this, Main3Activity.class);
                startActivity(i4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Data,recycle> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Data, recycle>(
                Data.class,
                R.layout.data,
                recycle.class,
                databaseReference
        ) {
            @Override
            protected void populateViewHolder(recycle recycle, Data data, int i) {
                recycle.setReason(data.getReason());
                recycle.setTime(data.getTime());
               recycle.setDate(data.getDate());
              }
        };
        r.setAdapter(firebaseRecyclerAdapter);

    }

    public static class recycle extends RecyclerView.ViewHolder{
        View mview;
        public recycle(View itemView) {
            super(itemView);
            mview=itemView;
        }

        public void setReason(String reason){
            TextView t1= mview.findViewById(R.id.textView2);
            t1.setText(reason);
        }

        public void setTime(String time){
            TextView t2= mview.findViewById(R.id.textView3);
            t2.setText(time);
        }

        public void setDate(String date) {
            TextView t3= mview.findViewById(R.id.textView1);
            t3.setText(date);
        }

    }
}
