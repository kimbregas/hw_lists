package helloworld.example.com.simple_homework_list;

/**
 * Created by kimbregas9 on 2016-04-16.
 */
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class hw_lists extends ListActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] values = new String[] { "Time-Table","Tip-Counter","Calculator","Change PW" }; // create string array for AdapterArray.
        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values); //customized ArrayAdapter.
        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        if(item.startsWith("Time")) { // if user click Time table.
            startActivity(new Intent(getApplication(),desc_timetable.class)); //move time table description.
        }
        else if(item.startsWith("Tip")){ // if user click tip counter.
            startActivity(new Intent(getApplication(),desc_tipcalcu.class)); // move tip counter description.
        }
        else if(item.startsWith("Calculator")){ // if user click calculator
            startActivity(new Intent(getApplication(),desc_calcu.class)); // move calculator description.
        }
        else if(item.startsWith("Change")){ // if user change password
            startActivity(new Intent(getApplication(),change_password.class)); //move change password.
        }
    }
}

class MySimpleArrayAdapter extends ArrayAdapter<String> { // i create this class to make customized ArrayAdapter.
    private final Context context;
    private final String[] values;
    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.hw_list, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.hw_list, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.hw_label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.hw_icon);
        textView.setText(values[position]);
        String s = values[position];
        if (s.startsWith("Time")){ //if it is time table.
            imageView.setImageResource(R.drawable.timetable); // make timetable icon.
        } else if(s.startsWith("Tip")){ //if it is tip counter
            imageView.setImageResource(R.drawable.tip); // make tip-counter icon.
        }else if(s.startsWith("Cal")) { //if it is calculator
            imageView.setImageResource(R.drawable.calculator); //make calculator icon.
        }else if(s.startsWith("Change")) { //if it is change password
            imageView.setImageResource(R.drawable.change_pw); // make change password icon.
        }
        return rowView;
    }
}