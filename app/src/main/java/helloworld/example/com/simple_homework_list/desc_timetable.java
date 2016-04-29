package helloworld.example.com.simple_homework_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class desc_timetable extends AppCompatActivity {

    Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_timetable);

        go = (Button)findViewById(R.id.go_timetable);

        go.setOnClickListener(new View.OnClickListener() { // if user click button
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), time_table.class)); //move time_table.
            }
        });
    }
}
