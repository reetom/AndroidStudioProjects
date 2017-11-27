package com.example.reetomhazarika.tictoc;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    public static final String LETTER_X = "x";
    public static final String LETTER_Y = "y";
    public Button resetButton;
    public int count = 0;

    //Identify each toggle button by a variable
    public Button toggleButton00, toggleButton01,toggleButton02, toggleButton10,toggleButton11,
        toggleButton12, toggleButton20, toggleButton21, toggleButton22;
    // A 3X3 array to hold the values of toggle buttons.
    int [][] buttonValue = new int[][]{
        {0,0,0},
        {0,0,0},
        {0,0,0}
    };
    //only those buttons are stored here the ones that are tapped. Others are null;
    Button [][] buttonArr = new Button[3][3];

    String buttonText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        // The following methods need to be listening as soon as the page is loaded.
        init();
        tap1();
        tap2();
        tap3();
        tap4();
        tap5();
        tap6();
        tap7();
        tap8();
        tap9();
        resetGame();
    }
    //retrieve values from intent from the previous activity.
    public String symbols = null;
    public String player1Symbol = null;
    public String player2Symbol = null;
    public String mode = null;
    public void init(){
        //retrieve values from intent from the previous activity.
        symbols = (String) getIntent().getExtras().get("playerSymbols");
        player1Symbol = String.valueOf(symbols.charAt(0));
        player2Symbol = String.valueOf(symbols.charAt(2));
        mode = (String) getIntent().getExtras().get("mode");

    }
    /*//retrieve values from intent from the previous activity.
    public String symbols = (String) getIntent().getExtras().get("playerSymbols");
    public String player1Symbol = String.valueOf(symbols.charAt(0));
    public String player2Symbol = String.valueOf(symbols.charAt(2));
    public String mode = (String) getIntent().getExtras().get("mode");
*/
    public void tap1(){
        toggleButton00 = (Button) findViewById(R.id.toggleButton00);
        toggleButton00.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View view) {
                buttonText =  returnButtonVal();
                toggleButton00.setText(buttonText);
                //disable the button so that the button can't be clicked again.
                toggleButton00.setEnabled(false);
                 //save the returned value in the right location in the array
                storeButtonValue(buttonText,0,0);
                 //reset buttonText value after the value has been stored in the array
                 buttonText = null;
                buttonArr[0][0] = toggleButton00;
                checkForWinner();
            }
        });
    }
    public void tap2(){
        toggleButton01 = (Button) findViewById(R.id.toggleButton01);
        toggleButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonText =  returnButtonVal();
                toggleButton01.setText(buttonText);
                //disable the button so that the button can't be clicked again.
                toggleButton01.setEnabled(false);
                //save the returned value in the right location in the array
                storeButtonValue(buttonText,0,1);
                //reset buttonText value after the value has been stored in the array
                buttonText = null;
                buttonArr[0][1] = toggleButton01;
                checkForWinner();

            }
        });
    }
    public void tap3(){
        toggleButton02 = (Button) findViewById(R.id.toggleButton02);
        toggleButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonText =  returnButtonVal();
                toggleButton02.setText(buttonText);
                //disable the button so that the button can't be clicked again.
                toggleButton02.setEnabled(false);
                //save the returned value in the right location in the array
                storeButtonValue(buttonText,0,2);
                //reset buttonText value after the value has been stored in the array
                buttonText = null;
                buttonArr[0][2] = toggleButton02;
                checkForWinner();
            }
        });
    }
    public void tap4(){
        toggleButton10 = (Button) findViewById(R.id.toggleButton10);
        toggleButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonText =  returnButtonVal();
                toggleButton10.setText(buttonText);
                //disable the button so that the button can't be clicked again.
                toggleButton10.setEnabled(false);
                //save the returned value in the right location in the array
                storeButtonValue(buttonText,1,0);
                buttonArr[1][0] = toggleButton10;
                checkForWinner();
            }
        });
    }
    public void tap5(){
        toggleButton11 = (Button) findViewById(R.id.toggleButton11);
        toggleButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonText =  returnButtonVal();
                toggleButton11.setText(buttonText);
                //disable the button so that the button can't be clicked again.
                toggleButton11.setEnabled(false);
                //save the returned value in the right location in the array
                storeButtonValue(buttonText,1,1);
                //reset buttonText value after the value has been stored in the array
                buttonText = null;
                buttonArr[1][1] = toggleButton11;
                checkForWinner();
            }
        });
    }
    public void tap6(){
        toggleButton12 = (Button) findViewById(R.id.toggleButton12);
        toggleButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonText =  returnButtonVal();
                toggleButton12.setText(buttonText);
                //disable the button so that the button can't be clicked again.
                toggleButton12.setEnabled(false);
                //save the returned value in the right location in the array
                storeButtonValue(buttonText,1,2);
                //reset buttonText value after the value has been stored in the array
                buttonText = null;
                buttonArr[1][2] = toggleButton12;
                checkForWinner();
            }
        });
    }
    public void tap7(){
        toggleButton20 = (Button) findViewById(R.id.toggleButton20);
        toggleButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonText =  returnButtonVal();
                toggleButton20.setText(buttonText);
                //disable the button so that the button can't be clicked again.
                toggleButton20.setEnabled(false);
                //save the returned value in the right location in the array
                storeButtonValue(buttonText,2,0);
                //reset buttonText value after the value has been stored in the array
                buttonText = null;
                buttonArr[2][0] = toggleButton20;
                checkForWinner();
            }
        });
    }
    public void tap8(){
        toggleButton21 = (Button) findViewById(R.id.toggleButton21);
        toggleButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonText =  returnButtonVal();
                toggleButton21.setText(buttonText);
                //disable the button so that the button can't be clicked again.
                toggleButton21.setEnabled(false);
                //save the returned value in the right location in the array
                storeButtonValue(buttonText,2,1);
                //reset buttonText value after the value has been stored in the array
                buttonText = null;
                buttonArr[2][1] = toggleButton21;
                checkForWinner();
            }
        });
    }
    public void tap9(){
        toggleButton22 = (Button) findViewById(R.id.toggleButton22);
        toggleButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonText =  returnButtonVal();
                toggleButton22.setText(buttonText);
                //disable the button so that the button can't be clicked again.
                toggleButton22.setEnabled(false);
                //save the returned value in the right location in the array
                storeButtonValue(buttonText,2,2);
                //reset buttonText value after the value has been stored in the array
                buttonText = null;
                buttonArr[2][2] = toggleButton22;
                checkForWinner();
            }
        });
    }

    //Reset the game
    public void resetGame (){
        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirect to the main game page
                Intent reloadPage = new Intent(Main2Activity.this, Main2Activity.class);
                //reset the array values to 0
                buttonValue = new int[][]{
                        {0,0,0},
                        {0,0,0},
                        {0,0,0}
                };
                //reset the button names to TAP and enable the buttons.
                //Reset the count
                count=0;
                finish();
                startActivity(getIntent());
            }
        });
    }

    // A random number generator to randomly pick one of two given numbers. This method will return
    //either 0 or 1.
    public long onTapGenerateRand () {
        return Math.round(Math.random());
    }

    // Get display value
    public String getButtonVal(long randValue){
        if (randValue == 1 )
            return "O";
        else return "X";
    }
    //call this method for every tap on every button.
    public String returnButtonVal (){
        count++;
        String value = null;
        if (mode.equalsIgnoreCase("Retro")) {
            if (count%2 == 0){
                value = player2Symbol;
            }
            if (count%2 != 0){
                value = player1Symbol;
            }
        } else {
            value = this.getButtonVal(this.onTapGenerateRand());
        }
        return value;
    }

    // Highlight the row and column or the diagonals with winning colors
    public void displayWinner (Button but1, Button but2, Button but3) {

        //disable all the buttons
        toggleButton00.setEnabled(false);
        toggleButton01.setEnabled(false);
        toggleButton02.setEnabled(false);

        toggleButton10.setEnabled(false);
        toggleButton11.setEnabled(false);
        toggleButton12.setEnabled(false);

        toggleButton20.setEnabled(false);
        toggleButton21.setEnabled(false);
        toggleButton22.setEnabled(false);

        //Show the temp message
        toggleWinningButtons(but1,but2,but3);
        Toast myToast = Toast.makeText(getApplicationContext(),"Game Over, " + getWinnerName() +
                " wins!", Toast.LENGTH_LONG);
           myToast.show();
    }

    public void storeButtonValue (String xO, int x, int y) {
        //store the button values into the array to identify the winner
        if (xO.equalsIgnoreCase(LETTER_X)) {
            buttonValue[x][y] = 1;
        } else {
            buttonValue[x][y] = 2;
        }
    }
    public void checkForWinner(){
        //traverse through the array vertically and find the winner horizontally
        for (int i =0, j=0; i<3&&j<3; i++){
            if ( buttonValue[i][j] != 0 && buttonValue[i][j] == buttonValue[i][j+1]) {
                if (buttonValue[i][j+1] == buttonValue[i][j+2]) {
                    //Found a winner
                    displayWinner(buttonArr[i][j], buttonArr[i][j+1], buttonArr[i][j+2]);
                    break;
                }
            }
        }

        //traverse through the array horizonally and find the winner vertically
        for (int j =0, i=0; j<3&&i<3; j++){
            if ( buttonValue[i][j] != 0 && buttonValue[i][j] == buttonValue[i+1][j]) {
                if (buttonValue[i+1][j] == buttonValue[i+2][j]) {
                    //Found a winner
                   displayWinner(buttonArr[i][j], buttonArr[i+1][j], buttonArr[i+2][j]);
                    break;
                }
            }
        }
        //Identify the diagonal winners
        if (buttonValue[0][0] !=0 && buttonValue[1][1] !=0 && buttonValue[2][2] != 0&&
                (buttonValue[0][0] == buttonValue[1][1]) && (buttonValue[1][1] == buttonValue[2][2])) {
            //Found a winner
            displayWinner(buttonArr[0][0], buttonArr[1][1], buttonArr[2][2]);
        }
        if (buttonValue[0][2] !=0 && buttonValue[1][1] !=0 && buttonValue[2][0] != 0&&
                (buttonValue[0][2] == buttonValue[1][1]) && (buttonValue[1][1] == buttonValue[2][0])) {
            //Found a winner
            displayWinner(buttonArr[0][2], buttonArr[1][1], buttonArr[2][0]);
        }
    }

    public void toggleWinningButtons(Button but1, Button but2, Button but3){
        if (but1 != null && but2 != null && but3 !=null){
            but1.setBackgroundColor(Color.RED);
            but2.setBackgroundColor(Color.RED);
            but3.setBackgroundColor(Color.RED);
            //Play winning music
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
            mp.start();
        }
    }

    public String getWinnerName(){
        String winner = null;
        if (count % 2 == 0){
            winner = "Player 2";
        } else{
            winner = "Player 1";
        }
        count = 0;
        return winner;
    }
}
