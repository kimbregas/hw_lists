    package helloworld.example.com.simple_homework_list;

    import android.app.Activity;
    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    public class desc_calcu extends AppCompatActivity {

        Button go;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.desc_calculator);

            go = (Button)findViewById(R.id.go_calculator);

            go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { //if user click button
                    Intent result = new Intent(getApplication(),mini_calculator.class); // move mini_calculator.
                    startActivityForResult(result, 9900); // Because i should receive result value on this activity, i must use this method.

                }

            });
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            try {
                if ((requestCode == 9900 ) && (resultCode == Activity.RESULT_OK)){ //if i receive result value successfully
                   Bundle myResults = data.getExtras();
                    double temp_result = myResults.getDouble("result"); // get result value
                    Toast.makeText(getApplication(),"Result is "+temp_result,Toast.LENGTH_SHORT).show(); // show result value to user.
                }
            } catch (Exception e) { // if error occur.
                Toast.makeText(getApplication(),"Error...!!",Toast.LENGTH_SHORT).show();
            }
        }//onActivityResult
    }
