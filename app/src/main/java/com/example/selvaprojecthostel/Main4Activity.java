package com.example.selvaprojecthostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    EditText e1,e2,e3;
    String s1,s2,s3,s4,date,time;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    FirebaseAuth mAuth;
    Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        databaseReference= FirebaseDatabase.getInstance().getReference("licet");
        databaseReference2= FirebaseDatabase.getInstance().getReference("licet").child("date");
        mAuth=FirebaseAuth.getInstance();
        s=findViewById(R.id.spinner);
        List<String> l=new ArrayList<>();
        l.add("Morning");
        l.add("Afternoon");
        l.add("Fullday");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,l);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s4=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sss,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                mAuth.signOut();
                Intent i1 = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(i1);
                Toast.makeText(Main4Activity.this, mAuth.getUid(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.my:
                Intent i2 = new Intent(Main4Activity.this, Main8Activity.class);
                startActivity(i2);
                break;
            case R.id.abs:
                Intent i3 = new Intent(Main4Activity.this, Main12Activity.class);
                startActivity(i3);
                break;
            case R.id.home:
                Intent i4 = new Intent(Main4Activity.this, Main3Activity.class);
                startActivity(i4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void registerdata(View view) {
        Intent i1=new Intent(Main4Activity.this,Main4Activity.class);
        startActivity(i1);
    }

    public void retrievedata(View view) {
        Intent i2=new Intent(Main4Activity.this,Main5Activity.class);
        startActivity(i2);
    }

    public void registerstudent(View view) {
        Intent i3=new Intent(Main4Activity.this,Main6Activity.class);
        startActivity(i3);
    }

    public void enterstudententry(View view) {
        s1=e1.getText().toString();
        s2=e2.getText().toString();
        s3=e3.getText().toString();
        if(!s1.isEmpty()) {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat s = new SimpleDateFormat("dd:MM:yyyy");
            SimpleDateFormat d1 = new SimpleDateFormat("HH:mm:ss");
            time = d1.format(c.getTime());
            date = s.format(c.getTime());
            Toast.makeText(Main4Activity.this, "Student Marked", Toast.LENGTH_SHORT).show();
            databaseReference.child("student").child(s1).child("leave").child(date).child("reason").setValue(s3);
            databaseReference.child("student").child(s1).child("leave").child(date).child("time").setValue(s4);
            databaseReference.child("student").child(s1).child("leave").child(date).child("date").setValue(date);
            databaseReference2.child(date).child(time).child("account").setValue(s1);
            databaseReference2.child(date).child(time).child("name").setValue(s2);
            databaseReference2.child(date).child(time).child("reason").setValue(s3);
            databaseReference2.child(date).child(time).child("time").setValue(s4);
            Intent i = new Intent(Main4Activity.this, Main3Activity.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(Main4Activity.this, "Enter the account number", Toast.LENGTH_SHORT).show();
        }
    }
}
