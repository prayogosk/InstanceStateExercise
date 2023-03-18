package com.example.prayogo.instancestateexercise;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String COUNT_KEY = "count";
    private static final String TEXT_KEY = "text";

    private int count = 0;
    private String text = "";

    private TextView countTextView;
    private EditText editText;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextView = findViewById(R.id.countTextView);
        editText = findViewById(R.id.countEditText);

        Button incrementButton = findViewById(R.id.incrementButton);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                countTextView.setText(String.valueOf(count));
            }
        });

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(COUNT_KEY);
            text = savedInstanceState.getString(TEXT_KEY);
            countTextView.setText(String.valueOf(count));
            editText.setText(text);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_KEY, count);
        outState.putString(TEXT_KEY, editText.getText().toString());
    }
}