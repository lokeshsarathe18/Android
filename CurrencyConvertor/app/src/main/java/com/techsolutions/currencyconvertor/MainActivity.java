package com.techsolutions.currencyconvertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void convert(View view){
        EditText editnumber = (EditText)findViewById(R.id.currency);
        if (editnumber.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter currency in Rupee",Toast.LENGTH_SHORT).show();;
        }else{
            double dollor = Double.parseDouble(editnumber.getText().toString())/69.68;
            Toast.makeText(getApplicationContext(),String.format(editnumber.getText().toString() + "INR = %.2f Dollors",dollor),Toast.LENGTH_SHORT).show();;
        }
    }
}
