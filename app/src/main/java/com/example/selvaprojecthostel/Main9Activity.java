package com.example.selvaprojecthostel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main9Activity extends AppCompatActivity {
    String s;
    TextView t1,t2;
    EditText e;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        s=getIntent().getStringExtra("str");
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView1);
        e=findViewById(R.id.editText);
        mAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("licet");
        String s1="Enter the new "+s;
        t2.setText(s1);


    }
    private void editname(String s, String s1) {
        databaseReference.child("staff").child(mAuth.getUid()).child(s).setValue(s1);
        Toast.makeText(Main9Activity.this, "Sucessfully changed", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Main9Activity.this,Main8Activity.class);
        startActivity(i);
    }

    private void editmobile(String s, String s1) {
        databaseReference.child("staff").child(mAuth.getUid()).child(s).setValue(s1);
        Toast.makeText(Main9Activity.this, "Sucessfully changed", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Main9Activity.this,Main8Activity.class);
        startActivity(i);
    }
    private void editmail(String s, String s1) {
        databaseReference.child("staff").child(mAuth.getUid()).child(s).setValue(s1);
        Toast.makeText(Main9Activity.this, "Sucessfully changed", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Main9Activity.this,Main8Activity.class);
        startActivity(i);
    }

    private void editfloor(String s, String s1) {
        databaseReference.child("staff").child(mAuth.getUid()).child(s).setValue(s1);
        Toast.makeText(Main9Activity.this, "Sucessfully changed", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Main9Activity.this,Main8Activity.class);
        startActivity(i);
    }

    private void editinst(String s, String s1) {
        databaseReference.child("staff").child(mAuth.getUid()).child(s).setValue(s1);
        Toast.makeText(Main9Activity.this, "Sucessfully changed", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Main9Activity.this,Main8Activity.class);
        startActivity(i);
    }

    private void editroom(String s, String s1) {
        databaseReference.child("staff").child(mAuth.getUid()).child(s).setValue(s1);
        Toast.makeText(Main9Activity.this, "Sucessfully changed", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Main9Activity.this,Main8Activity.class);
        startActivity(i);
    }

    public void changedata(View view) {
        String data;
        data=e.getText().toString();
        if(s.equals("name")){
            Toast.makeText(Main9Activity.this, "hello", Toast.LENGTH_SHORT).show();
            editname(s,data);
        }
        if(s.equals("email"))
        {
            editmail(s,data);
        }
        if(s.equals("mobile"))
        {
            editmobile(s,data);
        }
        if(s.equals("institution"))
        {
            editinst(s,data);
        }
        if(s.equals("floor"))
        {
            editfloor(s,data);
        }
        if(s.equals("roomno"))
        {
            editroom(s,data);
        }
    }
}
