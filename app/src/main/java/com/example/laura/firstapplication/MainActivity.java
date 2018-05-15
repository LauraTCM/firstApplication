package com.example.laura.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText firstInput;
    private EditText secondInput;
    private Button  actionButton;
    private final int REQUEST_CODE = 890;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstInput = findViewById(R.id.first_input);
        secondInput = findViewById(R.id.second_input);
        actionButton = findViewById(R.id.send_button);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstValue = firstInput.getText().toString();
                String secondValue = secondInput.getText().toString();
                Intent intent = new Intent(v.getContext(), SecondaryActivity.class);
                intent.putExtra("firstText", firstValue);
                intent.putExtra("secondText", secondValue);
                startActivityForResult(intent, REQUEST_CODE);
//                Log.d("Test","the current value is :" + firstValue + "-" + secondValue);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK) {
                Log.d("Test", resultCode + " OK!");
            }
            else{
                Log.d("Test", resultCode + " Cancel!");
            }

        }
    }
}
