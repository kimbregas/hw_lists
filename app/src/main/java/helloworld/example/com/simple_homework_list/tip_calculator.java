package helloworld.example.com.simple_homework_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class tip_calculator extends AppCompatActivity {

    RadioButton fifteen;
    RadioButton twenty;
    RadioButton others;
    EditText texting;
    EditText other_value;
    Button btn;

    String store_Userinput;
    String store_Othervalue;

    double user_input;
    double forOtherValue;
    double total;
    double tip;

    /* in order to maintains the current values of the screen so that all
        the values will not change even when your app is resumed after a pause or the screen is rotated*/
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("user_input",store_Userinput);
        savedInstanceState.putString("user_othervalue",store_Othervalue);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        store_Userinput = savedInstanceState.getString("user_input");
        store_Othervalue = savedInstanceState.getString("user_othervalue");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_calculator);

        texting = (EditText) findViewById(R.id.texting);
        fifteen = (RadioButton) findViewById(R.id.fifteen);
        twenty = (RadioButton) findViewById(R.id.twenty);
        others = (RadioButton) findViewById(R.id.others);
        other_value = (EditText) findViewById(R.id.other_value);
        btn = (Button) findViewById(R.id.calculate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                store_Userinput = texting.getText().toString();
                store_Othervalue = other_value.getText().toString();

                if (store_Userinput.getBytes().length <= 0) {  // if you enter null value in the 'texting' edit text
                    Toast.makeText(getApplication(), "Please enter 'total amount'", Toast.LENGTH_SHORT).show();
                } else {
                    user_input = Double.parseDouble(store_Userinput);

                    if (fifteen.isChecked()) {
                        tip = user_input * 0.15;
                        total = user_input + tip;
                        Toast.makeText(getApplication(), "Tip : " + tip + " Total : " + total, Toast.LENGTH_SHORT).show();
                    } else if (twenty.isChecked()) {
                        tip = user_input * 0.20;
                        total = user_input + tip;
                        Toast.makeText(getApplication(), "Tip : " + tip + " Total : " + total, Toast.LENGTH_SHORT).show();
                    } else if (others.isChecked()) {
                        if (store_Othervalue.getBytes().length <= 0) {  // if you enter null value in the 'other value' edit text.
                            Toast.makeText(getApplication(), "Please enter 'other value'", Toast.LENGTH_SHORT).show();
                        } else {
                            forOtherValue = Integer.parseInt(store_Othervalue);

                            if (forOtherValue >= 100) { // it don't make sense... 100% over....
                                Toast.makeText(getApplication(), "Please re-enter 'ohter value'", Toast.LENGTH_SHORT).show();
                            } else {
                                tip = user_input * (double) (forOtherValue / 100);
                                total = user_input + tip;
                                Toast.makeText(getApplication(), "Tip : " + tip + " Total : " + total, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

            }
        });
    }

}

