package helloworld.example.com.simple_homework_list;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class mini_calculator extends AppCompatActivity implements View.OnClickListener {

    TextView user_input;
    Button zero,one, two, three, four, five, six, seven, eight, nine;
    Button divi, multi, plus, minus, result, cancel;
    int flag_operand = 0; //만약 피연산자가 하나라도 입력면 1로 바뀜.
    int flag_operator = 0; //만약 연산자가 하나라도 입력되면 1로 바뀜
    int now_operator = -1; //plus :1, minus:2, multiplication:3 , division :4
    String left_op, right_op;
    Intent sendingResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mini_calculator);

        user_input = (TextView) findViewById(R.id.user_input);

        //Numbers
        zero= (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);

        //Operator
        divi = (Button) findViewById(R.id.division);
        multi = (Button) findViewById(R.id.multipication);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        result = (Button) findViewById(R.id.result);
        cancel = (Button) findViewById(R.id.cancel);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

        divi.setOnClickListener(this);
        multi.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        result.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                if(flag_operator == 0 && flag_operand == 1){ // if the result value already exists.
                    flag_operand = 0;
                    user_input.setText("");
                    input_number(1);
                    break;
                }
                else {
                    input_number(1);
                    break;
                }
            case R.id.two:
                if(flag_operator == 0 && flag_operand == 1){ // if the result value already exists.
                    flag_operand = 0;
                    user_input.setText("");
                    input_number(2);
                    break;
                }
                else {
                    input_number(2);
                    break;
                }
            case R.id.three:
                if(flag_operator == 0 && flag_operand == 1){ // if the result value already exists.
                    flag_operand = 0;
                    user_input.setText("");
                    input_number(3);
                    break;
                }
                else {
                    input_number(3);
                    break;
                }
            case R.id.four:
                if(flag_operator == 0 && flag_operand == 1){ // if the result value already exists.
                    flag_operand = 0;
                    user_input.setText("");
                    input_number(4);
                    break;
                }
                else {
                    input_number(4);
                    break;
                }
            case R.id.five:
                if(flag_operator == 0 && flag_operand == 1){ // if the result value already exists.
                    flag_operand = 0;
                    user_input.setText("");
                    input_number(5);
                    break;
                }
                else {
                    input_number(5);
                    break;
                }
            case R.id.six:
                if(flag_operator == 0 && flag_operand == 1){ // if the result value already exists.
                    flag_operand = 0;
                    user_input.setText("");
                    input_number(6);
                    break;
                }
                else {
                    input_number(6);
                    break;
                }
            case R.id.seven:
                if(flag_operator == 0 && flag_operand == 1){ // if the result value already exists.
                    flag_operand = 0;
                    user_input.setText("");
                    input_number(7);
                    break;
                }
                else {
                    input_number(7);
                    break;
                }
            case R.id.eight:
                if(flag_operator == 0 && flag_operand == 1){ // if the result value already exists.
                    flag_operand = 0;
                    user_input.setText("");
                    input_number(8);
                    break;
                }
                else {
                    input_number(8);
                    break;
                }
            case R.id.nine:
                if(flag_operator == 0 && flag_operand == 1){ // if the result value already exists.
                    flag_operand = 0;
                    user_input.setText("");
                    input_number(9);
                    break;
                }
                else {
                    input_number(9);
                    break;
                }
            case R.id.zero:
                if(flag_operator == 0 && flag_operand == 1){ // if the result value already exists.
                    flag_operand = 0;
                    user_input.setText("");
                    input_number(0);
                    break;
                }
                else {
                    input_number(0);
                    break;
                }
            case R.id.cancel:
                user_input.setText(""); //text view initialization.
                flag_operand = 0;
                flag_operator = 0;
                break;
            case R.id.plus:
                if(is_error() == 1 || flag_operator == 1){ //연산자를 이미 눌렀거나, text view에 아무것도 존재하지 않는다면
                    Toast.makeText(getApplication(),"Error",Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    input_operator();
                    now_operator=1;
                    break;
                }
            case R.id.minus:
                if(is_error() == 1 || flag_operator == 1){ //연산자를 이미 눌렀거나, text view에 아무것도 존재하지 않는다면
                    Toast.makeText(getApplication(),"Error",Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    input_operator();
                    now_operator=2;
                    break;
                }
            case R.id.multipication:
                if(is_error() == 1 || flag_operator == 1){//연산자를 이미 눌렀거나, text view에 아무것도 존재하지 않는다면
                    Toast.makeText(getApplication(),"Error",Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    input_operator();
                    now_operator=3;
                    break;
                }
            case R.id.division:
                if(is_error() == 1 || flag_operator == 1){//연산자를 이미 눌렀거나, text view에 아무것도 존재하지 않는다면
                    Toast.makeText(getApplication(),"Error",Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    input_operator();
                    now_operator=4;
                    break;
                }
            case R.id.result:
                if(is_error()==1){//text view에 아무것도 존재하지 않음에도 불구하고 결과값을 도출할려고 한다면
                    Toast.makeText(getApplication(),"Error",Toast.LENGTH_SHORT).show();
                }
                else{
                    show_result();
                }
                break;
        }
    }

    public void input_number(int temp){
        String numbers = user_input.getText().toString();
        numbers += String.valueOf(temp); //convert string.
        user_input.setText(numbers);
    }
    public int is_error(){
        if(user_input.getText().toString().getBytes().length <= 0) { //if it is null.
            return 1;
        }
        return 0;
    }
    public void input_operator(){
        if(flag_operand == 0 || flag_operator ==0 ) { // if any operand don't exist,it will be left operand
            left_op = user_input.getText().toString();
            user_input.setText("");
            flag_operand = 1; // left_operand
            flag_operator =1;
        }
    }
    public void show_result() {
        if(flag_operand == 1 && flag_operator ==1) { // it means that both left operand and right operand exist.
            double result = 0;
            right_op = user_input.getText().toString();

            double left = Double.parseDouble(left_op);
            double right = Double.parseDouble(right_op);

            switch (now_operator){
                case 1: //plus
                    result = left+right;
                    break;
                case 2: //minus
                    result = left-right;
                    break;
                case 3: //multiplication
                    result = left*right;
                    break;
                case 4: //division
                    if(left == 0 || right == 0){ //divid by zero handling.
                        Toast.makeText(getApplication(),"Divide by zero",Toast.LENGTH_SHORT).show();
                        result = 0;
                    }
                    else {
                        result = left / right;
                    }
                    break;
            }

            sendingResult = getIntent(); // get intent which is carried by 'desc_calcu' to send result value.
            sendingResult.putExtra("result",result); // store result value
            setResult(Activity.RESULT_OK,sendingResult); // store resultCode.
            user_input.setText(String.valueOf(result));
            flag_operator = 0;
            flag_operand = 1;
            finish(); // if any error don't occur, it will be terminated.
        }
    }
}
