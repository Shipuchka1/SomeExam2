package com.example.someexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CurrencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        ImageView myAwesomeTextView = (ImageView) findViewById(R.id.imageView);

        Glide
                .with(this) // replace with 'this' if it's in activity
                .load("https://nationalbank.kz/rss/nb.gif?switch=kazakh")
                .asGif()
                .into(myAwesomeTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.wheather:
                Intent myIntent = new Intent(this, WheatherActivity.class);
                startActivity(myIntent);
                return true;
            case R.id.currency:
                Intent myIntent2 = new Intent(this, CurrencyActivity.class);
                startActivity(myIntent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
