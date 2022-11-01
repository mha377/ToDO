package jp.ac.ecc.se.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class memoactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoactivity);
        SharedPreferences pref=getPreferences(Context.MODE_PRIVATE);
        EditText memo=findViewById(R.id.memo);
        Button save=findViewById(R.id.save);
        Button cancel=findViewById(R.id.cancel);
        Button reset=findViewById(R.id.reset);
        Button camera=findViewById(R.id.camera);
        ImageView picture1=findViewById(R.id.picture1);
        ImageView picture2=findViewById(R.id.picture2);
        ImageView picture3=findViewById(R.id.picture3);
        String[] memolist = new String[11];
        Intent intent=getIntent();
        int title=intent.getIntExtra("title",10);
        String memory=pref.getString(memolist[title],"");
        memo.setText(memory);
        SharedPreferences.Editor editor=pref.edit();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(memolist[title],memo.getText().toString());
                editor.apply();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("memo",null);
                editor.apply();
                memo.setText(null);
            }
        });
    }
}