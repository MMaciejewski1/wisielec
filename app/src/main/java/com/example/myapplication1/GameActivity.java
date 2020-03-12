package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    String word;
    Button a;
    Button b;
    Button c;
    Button d;
    Button e;
    Button f;
    Button g;
    Button h;
    Button i;
    Button j;
    Button k;
    Button l;
    Button m;
    Button n;
    Button o;
    Button p;
    Button r;
    Button s;
    Button t;
    Button u;
    Button w;
    Button x;
    Button y;
    Button z;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button a = findViewById(R.id.a);
        Intent intent = getIntent();
        a.setOnClickListener(this);
        TextView text = findViewById(R.id.textViewWisielec);
        word = intent.getStringExtra("word").toLowerCase().replace("ą","a").replace("ę","e").replace("ć","c").replace("ł","l").replace("ń","n").replace("ó","o").replace("ś","s").replace("ż","z").replace("ź","z");
        text.setText(hideWord(word.length()));
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        g = findViewById(R.id.g);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
        j = findViewById(R.id.j);
        k = findViewById(R.id.k);
        l = findViewById(R.id.l);
        m = findViewById(R.id.m);
        n = findViewById(R.id.n);
        o = findViewById(R.id.o);
        p = findViewById(R.id.p);
        r = findViewById(R.id.r);
        s = findViewById(R.id.s);
        t = findViewById(R.id.t);
        u = findViewById(R.id.u);
        w = findViewById(R.id.w);
        x = findViewById(R.id.x);
        y = findViewById(R.id.y);
        z = findViewById(R.id.z);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        r.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        w.setOnClickListener(this);
        x.setOnClickListener(this);
        y.setOnClickListener(this);
        z.setOnClickListener(this);
    }
    int xx=0;
    int lenght;
    @Override
    public void onClick(View v) {
        TextView t = findViewById(R.id.textViewWisielec);
        Button temp = (Button) v;
        int l= search(((String) temp.getText()).toLowerCase(),word);
        int test = 0;
        String hideWord= (String) t.getText();
        String tempWord = word;
while (l!=-1){
    hideWord = hideWord.substring(0,l)+temp.getText()+hideWord.substring(l+1);
    tempWord =  tempWord.substring(0,l)+" "+tempWord.substring(l+1);
    l= search(((String) temp.getText()).toLowerCase(),tempWord);
    test++;
}
          t.setText(hideWord);
          TextView h = findViewById(R.id.hangMan);
          int[] tab = {R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10, R.drawable.h11, R.drawable.h12};
          if(test==0){
            h.setBackground(getResources().getDrawable(tab[xx++]));
      }
       lenght+=test;
        if(xx==tab.length||lenght>=word.length()-1)   the_end();
        temp.setVisibility(View.GONE);
    }


    public int search(String letter,String word){
            return word.indexOf(letter);

    }
    public void the_end(){
    this.finish();
    }

    String hideWord(int countLetter){
        StringBuilder t = new StringBuilder();
        for(int x=0;x<countLetter;x++)
        t.append("_");
        return t.toString();
    }
}
