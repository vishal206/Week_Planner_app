package com.example.week_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class setPasswordActivity extends AppCompatActivity {

    private Button btn_save;
    private EditText edt_pwd,edt_rePwd;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);

        btn_save=findViewById(R.id.btn_save);
        edt_pwd=findViewById(R.id.edt_pwd);
        edt_rePwd=findViewById(R.id.edt_rePwd);

        mAuth=FirebaseAuth.getInstance();

        FirebaseUser user=mAuth.getCurrentUser();
        String uid= user.getUid();
        DocumentReference ref= FirebaseFirestore.getInstance().collection("Users").document(uid);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_pwd.getText().toString().equals(edt_rePwd.getText().toString()))
                {
                    ref.update("password",edt_pwd.getText().toString());
                    Intent i=new Intent(setPasswordActivity.this,Home.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(setPasswordActivity.this, "passwords not matching", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}