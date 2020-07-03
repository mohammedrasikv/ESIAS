package com.example.esias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextInputEditText username;
        CardView submit;
        TextView publicenter=(TextView)findViewById(R.id.publiclogin);
        publicenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PublicActivity.class));
            }
        });
        username=(TextInputEditText)findViewById(R.id.usernamelogin);
        submit=(CardView)findViewById(R.id.submitlogin);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("teacher")) {
                    startActivity(new Intent(MainActivity.this, TeacherActivity.class));
                }
                else if(username.getText().toString().equals("student"))
                {
                    startActivity(new Intent(MainActivity.this,StudentActivity.class));
                }
                else
                {
                    username.setError("Invalid username");
                }

            }
        });
    }
}
