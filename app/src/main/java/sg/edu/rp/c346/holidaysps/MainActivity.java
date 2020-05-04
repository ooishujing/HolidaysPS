package sg.edu.rp.c346.holidaysps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> typeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvType);
        typeList = new ArrayList<>(Arrays.asList("Secular","Ethnic & Religion"));
        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1,typeList);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("title", typeList.get(position));
                startActivity(intent);
            }
        });
    }
}
