package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtResult;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonClear, buttonEqual, buttonDot;

    float mValueOne, mValueTwo;
    boolean addition, subtraction, multiplication, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        edtResult = findViewById(R.id.edtResult);
        edtResult.setKeyListener(null); // Make EditText non-editable by keyboard

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        buttonClear = findViewById(R.id.buttonClear);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonDot = findViewById(R.id.buttonDot);

        // Number buttons - append number clicked to EditText
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                edtResult.append(b.getText());
            }
        };

        button0.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);

        // Dot button - add dot only if not already present
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = edtResult.getText().toString();
                if (!currentText.contains(".")) {
                    if (currentText.isEmpty()) {
                        edtResult.append("0.");
                    } else {
                        edtResult.append(".");
                    }
                }
            }
        });

        // Clear button
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtResult.setText("");
                resetOperations();
            }
        });

        // Operation buttons
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setFirstValue()) addition = true;
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setFirstValue()) subtraction = true;
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setFirstValue()) multiplication = true;
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setFirstValue()) division = true;
            }
        });

        // Equal button - perform calculation
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edtResult.getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    mValueTwo = Float.parseFloat(text);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    return;
                }

                float result = 0;
                if (addition) {
                    result = mValueOne + mValueTwo;
                } else if (subtraction) {
                    result = mValueOne - mValueTwo;
                } else if (multiplication) {
                    result = mValueOne * mValueTwo;
                } else if (division) {
                    if (mValueTwo == 0) {
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        edtResult.setText("");
                        resetOperations();
                        return;
                    } else {
                        result = mValueOne / mValueTwo;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Select an operation", Toast.LENGTH_SHORT).show();
                    return;
                }

                edtResult.setText(String.valueOf(result));
                resetOperations();
            }
        });
    }

    private boolean setFirstValue() {
        String text = edtResult.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a number first", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            mValueOne = Float.parseFloat(text);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
            return false;
        }
        edtResult.setText("");
        resetOperations();
        return true;
    }

    private void resetOperations() {
        addition = false;
        subtraction = false;
        multiplication = false;
        division = false;
    }
}
