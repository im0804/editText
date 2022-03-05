package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvr,tvm,tvl,tvlr2,tvmr2,tvrr2;
    EditText etr,etm,etl;
    ImageView ivr,ivm,ivl;
    Button btnr,btnm,btnl;
    Random rnd = new Random();
    int rand,rand1,sum,etleft,etmiddle,etright,counter;
    double avg;
    boolean click1 = false;
    boolean click2 = false;
    boolean click3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvr = findViewById(R.id.tvr);
        tvm = findViewById(R.id.tvm);
        tvl = findViewById(R.id.tvl);
        tvmr2 = findViewById(R.id.tvmr2);
        tvlr2 = findViewById(R.id.tvlr2);
        tvrr2 = findViewById(R.id.tvrr2);
        etl = findViewById(R.id.etl);
        etr = findViewById(R.id.etr);
        etm = findViewById(R.id.etm);
        ivr = findViewById(R.id.ivr);
        ivm = findViewById(R.id.ivm);
        ivl = findViewById(R.id.ivl);
        btnr = findViewById(R.id.btnr);
        btnm = findViewById(R.id.btnm);
        btnl = findViewById(R.id.btnl);

        rand = rnd.nextInt(89) + 10;
        tvl.setText("" + rand);
        rand1 = rnd.nextInt(89) + 10;
        tvlr2.setText(Integer.toString(rand1));
    }

    public void click1(View view) {
        if (click1==false && click2==false && click3==false) {
            click1 = true;
            String st = etl.getText().toString();
            etleft = Integer.parseInt(st);
            if (etleft == (rand + rand1)) {
                ivl.setImageResource(R.drawable.vimage);
                counter++;
            }
            else {
                ivl.setImageResource(R.drawable.ximage);
            }
            sum = rand + rand1;
            tvm.setText(String.valueOf(sum));
            click2 = true;
            click1 = false;
            btnl.setText("clicked");
            btnm.setText("check");
            rand = rnd.nextInt(89)+10;
            tvmr2.setText(Integer.toString(rand));
        }
    }

    public void click2(View view) {
            if (click1==false && click2==true && click3 == false){
                String st = etm.getText().toString();
                etmiddle = Integer.parseInt(st);
                if (etmiddle == (sum+rand)) {
                    ivm.setImageResource(R.drawable.vimage);
                    counter++;
                }
                else {
                    ivm.setImageResource(R.drawable.ximage);
                }
                sum = rand + sum;
                tvr.setText(String.valueOf(sum));
                btnm.setText("clicked");
                click2 = false;
                click3 = true;
                rand = rnd.nextInt(89)+10;
                tvrr2.setText(String.valueOf(rand));
            }
        }

    public void click3(View view) {
        if (click1==false && click2==false && click3 == true){
            String st = etr.getText().toString();
            etright = Integer.parseInt(st);
            if (etright == (sum+rand)) {
                ivr.setImageResource(R.drawable.vimage);
                counter++;
            }
            else {
                ivr.setImageResource(R.drawable.ximage);
            }
        }
        avg = counter*(1/3.0)*100;
        Toast.makeText(this, counter+"/3"+" "+ avg+"%", Toast.LENGTH_LONG).show();
    }

    public void reset(View view) {
        click1 = false;
        click2 = false;
        click3 = false;
        btnl.setText("check");
        btnm.setText("click");
        btnr.setText("click");
        rand = rnd.nextInt(89) + 10;
        tvl.setText("" + rand);
        rand1 = rnd.nextInt(89) + 10;
        tvlr2.setText(Integer.toString(rand1));
        tvm.setText("TextView");
        tvmr2.setText("TextView");
        tvr.setText("TextView");
        tvrr2.setText("TextView");
        ivl.setImageResource(0);
        ivm.setImageResource(0);
        ivr.setImageResource(0);
    }
}