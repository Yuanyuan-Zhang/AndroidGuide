package com.example.student.androidguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickTerminology(View v){

        Intent myIntent = new Intent(this,TerminologyActivity.class);
        startActivity(myIntent);
    }

    public void clickWebsites(View v){

        Intent myIntent2 = new Intent(this,WebsitesActivity.class);
        startActivity(myIntent2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about ) {
            Intent myIntent = new Intent(this, AboutActivity.class);
            startActivity(myIntent);
            return true;
        }

        if (id == R.id.action_help) {
            Intent myIntent = new Intent(this, HelpActivity.class);
            startActivity(myIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
