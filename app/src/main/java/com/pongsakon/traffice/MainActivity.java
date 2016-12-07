package com.pongsakon.traffice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGo;
    private ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = (ListView) findViewById(R.id.listView);
        btnGo = (Button) findViewById(R.id.button);

        btnGo.setOnClickListener(this);
        //Creat ListView
        createListView();


    } //Main Metod

    private void createListView() {
        Mydata objMydata = new Mydata();
        int[] intIcon = objMydata.icon();
        String[] strTitle = objMydata.title();

        MyAdapter objMyAdpter = new MyAdapter(MainActivity.this, intIcon, strTitle);

        myList.setAdapter(objMyAdpter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("click", "Item click success");
                myIntentTodetail(i);

            }
        });
    } //createListView

    private void myIntentTodetail(int intClick) {
        Intent intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
        intent.putExtra("click", intClick);
        startActivity(intent);
        Log.d("Detail", "success");

    }

    @Override
    public void onClick(View view) {
        Log.d("click", "success");
        Intent objIntent = new Intent(Intent.ACTION_VIEW);
        objIntent.setData(Uri.parse("https://www.youtube.com/dashboard?o=U"));
        startActivity(objIntent);
    }
}
