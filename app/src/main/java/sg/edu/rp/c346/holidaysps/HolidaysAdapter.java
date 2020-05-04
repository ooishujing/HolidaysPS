package sg.edu.rp.c346.holidaysps;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidaysAdapter extends ArrayAdapter<Holidays> {

    private Context context;
    private ArrayList<Holidays> holidays;
    private TextView tvN,tvD;
    private ImageView iv;

    public HolidaysAdapter(Context context, int resource, ArrayList<Holidays> objects){
        super(context, resource, objects);
        // Store the module that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row_second, parent, false);

        // Get the TextView object
        tvN = (TextView) rowView.findViewById(R.id.tvName);
        tvD = (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        iv = (ImageView) rowView.findViewById(R.id.iv);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the module at the same index.
        Holidays currentDay = holidays.get(position);
        // Set the TextView to show the food

        tvN.setText(currentDay.getName());
        tvD.setText(currentDay.getDate());
        iv.setImageResource(currentDay.getPic());
        // Return the nicely done up View to the ListView
        return rowView;
    }


}
