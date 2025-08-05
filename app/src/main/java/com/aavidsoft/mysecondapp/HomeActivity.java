package com.aavidsoft.mysecondapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private TextView txtWelcome;
    private EditText edtResult;
    private Button btnSendResults;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        txtWelcome = findViewById(R.id.txtWelcome);
        edtResult = findViewById(R.id.edtResult);
        btnSendResults = findViewById(R.id.btnSendResults);

        Intent intent = getIntent();
        Bundle inputBundle = intent.getExtras();

        String name = inputBundle.getString("name", "Guest");
        int code = inputBundle.getInt("code", 0);

        txtWelcome.setText("Welcome " + name + " (" + code + ")");

        btnSendResults.setOnClickListener(new BtnSendResultClickListener());
    }

    private class BtnSendResultClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intentResults = new Intent();
            intentResults.putExtra("result", edtResult.getText().toString());

            setResult(1, intentResults);
            finish();
        }
    }


}
