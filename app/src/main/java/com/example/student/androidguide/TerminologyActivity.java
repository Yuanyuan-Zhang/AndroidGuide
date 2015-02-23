package com.example.student.androidguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;


public class TerminologyActivity extends ActionBarActivity {

    String[] name;
    String[] value;

    AutoCompleteTextView actv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminology);

    value = getResources().getStringArray(R.array.value);
    name = getResources().getStringArray(R.array.name);

    actv = (AutoCompleteTextView) findViewById(R.id.auto_name);

    ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,name);

    actv.setThreshold(3);

    actv.setAdapter(adaptor);

    final TextView text = (TextView) findViewById(R.id.explain);

    actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {

                String selection = (String) parent.getItemAtPosition(position);

                for(int i=0;i<29;i++){
                    Log.i("Yuanyuan", "name[i] is " + name[i]);
                    if(selection.equals(name[i])){
                        text.setText(value[i]);
                        break;

                    }
                }
            }
        });
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
