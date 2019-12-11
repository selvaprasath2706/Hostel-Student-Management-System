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

import org.w3c.dom.Text;

public class Main12Activity extends AppCompatActivity {
    TextView t;
    EditText e;
    String s;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
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
                Intent i1 = new Intent(Main12Activity.this, Main8Activity.class);
                startActivity(i1);
                break;

            case R.id.abs:
                Intent i2 = new Intent(Main12Activity.this, Main12Activity.class);
                startActivity(i2);
                break;

            case R.id.logout:
                mAuth.signOut();
                Intent i3 = new Intent(Main12Activity.this, MainActivity.class);
                startActivity(i3);
                break;
            case R.id.home:
                Intent i4 = new Intent(Main12Activity.this, Main3Activity.class);
                startActivity(i4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void datefind(View view) {
        s=e.getText().toString();
        if(!s.isEmpty()) {
            Intent i = new Intent(Main12Activity.this, Main11Activity.class);
            i.putExtra("date", s);
            startActivity(i);
        }
        else
        {
            Toast.makeText(Main12Activity.this, "Enter a date", Toast.LENGTH_SHORT).show();
        }
    }
}
