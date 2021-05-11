package com.example.zadaniea4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends MainActivity implements View.OnClickListener {
    TextView textName;
    TextView textSurname;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textSurname = (TextView) findViewById(R.id.textSurname);
        textName = (TextView) findViewById(R.id.textName);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener((View.OnClickListener) this);

        Intent myLocalIntent = getIntent();

        Bundle myBundle = myLocalIntent.getExtras();
        int v1 = myBundle.getInt("val1");
        int v2 = myBundle.getInt("val2");

        String vResult1;
        String vResult2;
        if ((v1 == 249011) && (v2 == 3)) {
            textName.setText("Jan");
            textSurname.setText("Bronicki");
            vResult1 = "Jan";
            vResult2 = "Bronicki";
        } else {
            textName.setText("ErrorNotFoundStudent");
            textSurname.setText("ErrorNotFoundStudent");
            vResult1 = "ErrorNotFoundStudent";
            vResult2 = "ErrorNotFoundStudent";
        }

        myBundle.putString("vresult1", vResult1);
        myBundle.putString("vresult2", vResult2);

        myLocalIntent.putExtras(myBundle);

        setResult(Activity.RESULT_OK, myLocalIntent);
    }

    public void onClick(View v) {
        finish();
    }
}