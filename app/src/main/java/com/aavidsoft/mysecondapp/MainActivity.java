package com.aavidsoft.mysecondapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView txtMessage;
    private EditText edtMessage;
    private Button btnMessage;
    private Button btnGoToHome;
    private ImageView imgFlag;
    private TextView txtCount;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        Log.e("mytag", "my message");

        setContentView(R.layout.activity_main);

        initViews();
        initListeners();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    private void initListeners() {
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
                        intent.putExtra("name", edtMessage.getText().toString());
                        intent.putExtra("code", 8906);

                        //startActivity(intent);
                        startActivityForResult(intent, 1);
                    }
                }
        );

        CountEventListener countEventListener = new CountEventListener();
        imgFlag.setOnClickListener(countEventListener);
        txtCount.setOnClickListener(countEventListener);
    }

    private void initViews() {
        txtMessage = findViewById(R.id.txtMessage);
        edtMessage = findViewById(R.id.edtMessage);
        btnMessage = findViewById(R.id.btnMessage);
        btnGoToHome = findViewById(R.id.btnGoToHome);
        imgFlag = findViewById(R.id.imgFlag);
        txtCount = findViewById(R.id.txtCount);
    }

    private class BtnMessageOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            txtMessage.setText( edtMessage.getText().toString() );
            edtMessage.setText("");
        }
    }

    private class CountEventListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(view == imgFlag) {
                txtCount.setText(++count + "");
            }
            if(view.getId() == R.id.txtCount) {
                txtCount.setText(--count + "");
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*Bundle bundle = data.getExtras();
        String result = bundle.getString("result");*/

        if(data != null) {
            String result = data.getExtras().getString("result");
            txtMessage.setText(result);
        }

    }
}