   package com.techsolutions.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

   public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fadeimage1(View view){
        ImageView image1 = (ImageView)findViewById(R.id.image1);
        ImageView image2 = (ImageView)findViewById(R.id.image2);
        image1.animate().alpha(0.0f).setDuration(3000);
        image2.animate().alpha(1.0f).setDuration(3000);
        Toast.makeText(getApplicationContext(),"I am fading 1......",Toast.LENGTH_SHORT).show();
    }

       /*public void fadeimage2(View view){
           ImageView image1 = (ImageView)findViewById(R.id.image1);
           ImageView image2 = (ImageView)findViewById(R.id.image2);
           image1.animate().alpha(1.0f).setDuration(3000);
           image2.animate().alpha(0.0f).setDuration(3000);
           Toast.makeText(getApplicationContext(),"I am fading 2......",Toast.LENGTH_SHORT).show();
       }*/
}
