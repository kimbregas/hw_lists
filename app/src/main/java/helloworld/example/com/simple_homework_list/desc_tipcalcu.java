package helloworld.example.com.simple_homework_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class desc_tipcalcu extends AppCompatActivity {
    Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_tipcalculator);

        go = (Button)findViewById(R.id.go_tipCalculator);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //if user click button
                startActivity(new Intent(getApplication(), tip_calculator.class)); //move tip_counter
            }
        });
    }
}

