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

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    EditText e1,e2;
    String s1,s2;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText3);
        mAuth=FirebaseAuth.getInstance();
    }

    public void userlogin(View view) {
        s1=e1.getText().toString();
        s2=e2.getText().toString();
       chksignin(s1,s2);
    }

    private void chksignin(String s1, String s2) {
        mAuth.signInWithEmailAndPassword(this.s1, this.s2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Sucess", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(MainActivity.this,Main3Activity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(MainActivity.this, "Sorry you dont have the permission", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }

    public void createsignup(View view) {
        Intent i=new Intent(MainActivity.this,Main2Activity.class );
        startActivity(i);
    }
}
