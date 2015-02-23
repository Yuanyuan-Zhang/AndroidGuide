package com.example.student.androidguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class WebsitesActivity extends ActionBarActivity {

    String[] webName;
    String[] webLink;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

        webName = getResources().getStringArray(R.array.web);
        webLink = getResources().getStringArray(R.array.link);


        ListView lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter aa = new ArrayAdapter(this, R.layout.activity_listview, webName);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                //Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

                String selection = (String) parent.getItemAtPosition(position);

                for(int i=0;i<12;i++){
                    //Log.i("Yuanyuan", "name[i] is " + webName[i]);
                    if(selection.equals(webName[i])){
                        url= webLink[i];
                        break;

                    }
                }

                //Log.i("STUDENT","url is "+url);

                setContentView(R.layout.activity_webview);
                WebView myWebView = (WebView) findViewById(R.id.webView);

             if(myWebView != null)
                myWebView.loadUrl(url);
                else Log.i("STUDENT", "myWebView is NULL");
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
