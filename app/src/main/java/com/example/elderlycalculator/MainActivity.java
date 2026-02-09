package com.example.elderlycalculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button add, sub, mul, div, reset;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        reset = findViewById(R.id.reset);
        result = findViewById(R.id.result);

        add.setOnClickListener(v -> calculate("+"));
        sub.setOnClickListener(v -> calculate("-"));
        mul.setOnClickListener(v -> calculate("*"));
        div.setOnClickListener(v -> calculate("/"));

        // RESET BUTTON
        reset.setOnClickListener(v -> {
            num1.setText("");
            num2.setText("");
            result.setText("Result: ");
            Toast.makeText(this,"Calculator Reset",Toast.LENGTH_SHORT).show();
        });
    }

    private void calculate(String op) {

        String s1 = num1.getText().toString();
        String s2 = num2.getText().toString();

        if(s1.isEmpty() || s2.isEmpty()){
            Toast.makeText(this,"Enter both numbers",Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);
        double res = 0;

        Toast.makeText(this,"Pressed " + op,Toast.LENGTH_SHORT).show();

        switch (op){
            case "+": res = a+b; break;
            case "-": res = a-b; break;
            case "*": res = a*b; break;

            case "/":
                if(b==0){
                    Toast.makeText(this,"Cannot divide by zero",Toast.LENGTH_SHORT).show();
                    return;
                }
                res = a/b; break;
        }

        result.setText("Result: "+res);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setMessage("Answer = " + res);
        builder.setPositiveButton("OK", (dialog, which) -> {});
        builder.show();
    }
}
