package com.aavidsoft.mysecondapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtMessage;
    private EditText edtMessage;
    private Button btnMessage;
    private Button btnGoToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage = findViewById(R.id.txtMessage);
        edtMessage = findViewById(R.id.edtMessage);
        btnMessage = findViewById(R.id.btnMessage);
        btnGoToHome = findViewById(R.id.btnGoToHome);

        btnMessage.setOnClickListener(new BtnMessageOnClickListener());
        txtMessage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtMessage.setText("");
                    }
                }
        );

        btnGoToHome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(
                                MainActivity.this,
                                HomeActivity.class
                        );
                        startActivity(intent);
                    }
                }
        );
    }

    private class BtnMessageOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            txtMessage.setText( edtMessage.getText().toString() );
            edtMessage.setText("");
        }
    }


}