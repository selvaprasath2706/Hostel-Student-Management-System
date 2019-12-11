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

public class Main8Activity extends AppCompatActivity {
    TextView t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        t=findViewById(R.id.textView);
        t1=findViewById(R.id.textView1);
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
       databaseReference= FirebaseDatabase.getInstance().getReference("licet");
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
                Intent i1 = new Intent(Main8Activity.this, Main8Activity.class);
                startActivity(i1);
                break;

            case R.id.abs:
                Intent i2 = new Intent(Main8Activity.this, Main12Activity.class);
                startActivity(i2);
                break;

            case R.id.logout:
                mAuth.signOut();
                Intent i3 = new Intent(Main8Activity.this, MainActivity.class);
                startActivity(i3);
                break;
            case R.id.home:
                Intent i4 = new Intent(Main8Activity.this, Main3Activity.class);
                startActivity(i4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void editname(View view) {
        s="name";
        Intent i=new Intent(Main8Activity.this,Main9Activity.class);
        i.putExtra("str",s);
        startActivity(i);
    }

    public void editnumber(View view) {
        s="mobile";
        Intent i=new Intent(Main8Activity.this,Main9Activity.class);
        i.putExtra("str",s);
        startActivity(i);
    }

    public void editgmail(View view) {
        s="email";
        Intent i=new Intent(Main8Activity.this,Main9Activity.class);
        i.putExtra("str",s);
        startActivity(i);
    }

    public void editfloor(View view) {
        s="floor";
        Intent i=new Intent(Main8Activity.this,Main9Activity.class);
        i.putExtra("str",s);
        startActivity(i);
    }

    public void editinstitution(View view) {
        s="institution";
        Intent i=new Intent(Main8Activity.this,Main9Activity.class);
        i.putExtra("str",s);
        startActivity(i);
    }

    public void editroomno(View view) {
        s="roomno";
        Intent i=new Intent(Main8Activity.this,Main9Activity.class);
        i.putExtra("str",s);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.child("staff").child(mAuth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s1=dataSnapshot.child("name").getValue().toString();
                t2.setText(s1);
                String s2=dataSnapshot.child("mobile").getValue().toString();
                t6.setText(s2);
                String s3=dataSnapshot.child("email").getValue().toString();
                t4.setText(s3);
                String s4=dataSnapshot.child("floor").getValue().toString();
                t8.setText(s4);
                String s5=dataSnapshot.child("institution").getValue().toString();
                t10.setText(s5);
                String s6=dataSnapshot.child("roomno").getValue().toString();
                t12.setText(s6);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
