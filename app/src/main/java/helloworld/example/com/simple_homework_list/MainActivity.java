package helloworld.example.com.simple_homework_list;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText pw_1;
    EditText pw_2;
    EditText pw_3;
    EditText pw_4;
    String password;
    SharedPreferences sh_Pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        pw_1 = (EditText) findViewById(R.id.pw_1);
        pw_2 = (EditText) findViewById(R.id.pw_2);
        pw_3 = (EditText) findViewById(R.id.pw_3);
        pw_4 = (EditText) findViewById(R.id.pw_4);

        pw_1.addTextChangedListener(new TextWatcher() { // if you enter int a first EditText, focus move next(second EditText)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) { // it help to move next focus.
                password = pw_1.getText().toString();
                pw_2.requestFocus();
            }
        });

        pw_2.addTextChangedListener(new TextWatcher() { // if you enter int a second EditText, focus move next(third EditText)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) { // it help to move next focus
                password += pw_2.getText().toString();
                pw_3.requestFocus();
            }
        });
        pw_3.addTextChangedListener(new TextWatcher() {// if you enter int a third EditText, focus move next(fourth EditText)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) { //it help to move next focus
                password += pw_3.getText().toString();
                pw_4.requestFocus();
            }
        });
        pw_4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) { // it will check real_password which is assinged by user.
                sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE); // get value from inner storeage.
                password += pw_4.getText().toString();
                int correct_pw = Integer.parseInt(password);

                if (!sh_Pref.contains("password")) { //if value assinged by user don't exist.
                    if (correct_pw == 0000) // default password is 0000
                        startActivity(new Intent(getApplication(), hw_lists.class)); // move hw_list.
                    else // if user enter false password
                        Toast.makeText(getApplication(),"Please re-enter password !",Toast.LENGTH_SHORT).show();
                }
                else{
                    int real_password = sh_Pref.getInt("password",000); //if value assinged by user exist.
                    if(correct_pw == real_password)
                        startActivity(new Intent(getApplication(), hw_lists.class)); // move hw_list.
                    else // if user enter false password
                        Toast.makeText(getApplication(),"Please re-enter password !",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
