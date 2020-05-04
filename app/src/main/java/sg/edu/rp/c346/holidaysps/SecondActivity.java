package sg.edu.rp.c346.holidaysps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    ArrayList<Holidays> secular, er, holidays;
    ListView lv;
    ArrayAdapter aa;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = this.findViewById(R.id.lvDay);


        secular = new ArrayList<>(Arrays.asList(new Holidays("New Years Day", "1 Jan 2017" ,R.drawable.newyear), new Holidays("Labour Day", "1 May 2017", R.drawable.labour)));
        er = new ArrayList<>(Arrays.asList(new Holidays("Chinese New Year", "28-29 Jan 2017", R.drawable.cny), new Holidays("Good Friday", "14 April 2017", R.drawable.goodfriday)));
        tv = findViewById(R.id.tvTitle);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tv.setText(title);
        if (title.equalsIgnoreCase("Secular")) {
            holidays = secular;
        }
        else {
            holidays = er;
        }


        aa = new HolidaysAdapter(this, R.layout.row_second, holidays);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holidays currentDay = holidays.get(position);

                Toast.makeText(SecondActivity.this, currentDay.getName()
                                + " Date: " + currentDay.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

}
