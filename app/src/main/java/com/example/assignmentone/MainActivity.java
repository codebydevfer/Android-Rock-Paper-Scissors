package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button playBtn;
    EditText username;
    String username_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = findViewById(R.id.wml_btn);
        username = findViewById(R.id.username_input);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to second page
                Intent scndPage = new Intent(MainActivity.this, SecondActivity.class);
                username_selected = username.getText().toString();
                scndPage.putExtra("KEY_ONE", username_selected);

                startActivity(scndPage);
            }
        });
    }
}