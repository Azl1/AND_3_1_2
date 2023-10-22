package com.abdullaev.and_3_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorModel calculator;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numberIDs = new int[] {
                R.id.zero,
                R.id.one,
                R.id.two,
                R.id.three,
                R.id.four,
                R.id.five,
                R.id.six,
                R.id.seven,
                R.id.eight,
                R.id.nine
        };

        int[] actionIDs = new int[]{
                R.id.plus,
                R.id.minus,
                R.id.multiply,
                R.id.divsion,
                R.id.equals
        };
        text = findViewById(R.id.text);
        calculator = new CalculatorModel();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numberIDs.length; i++) {
            findViewById(numberIDs[i]).setOnClickListener(numberButtonClickListener);
        }

        for (int i = 0; i < actionIDs.length; i++) {
            findViewById(actionIDs[i]).setOnClickListener(actionButtonOnClickListener);
        }
    }
}