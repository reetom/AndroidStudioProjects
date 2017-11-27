package com.example.reetomhazarika.tictoc;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button buts;
    public Button retro_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        init();
    }

   public void init (){
        buts = (Button) findViewById(R.id.buts);
        buts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Show the temp message
                Toast myToast = Toast.makeText(getApplicationContext(),"Have Fun!", Toast.LENGTH_LONG);
                myToast.show();
                //redirect to the main game page
                Intent gameWindow = new Intent(MainActivity.this, Main2Activity.class);
                //Send Player 1 and Player 2 symbols to next activity
                Bundle bundle = new Bundle();
                bundle.putString("mode", new String("Random"));
                //The following values will be ignored in the random mode
                bundle.putString("playerSymbols", new String("~~~"));
                gameWindow.putExtras(bundle);
                startActivity(gameWindow);
            }
        });

                retro_button = (Button) findViewById(R.id.retro_button);
                retro_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               //redirect to the main game page
               Intent gameWindow1 = new Intent(MainActivity.this, Main3Activity.class);
               startActivity(gameWindow1);
           }
       });
    }
}
