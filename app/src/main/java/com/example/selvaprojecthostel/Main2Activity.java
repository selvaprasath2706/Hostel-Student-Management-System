package com.example.selvaprojecthostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static androidx.core.os.LocaleListCompat.create;

public class Main2Activity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    EditText e1,e2,e3,e4,e5,e6,e7;
    String s1,s2,s3,s4,s5,s6,s7;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);
        t6=findViewById(R.id.textView6);
        t7=findViewById(R.id.textView7);
        t8=findViewById(R.id.textView8);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        e4=findViewById(R.id.editText4);
        e5=findViewById(R.id.editText5);
        e6=findViewById(R.id.editText6);
        e7=findViewById(R.id.editText7);
        databaseReference= FirebaseDatabase.getInstance().getReference("licet");
        mAuth=FirebaseAuth.getInstance();
    }

    public void signup(View view) {
        s1=e1.getText().toString();
        s2=e2.getText().toString();
        s3=e3.getText().toString();
        s4=e4.getText().toString();
        s5=e5.getText().toString();
        s6=e6.getText().toString();
        s7=e7.getText().toString();
        if(s2.equals(s3))
        {
            if(!s4.isEmpty())
            {
                    if(!s5.isEmpty())
                    {
                        if(!s6.isEmpty())
                        {
                            if(!s7.isEmpty())
                            {
                                makesignin(s1,s2);

                            }
                            else
                            {
                                Toast.makeText(Main2Activity.this, "Enter your Room no", Toast.LENGTH_SHORT).show();

                            }

                        }
                        else
                        {
                            Toast.makeText(Main2Activity.this, "Enter your mobile number", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(Main2Activity.this, "Enter the floor ", Toast.LENGTH_SHORT).show();
                    }
            }
            else
            {
                Toast.makeText(Main2Activity.this, "Enter your name", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(Main2Activity.this, "Enter both the password fields same password"+s2+s3, Toast.LENGTH_SHORT).show();
        }

    }

    private void makesignin(String s1, String s2) {
        mAuth.createUserWithEmailAndPassword(s1, s2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                           createdata();
                            Toast.makeText(Main2Activity.this, "sign up success ", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Main2Activity.this, "sign up failed try again witha diffetent mail id", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

    }

    private void createdata() {
        databaseReference.child("staff").child(mAuth.getUid()).child("name").setValue(s4);
        databaseReference.child("staff").child(mAuth.getUid()).child("email").setValue(s1);
        databaseReference.child("staff").child(mAuth.getUid()).child("floor").setValue(s5);
        databaseReference.child("staff").child(mAuth.getUid()).child("mobile").setValue(s6);
        databaseReference.child("staff").child(mAuth.getUid()).child("institution").setValue("licet");
        databaseReference.child("staff").child(mAuth.getUid()).child("roomno").setValue(s7);
        Intent i=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(i);
    }

    public void switchsignup(View view) {
        Intent i3 = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(i3);
    }
}
