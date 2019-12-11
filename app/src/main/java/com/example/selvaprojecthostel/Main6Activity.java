package com.example.selvaprojecthostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main6Activity extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5, t6;
    EditText e1, e2, e3, e4, e5, e6;
    String s1, s2, s3, s4, s5, s6, s7;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        t6 = findViewById(R.id.textView6);
        e1 = findViewById(R.id.editText1);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        e4 = findViewById(R.id.editText4);
        e5 = findViewById(R.id.editText5);
        e6 = findViewById(R.id.editText6);
        databaseReference = FirebaseDatabase.getInstance().getReference("licet");
        mAuth=FirebaseAuth.getInstance();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sss, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.my:
                Intent i1 = new Intent(Main6Activity.this, Main8Activity.class);
                startActivity(i1);
                break;

            case R.id.abs:
                Intent i2 = new Intent(Main6Activity.this, Main12Activity.class);
                startActivity(i2);
                break;

            case R.id.logout:
                mAuth.signOut();
                Intent i3 = new Intent(Main6Activity.this, MainActivity.class);
                startActivity(i3);
                break;
            case R.id.home:
                Intent i4 = new Intent(Main6Activity.this, Main3Activity.class);
                startActivity(i4);
                break;
        }
        return super.onOptionsItemSelected(item);

    }


    public void registerdata(View view) {
        Intent i1 = new Intent(Main6Activity.this, Main4Activity.class);
        startActivity(i1);
    }

    public void retrievedata(View view) {
        Intent i2 = new Intent(Main6Activity.this, Main5Activity.class);
        startActivity(i2);
    }

    public void registerstudent(View view) {
        Intent i3 = new Intent(Main6Activity.this, Main6Activity.class);
        startActivity(i3);
    }

    public void createdata(View view) {
        s1 = e1.getText().toString();
        s2 = e2.getText().toString();
        s3 = e3.getText().toString();
        s4 = e4.getText().toString();
        s5 = e5.getText().toString();
        s6 = e6.getText().toString();
        if (!s2.isEmpty()) {
            databaseReference.child("student").child(s2).child("name").setValue(s1);
            databaseReference.child("student").child(s2).child("accountnumber").setValue(s2);
            databaseReference.child("student").child(s2).child("department").setValue(s3);
            databaseReference.child("student").child(s2).child("floor").setValue(s4);
            databaseReference.child("student").child(s2).child("roomno").setValue(s5);
            databaseReference.child("student").child(s2).child("mobile").setValue(s6);
            Toast.makeText(Main6Activity.this, "Student record created", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Main6Activity.this, Main3Activity.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(Main6Activity.this, "Enter teh account number", Toast.LENGTH_SHORT).show();
        }
    }
}