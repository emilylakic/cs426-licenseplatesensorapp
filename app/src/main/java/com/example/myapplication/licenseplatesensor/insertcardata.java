package com.example.myapplication.licenseplatesensor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insertcardata extends AppCompatActivity {

    EditText txtName, txtAge, txtPhone, txtHeight;
    Button btnSave;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertcardata);
        Toast.makeText(insertcardata.this, "Firebase Connection Success", Toast.LENGTH_LONG).show();
        txtName = (EditText)findViewById(R.id.txtName);
        txtAge = (EditText)findViewById(R.id.txtAge);
        txtPhone = (EditText)findViewById(R.id.txtPhone);
        txtHeight = (EditText)findViewById(R.id.txtHeight);
        btnSave = (Button)findViewById(R.id.btnSave);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                int ageA = Integer.parseInt(txtAge.getText().toString().trim());
                Float hit = Float.parseFloat(txtHeight.getText().toString().trim());
                Long phn = Long.parseLong(txtPhone.getText().toString().trim());

                member.setName(txtName.getText().toString().trim());
                member.setAge(ageA);
                member.setHt(hit);
                member.setPh(phn);
                reff.push().setValue(member);
                Toast.makeText(insertcardata.this, "data inserted successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}