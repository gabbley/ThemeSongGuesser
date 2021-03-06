package com.example.baniquedg.themesongguesser;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    public ArrayList<Song> playlist;
    private TextView welcomeName, coinAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initialSetup();
    }

    public void initialSetup(){
        playlist = new ArrayList<>();
        welcomeName = (TextView) findViewById(R.id.lblWelcomeName);
        coinAmt = (TextView) findViewById(R.id.lblCoinAmt);
        Variables getUser = (Variables) this.getApplication();
        welcomeName.setText(getUser.getUsername().toString());
    }


    public void goToClass(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    public void login(View view){
        goToClass(LoginScreen.class);
    }

    public void play(View view){
        goToClass(GuessSong.class);
    }

    public void rules(View view){
        Uri uri = Uri.parse("http://sites.google.com/view/themesongguesser/home");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public Song getRandomSong(){

        return new Song();
    }

    public ArrayList<Song> fillPlaylist(ArrayList<Song> arr, int n){

        for (int i = 0; i<n; i++){
            arr.add(getRandomSong());
        }

        return arr;
    }


}
