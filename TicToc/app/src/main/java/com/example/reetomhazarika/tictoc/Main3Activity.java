package com.example.reetomhazarika.tictoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    public Button player1;
    public Button player2;
    public Button submit;
    public String player1Symbol;
    public String player2Symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        init();
    }

    public void init (){
        //Initialize the buttons.
        player1 = (Button) findViewById(R.id.player1);
        player2 = (Button) findViewById(R.id.player2);
        //Store the values in case the players accept the default values and hit submit.
        player1Symbol = (String) player1.getText();
        player2Symbol = (String) player2.getText();

        //When player 1 button is hit
        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        if (player1.getText().equals("O")) {
            player1.setText("X");
            player2.setText("O");
        } else if (player1.getText().equals("X")){
            player1.setText("O");
            player2.setText("X");
        }
            }
        });
        //When player 2 button is hit
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player2.getText().equals("O")) {
                    player2.setText("X");
                    player1.setText("O");
                } else if (player2.getText().equals("X")){
                    player2.setText("O");
                    player1.setText("X");
                }
            }
        });
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
            player1Symbol = (String) player1.getText();
            player2Symbol = (String) player2.getText();
            String playerSymbols = player1Symbol.toString()+ "~" + player2Symbol.toString();
            //Show the temp message
            Toast myToast = Toast.makeText(getApplicationContext(),"Have Fun!", Toast.LENGTH_LONG);
            myToast.show();
            //redirect to the main game page
            Intent gameWindow = new Intent(Main3Activity.this, Main2Activity.class);

            //Send Player 1 and Player 2 symbols to next activity
            Bundle bundle = new Bundle();
            bundle.putString("playerSymbols", playerSymbols.toString());
            bundle.putString("mode", new String("Retro"));
            gameWindow.putExtras(bundle);
            startActivity(gameWindow);
            }
        });
    }
}
