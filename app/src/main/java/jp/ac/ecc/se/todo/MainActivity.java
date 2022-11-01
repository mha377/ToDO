package jp.ac.ecc.se.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intmemo= new Intent(this,memoactivity.class);
        ListView title=findViewById(R.id.title);
        EditText inputtitle=findViewById(R.id.inputtitle);
        Button todo=findViewById(R.id.todoButton);
        ArrayList<String> titlelist= new ArrayList<>();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,titlelist);
        title.setAdapter(adapter);
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=inputtitle.getText().toString();
                if(!text.equals("")){
                   titlelist.add(text);
                   title.setAdapter(adapter);
                   inputtitle.setText("");
                   startActivity(intmemo);
                }
            }
        });
        title.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv=(TextView) view;String st=(String) adapterView.getItemAtPosition(i);
                intmemo.putExtra("title",i);
                startActivity(intmemo);
            }
        });

    }
}