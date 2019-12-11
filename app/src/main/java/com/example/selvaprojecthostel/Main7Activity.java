package com.example.selvaprojecthostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main7Activity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    DatabaseReference databaseReference;
    String acc,s1,s2,s3,s4,s5,s6;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);
        t6=findViewById(R.id.textView6);
        t7=findViewById(R.id.textView7);
        t8=findViewById(R.id.textView8);
        t9=findViewById(R.id.textView9);
        t10=findViewById(R.id.textView10);
        t11=findViewById(R.id.textView11);
        t12=findViewById(R.id.textView12);
        t13=findViewById(R.id.textView13);
        databaseReference= FirebaseDatabase.getInstance().getReference("licet");
        acc=getIntent().getStringExtra("acc");
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
                Intent i1 = new Intent(Main7Activity.this, Main8Activity.class);
                startActivity(i1);
                break;

            case R.id.abs:
                Intent i2 = new Intent(Main7Activity.this, Main12Activity.class);
                startActivity(i2);
                break;

            case R.id.logout:
                mAuth.signOut();
                Intent i3 = new Intent(Main7Activity.this, MainActivity.class);
                startActivity(i3);
                break;
            case R.id.home:
                Intent i4 = new Intent(Main7Activity.this, Main3Activity.class);
                startActivity(i4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.child("student").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           s1=dataSnapshot.child(acc).child("name").getValue().toString();
           s2=dataSnapshot.child(acc).child("accountnumber").getValue().toString();
           s3=dataSnapshot.child(acc).child("department").getValue().toString();
           s4=dataSnapshot.child(acc).child("floor").getValue().toString();
           s5=dataSnapshot.child(acc).child("roomno").getValue().toString();
           s6=dataSnapshot.child(acc).child("mobile").getValue().toString();
           t2.setText(s1);
           t4.setText(s2);
           t6.setText(s3);
           t8.setText(s4);
           t10.setText(s5);
           t12.setText(s6);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void registerdata(View view) {
        Intent i1=new Intent(Main7Activity.this,Main4Activity.class);
        startActivity(i1);
    }

    public void retrievedata(View view) {
        Intent i2=new Intent(Main7Activity.this,Main5Activity.class);
        startActivity(i2);
    }

    public void registerstudent(View view) {
        Intent i3=new Intent(Main7Activity.this,Main6Activity.class);
        startActivity(i3);
    }

    public void checkstudent(View view) {
        Intent i3=new Intent(Main7Activity.this,Main10Activity.class);
        i3.putExtra("acc",s2);
        startActivity(i3);

    }
}
