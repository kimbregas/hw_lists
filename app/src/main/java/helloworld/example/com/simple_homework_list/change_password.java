package helloworld.example.com.simple_homework_list;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class change_password extends AppCompatActivity {

    EditText changedPW;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_pw);

        changedPW = (EditText) findViewById(R.id.changedPW);
    }

    public void okay(View v){ //if user click okay button.

        String changed_pw = changedPW.getText().toString();
        int passWord = Integer.parseInt(changed_pw);
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_Pref.edit(); // for modifying sharedPreferences.
        toEdit.putInt("password",passWord); //store changed password in the sharedPreferences.
        toEdit.commit(); // for all or nothing.

        Toast.makeText(getApplication(),"Success!",Toast.LENGTH_SHORT).show(); //if it will be successful.
    }
    public void cancel(View v){
        finish();
    } // if user click cancel button, it will just be terminated.
}
