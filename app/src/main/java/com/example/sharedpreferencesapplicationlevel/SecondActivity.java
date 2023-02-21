package com.example.sharedpreferencesapplicationlevel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView txvName, txvMajor, txvId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txvName = findViewById(R.id.txvName);
        txvMajor = findViewById(R.id.txvMajor);
        txvId = findViewById(R.id.txvId);
    }

    public void loadData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);

        //retrieve the data from the shared preference file
        //the second parameter are the default values you need to provide

        String name = sharedPreferences.getString("name", "Name is not available!");
        String major =sharedPreferences.getString("major", "Major is not available!");
        String Id =sharedPreferences.getString("Id", "Id is not available!");

        //use the retrieved values to update the text views on the screen
        txvName.setText(name);
        txvMajor.setText(major);
        txvId.setText(Id);
    }

    public void clearData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply(); //can also be called as editor.commit();
    }

    public void removeStudentMajor(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("major");
        editor.apply(); //or editor.commit();
    }
}
