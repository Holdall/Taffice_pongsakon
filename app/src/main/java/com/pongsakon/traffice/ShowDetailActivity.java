package com.pongsakon.traffice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetailActivity extends AppCompatActivity{

    private TextView showTitleTextView;
    private TextView showDetailTextView;
    private ImageView showTrafficImgeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);


        bindWidget();

        showWidget();

    }

    private void showWidget() {

        int inclick = getIntent().getIntExtra("click", 0);

        Mydata objMydata = new Mydata();
        String[] strTitles = objMydata.title();
        showTitleTextView.setText(strTitles[inclick]);

        int[] intDrawable = objMydata.icon();
        showTrafficImgeView.setImageResource(intDrawable[inclick]);

        String[] strDetail = getResources().getStringArray(R.array.traffic_detail);
        showDetailTextView.setText(strDetail[inclick]);





    }

    private void bindWidget() {

        showTitleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        showDetailTextView = (TextView) findViewById(R.id.txtdetial);

        showTrafficImgeView = (ImageView) findViewById(R.id.imgDetail);


    }

}
