package com.example.tracknba;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class ComparePlayers extends AppCompatActivity {

    EditText no1 , no2, no3, no4, no5, no6, p1, p2;
    Button add ,mul ,div , sub, equal, comp;
    TextView answer1;
    String anse1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compareplayers);



        // for text views
        no1 = findViewById(R.id.first_no);
        no2 = findViewById(R.id.second_no);
        no3 = findViewById(R.id.third_no);
        no4 = findViewById(R.id.fourth_no);
        no5 = findViewById(R.id.fifth_no);
        no6 = findViewById(R.id.sixth_no);
        p1 = findViewById(R.id.player_1);
        p2 = findViewById(R.id.player_2);

        // for button with operations
//        add = findViewById(R.id.add);
//        mul = findViewById(R.id.mul);
//        div = findViewById(R.id.div);
//        sub = findViewById(R.id.sub);
//        comp = findViewById(R.id.comp);

        // for equal to button
        equal = findViewById(R.id.equals);

        // for answer field
        answer1 = findViewById(R.id.answer1);

//        comp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String num1 = no1.getText().toString();
//                String num2 = no2.getText().toString();
//                String num3 = no3.getText().toString();
//                String num4 = no4.getText().toString();
//                String num5 = no5.getText().toString();
//                String num6 = no6.getText().toString();
//                String play1 = p1.getText().toString();
//                String play2 = p2.getText().toString();
//
//                if (num1.isEmpty() || num2.isEmpty() || num3.isEmpty() || num4.isEmpty() || num5.isEmpty() || num6.isEmpty()){
//                    Toast.makeText(getApplicationContext(),"Enter Your Numbers!",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    double a = Double.parseDouble(no1.getText().toString());
//                    double b = Double.parseDouble(no2.getText().toString());
//                    double c = Double.parseDouble(no3.getText().toString());
//                    double d = Double.parseDouble(no4.getText().toString());
//                    double e = Double.parseDouble(no5.getText().toString());
//                    double f = Double.parseDouble(no6.getText().toString());
//
//                    double val1 = ((a+c+e) / 3);
//                    double val2 = ((b+d+f) / 3);
//
//                    if (val1 > val2) {
//                        double dif = val1 - val2;
//                        NumberFormat nf = NumberFormat.getInstance();
//                        nf.setMaximumFractionDigits(2);
//                        anse1 = play1+" averaged "+nf.format(val1)+" ppg, and "+play2+" averaged "+nf.format(val2)+" ppg." +
//                                "\nThis means that "+play1+" averaged "+nf.format(dif)+" more points than "+play2+".";
//                    }
//                    else if (val1 < val2) {
//                        double dif = val2 - val1;
//                        NumberFormat nf = NumberFormat.getInstance();
//                        nf.setMaximumFractionDigits(2);
//                        anse1 = play2+" averaged "+nf.format(val2)+" ppg, and "+play1+" averaged "+nf.format(val1)+" ppg." +
//                                "\nThis means that "+play2+" averaged "+nf.format(dif)+" more points than "+play1+".";
//                    }
//                    else if (val1 == val2) {
//                        NumberFormat nf = NumberFormat.getInstance();
//                        nf.setMaximumFractionDigits(2);
//                        anse1 = "Both "+play1+" and "+play2+" averaged "+nf.format(val1)+" ppg.";
//                    }
//
//                }
//            }
//        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = no1.getText().toString();
                String num2 = no2.getText().toString();
                String num3 = no3.getText().toString();
                String num4 = no4.getText().toString();
                String num5 = no5.getText().toString();
                String num6 = no6.getText().toString();
                String play1 = p1.getText().toString();
                String play2 = p2.getText().toString();

                if (num1.isEmpty() || num2.isEmpty() || num3.isEmpty() || num4.isEmpty() || num5.isEmpty() || num6.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Your Numbers!",Toast.LENGTH_SHORT).show();
                }
                else {
                    double a = Double.parseDouble(no1.getText().toString());
                    double b = Double.parseDouble(no2.getText().toString());
                    double c = Double.parseDouble(no3.getText().toString());
                    double d = Double.parseDouble(no4.getText().toString());
                    double e = Double.parseDouble(no5.getText().toString());
                    double f = Double.parseDouble(no6.getText().toString());

                    double val1 = ((a+c+e) / 3);
                    double val2 = ((b+d+f) / 3);

                    if (val1 > val2) {
                        double dif = val1 - val2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(2);
                        anse1 = play1+" averaged "+nf.format(val1)+" ppg, and "+play2+" averaged "+nf.format(val2)+" ppg." +
                                "\nThis means that "+play1+" averaged "+nf.format(dif)+" more points than "+play2+".";
                    }
                    else if (val1 < val2) {
                        double dif = val2 - val1;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(2);
                        anse1 = play2+" averaged "+nf.format(val2)+" ppg, and "+play1+" averaged "+nf.format(val1)+" ppg." +
                                "\nThis means that "+play2+" averaged "+nf.format(dif)+" more points than "+play1+".";
                    }
                    else if (val1 == val2) {
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(2);
                        anse1 = "Both "+play1+" and "+play2+" averaged "+nf.format(val1)+" ppg.";
                    }

                }
                answer1.setText(anse1);
//            answer2.setText(anse2);
//            answer3.setText(anse3);
            }
        });
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String num1 = no1.getText().toString();
//                String num2 = no2.getText().toString();
//
//                if (num1.isEmpty() || num2.isEmpty()) {
//                    Toast.makeText(getApplicationContext(),"Enter Your Numbers!",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    double a = Double.parseDouble(no1.getText().toString());
//                    double b = Double.parseDouble(no2.getText().toString());
//                    ans = a + b;
//                }
//            }
//        });
//
//        sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String num1 = no1.getText().toString();
//                String num2 = no2.getText().toString();
//
//                if (num1.isEmpty() || num2.isEmpty()) {
//                    Toast.makeText(getApplicationContext(),"Enter Your Numbers!",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    double a = Double.parseDouble(no1.getText().toString());
//                    double b = Double.parseDouble(no2.getText().toString());
//                    ans = a - b;
//                }
//            }
//        });
//
//        mul.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String num1 = no1.getText().toString();
//                String num2 = no2.getText().toString();
//
//                if (num1.isEmpty() || num2.isEmpty()) {
//                    Toast.makeText(getApplicationContext(),"Enter Your Numbers!",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    double a = Double.parseDouble(no1.getText().toString());
//                    double b = Double.parseDouble(no2.getText().toString());
//                    ans = a * b;
//                }
//            }
//        });
//
//        div.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String num1 = no1.getText().toString();
//                String num2 = no2.getText().toString();
//
//                if (num1.isEmpty() || num2.isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "Enter Your Numbers!", Toast.LENGTH_SHORT).show();
//                } else {
//                    double a = Double.parseDouble(no1.getText().toString());
//                    double b = Double.parseDouble(no2.getText().toString());
//                    if (b != 0)
//                        ans = a / b;
//                    else
//                        Toast.makeText(getApplicationContext(), "Please enter numbers", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        equal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               answer1 = anse1;
//               answer2 = anse2;
//               answer3 = anse3;
//            }
//        });

    }
}
