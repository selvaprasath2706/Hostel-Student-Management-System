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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main5Activity extends AppCompatActivity {
    TextView t;
    EditText e;
    String s;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        t=findViewById(R.id.textView);
        e=findViewById(R.id.editText);
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
                Intent i1 = new Intent(Main5Activity.this, Main8Activity.class);
                startActivity(i1);
                break;

            case R.id.abs:
                Intent i2 = new Intent(Main5Activity.this, Main12Activity.class);
                startActivity(i2);
                break;

            case R.id.logout:
                mAuth.signOut();
                Intent i3 = new Intent(Main5Activity.this, MainActivity.class);
                startActivity(i3);
                break;
            case R.id.home:
                Intent i4 = new Intent(Main5Activity.this, Main3Activity.class);
                startActivity(i4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void registerdata(View view) {
        Intent i1=new Intent(Main5Activity.this,Main4Activity.class);
        startActivity(i1);
    }

    public void retrievedata(View view) {
        Intent i2=new Intent(Main5Activity.this,Main5Activity.class);
        startActivity(i2);
    }

    public void registerstudent(View view) {
        Intent i3=new Intent(Main5Activity.this,Main6Activity.class);
        startActivity(i3);
    }

    public void findstudent(View view) {
        s=e.getText().toString();
        Intent i=new Intent(Main5Activity.this,Main7Activity.class);
        i.putExtra("acc",s);
        startActivity(i);
    }
}
