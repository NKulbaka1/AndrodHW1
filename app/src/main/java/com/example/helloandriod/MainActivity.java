package com.example.helloandriod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int SHOW_OTHER_ACTIVITY = 1;
    private Button greetingButton;
    private TextView greetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingButton = findViewById(R.id.greetingButton);

        greetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String greeting = "Привет";
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("greeting", greeting);
                startActivityForResult(intent, SHOW_OTHER_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SHOW_OTHER_ACTIVITY && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            greetingTextView = findViewById(R.id.greetingTextView);
            greetingTextView.setText("Привет, " + name + "!");
        }
    }
}