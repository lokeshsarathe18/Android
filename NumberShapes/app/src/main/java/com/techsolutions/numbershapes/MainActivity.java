package com.techsolutions.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class MyNumber {
        int number;

        public boolean isTriangular() {
            int x = 1;
            int triangularno = 1;
            while (triangularno < number) {
                x++;
                triangularno = triangularno + x;
            }
            if (triangularno == number) {
                return true;
            }else{
                return false;
        }
    }

        public boolean isSquare(){
            double s= Math.sqrt(number);
            if(s==Math.floor(s)){
                return true;
            }else{

                return false;
            }
        }
    }

    void makeToast(String string){
        Toast.makeText(getApplicationContext(),string,Toast.LENGTH_SHORT).show();
    }

    public void check(View view){
        EditText editnumber = (EditText)findViewById(R.id.number);
        if (!editnumber.getText().toString().isEmpty()){
            MyNumber mynumber = new MyNumber();
            mynumber.number = Integer.parseInt(editnumber.getText().toString());
            System.out.println(mynumber.isSquare());
            if (mynumber.isSquare() && mynumber.isTriangular()){
                makeToast(mynumber.number + " is both a square and a triangular number");
            }else if(mynumber.isSquare()){
                makeToast(mynumber.number + " is a square number but not a triangular number");
            }else if(mynumber.isTriangular()){
                makeToast(mynumber.number + " is a triangular number but not a square number");
            }else {
                makeToast(mynumber.number + " is neither a square nor a triangular number");
            }
        }else{
            makeToast("Don't try to be oversmart");
        }

    }
}
