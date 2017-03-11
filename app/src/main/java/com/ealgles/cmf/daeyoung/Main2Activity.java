package com.ealgles.cmf.daeyoung;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Calendar;


public class Main2Activity extends AppCompatActivity {

    TextView breakfast;
    TextView lunch;
    TextView dinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        breakfast = (TextView) findViewById(R.id.breakfast);
        lunch = (TextView) findViewById(R.id.lunch);
        dinner = (TextView) findViewById(R.id.dinner);
        String[] s;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Document document = Jsoup.connect("http://daeyoung.school.gyo6.net/daeyoung/100801/food").get();
                    Elements elements = document.select(".web_box .tb_calendar tbody tr td");
                    Calendar cal = Calendar.getInstance();
                    cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
                    Calendar cl = Calendar.getInstance();
                    final String[] s = elements.get(cl.get(Calendar.DAY_OF_MONTH)+ cal.get(Calendar.DAY_OF_WEEK)).text().split("[\\[^식\\]$]");
                    if(s.length<2){

                        breakfast.setText("없엉 ㅠㅠ");
                        lunch.setText("없엉 ㅠㅠ");
                        dinner.setText("없엉 ㅠㅠ");
                        return;
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            breakfast.setText(s[3]);
                            lunch.setText(s[6]);
                            dinner.setText(s[9]);
                        }
                    });
                } catch (IOException e){
                    e.printStackTrace();;
                }
            }
        }).start();
    }
}
