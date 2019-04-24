package com.techsolutions.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomnumber;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomnumber = new Random().nextInt(50)+1;
    }

    public void makeToast(String string){
        Toast.makeText(getApplicationContext(),string,Toast.LENGTH_SHORT).show();
    }

    public void check(View view){
        EditText editnumber = (EditText) findViewById(R.id.number);
        if (editnumber.getText().toString().isEmpty()){
            makeToast("don't try to be oversmart");
        }else{
            int number = Integer.parseInt(editnumber.getText().toString());
            if(number>randomnumber){
                count++;
                makeToast("Try lower number");
            }else if(number<randomnumber){
                count++;
                makeToast("Try higher number");
            }else{
                makeToast("Congrats, you found the correct number in "+ ++count + " try");
                count = 0;
                randomnumber = new Random().nextInt(50)+1;
                makeToast("Play Again...");
            }
        }
    }
}
