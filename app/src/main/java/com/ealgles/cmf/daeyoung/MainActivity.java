package com.ealgles.cmf.daeyoung;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mainlist1);
        LinearLayoutManager LLM = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LLM);
        final Adapter1 adapter1 = new Adapter1();
        recyclerView.setAdapter(adapter1);
        adapter1.AddItem("오늘의 급식", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter1.AddItem("시간표", getResources().getDrawable(R.mipmap.ic_launcher));
        recyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(getApplicationContext(), recyclerView, new RecyclerViewOnClickListener.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {

                if(position == 0){
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
                }
                else{
                    startActivity(new Intent(MainActivity.this, ScheduleView.class));
                }

            }
        }));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
