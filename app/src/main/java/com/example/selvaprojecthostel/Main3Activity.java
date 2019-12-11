package com.example.selvaprojecthostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main3Activity extends AppCompatActivity {
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("licet");
        t=findViewById(R.id.textView);

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
                Intent i1 = new Intent(Main3Activity.this, Main8Activity.class);
                startActivity(i1);
            break;

            case R.id.abs:
                Intent i2 = new Intent(Main3Activity.this, Main12Activity.class);
                startActivity(i2);
            break;

            case R.id.logout:
                mAuth.signOut();
                Intent i3 = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(i3);
                break;
            case R.id.home:
                Intent i4 = new Intent(Main3Activity.this, Main3Activity.class);
                startActivity(i4);
                break;
        }
            return super.onOptionsItemSelected(item);
        }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()==null){
            Intent i=new Intent(Main3Activity.this,MainActivity.class);
            startActivity(i);
        }
        else
        {
            databaseReference.child("staff").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String instution="Welcome to "+(dataSnapshot.child(mAuth.getUid()).child("institution").getValue().toString());
                    t.setText(instution);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }

    public void registerdata(View view) {
        Intent i1=new Intent(Main3Activity.this,Main4Activity.class);
        startActivity(i1);
    }

    public void retrievedata(View view) {
        Intent i2=new Intent(Main3Activity.this,Main5Activity.class);
        startActivity(i2);
    }

    public void registerstudent(View view) {
        Intent i3=new Intent(Main3Activity.this,Main6Activity.class);
        startActivity(i3);
    }

}
