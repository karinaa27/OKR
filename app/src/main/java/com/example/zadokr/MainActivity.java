package com.example.zadokr;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toCount(View view) {
        EditText editTextA = findViewById(R.id.a);
        EditText editTextB = findViewById(R.id.b);
        EditText editTextAlpha = findViewById(R.id.alpha);

        String aStr = editTextA.getText().toString();
        String bStr = editTextB.getText().toString();
        String alphaStr = editTextAlpha.getText().toString();

        if (aStr.isEmpty() || bStr.isEmpty() || alphaStr.isEmpty()) {
            Toast.makeText(this, "Поля не должны быть пустыми", Toast.LENGTH_LONG).show();
            return;
        }

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);
        int alpha = Integer.parseInt(alphaStr);

        if (a <= 0 || b <= 0 || alpha <= 0 || alpha >= 180) {
            Toast.makeText(this, "Неверный формат данных", Toast.LENGTH_LONG).show();
            return;
        }

        double result = a * b * Math.sin(Math.toRadians(alpha));
        ((TextView) findViewById(R.id.answer)).setText(String.valueOf(result));
    }
}