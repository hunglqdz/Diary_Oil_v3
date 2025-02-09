package com.example.diary_oil_v3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class On_Boa2 extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private EditText OilChangeDis,OilChangeTime;
    private EditText MaintenanceDis,MaintenanceTime;
    private int o1,o2,m1,m2;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String OCD = "oilchangedis";
    public static final String OCT = "oilchangetime";
    public static final String MTD = "maintenancedis";
    public static final String MTT = "maintenancetime";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setuppage2);

        OilChangeDis = (EditText) findViewById(R.id.editTextOilChangeDis);
        OilChangeTime = (EditText) findViewById(R.id.editTextOilChangeTime);
        MaintenanceDis = (EditText) findViewById(R.id.editTextMaintenanceDis);
        MaintenanceTime = (EditText) findViewById(R.id.editTextMaintenanceTime);

        btn1 = (Button) findViewById(R.id.next_btn_2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Intent intent = new Intent(On_Boa2.this, On_Boa3.class);
                startActivity(intent);
            }
        });

        btn2 = (Button) findViewById(R.id.return_btn_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(On_Boa2.this, On_Boa1.class);
                startActivity(intent);
            }
        });
        loadData();
        updateView();
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(OCD, Integer.parseInt(OilChangeDis.getText().toString()));
        editor.putInt(OCT, Integer.parseInt(OilChangeTime.getText().toString()));
        editor.putInt(MTD, Integer.parseInt(MaintenanceDis.getText().toString()));
        editor.putInt(MTT, Integer.parseInt(MaintenanceTime.getText().toString()));
        editor.apply();
        Toast.makeText(this, "Data Saved" ,Toast.LENGTH_SHORT);


    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        o1 = sharedPreferences.getInt(OCD,0);
        o2 = sharedPreferences.getInt(OCT,0);
        m1 = sharedPreferences.getInt(MTD,0);
        m2 = sharedPreferences.getInt(MTT,0);


    }

    public void updateView(){
        if
        (o1==0)
        {
            OilChangeDis.setText("");
        }
        else
        {OilChangeDis.setText(Integer.toString(o1));}

        if
        (o2==0)
        {
            OilChangeTime.setText("");
        }
        else
        {OilChangeTime.setText(Integer.toString(o2));}
        if
        (m1==0)
        {
            MaintenanceDis.setText("");
        }
        else
        {MaintenanceDis.setText(Integer.toString(m1));}
        if
        (m2==0)
        {
            MaintenanceTime.setText("");
        }
        else
        {MaintenanceTime.setText(Integer.toString(m2));}


    }
}