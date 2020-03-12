package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        final Realm realm = Realm.getDefaultInstance();


        final String[][] wordsFromFile = new String[1][1];

        Button buttonAdd = findViewById(R.id.addButton);
        if(realm.isEmpty())
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wordsFromFile[0].length!=0)
                wordsFromFile[0] = readText((R.raw.slowa));

            realm.beginTransaction();
            for(int x=0;x<wordsFromFile[0].length;x++)
            {
                realm.copyToRealm(new RowDataModel(wordsFromFile[0][x]));
            }
            realm.commitTransaction();
            }
        });
        else {
            buttonAdd.setVisibility(View.GONE);
            RealmResults<RowDataModel> realmR= realm.where(RowDataModel.class).findAll();
            String[] tempTab = new String[realmR.size()];
            for(int x=0;x<realmR.size();x++)
                tempTab[x] = realmR.get(x).name;
            wordsFromFile[0]=tempTab;
        }
        Button buttonG = findViewById(R.id.button);
        buttonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("word",wordsFromFile[0][new Random().nextInt(wordsFromFile[0].length)]);
                startActivity(intent);
            }
        });
        Button buttonL = findViewById(R.id.button2);

        buttonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                intent.putExtra("words",wordsFromFile[0]);

                startActivity(intent);
            }
        });



    }


String[] readText(int in){
    InputStream is =  getResources().openRawResource(in);
    StringBuilder text = new StringBuilder();
    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;

        while((line = reader.readLine())!= null)
            text.append(line+"\n");
    }
    catch (IOException e){

}
    return text.toString().split("\n");
    }
}
