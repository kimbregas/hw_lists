package helloworld.example.com.simple_homework_list;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class time_table extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_table);

        LinearLayout mon = (LinearLayout)findViewById(R.id.monday);
        LinearLayout tue = (LinearLayout)findViewById(R.id.tuesday);
        LinearLayout wed = (LinearLayout)findViewById(R.id.wednesday);
        LinearLayout thur = (LinearLayout)findViewById(R.id.thursday);
        LinearLayout fri = (LinearLayout)findViewById(R.id.friday);

        Calendar weeks = Calendar.getInstance();
        int today = weeks.get(Calendar.DAY_OF_WEEK); // to receive today data.
        float degree = (float)0.42; // it is used to highlight selected data.

        switch (today) {
            case 2:
                mon.setAlpha(degree);
                break;
            case 3:
                tue.setAlpha(degree);
                break;
            case 4:
                wed.setAlpha(degree);
                break;
            case 5:
                thur.setAlpha(degree);
                break;
            case 6:
                fri.setAlpha(degree);
                break;
            default:
                Toast.makeText(getApplication(), "Weekend! ", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}

