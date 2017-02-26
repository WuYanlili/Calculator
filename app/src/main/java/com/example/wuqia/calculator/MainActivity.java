package com.example.wuqia.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText input;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Button bt9;
    private Button bt0;
    private Button bt_add;
    private Button bt_eliminate;
    private Button bt_times;
    private Button bt_minus;
    private Button bt_clear;
    private Button bt_equal;
    private Button bt_point;
    private Button bt_del;
    boolean clear_flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input= (EditText) findViewById(R.id.et_input);
        bt0= (Button) findViewById(R.id.bt_zero);
        bt1= (Button) findViewById(R.id.bt_one);
        bt2= (Button) findViewById(R.id.bt_two);
        bt3= (Button) findViewById(R.id.bt_three);
        bt4= (Button) findViewById(R.id.bt_four);
        bt5= (Button) findViewById(R.id.bt_five);
        bt6= (Button) findViewById(R.id.bt_six);
        bt7= (Button) findViewById(R.id.bt_seven);
        bt8= (Button) findViewById(R.id.bt_eight);
        bt9= (Button) findViewById(R.id.bt_nine);
        bt_add= (Button) findViewById(R.id.bt_add);
        bt_minus= (Button) findViewById(R.id.bt_minus);
        bt_times= (Button) findViewById(R.id.bt_times);
        bt_eliminate= (Button) findViewById(R.id.bt_eliminate);
        bt_clear= (Button) findViewById(R.id.bt_clear);
        bt_equal= (Button) findViewById(R.id.bt_equal);
        bt_point= (Button) findViewById(R.id.bt_point);
        bt_del= (Button) findViewById(R.id.bt_del);

        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt_point.setOnClickListener(this);
        bt_add.setOnClickListener(this);
        bt_clear.setOnClickListener(this);
        bt_eliminate.setOnClickListener(this);
        bt_equal.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_times.setOnClickListener(this);
        bt_del.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String str=input.getText().toString();
        switch (v.getId()){
            case R.id.bt_zero:
            case R.id.bt_one:
            case R.id.bt_two:
            case R.id.bt_three:
            case R.id.bt_four:
            case R.id.bt_five:
            case R.id.bt_six:
            case R.id.bt_seven:
            case R.id.bt_eight:
            case R.id.bt_nine:
            case R.id.bt_point:
                if (clear_flag){
                    clear_flag=false;
                    str="";
                    input.setText("");
                }
                input.setText(str+((Button)v).getText());
                break;
            case R.id.bt_add:
            case R.id.bt_eliminate:
            case R.id.bt_minus:
            case R.id.bt_times:
                if (clear_flag){
                    clear_flag=false;
                    str="";
                    input.setText("");
                }
                input.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.bt_clear:
                clear_flag=false;
                str="";
                input.setText("");
                break;
            case R.id.bt_del:
                if (clear_flag){
                    clear_flag=false;
                    input.setText("");
                }else {
                    if (str != null && !str.equals("")) {
                        input.setText(str.substring(0,str.length() - 1));
                    }
                }
                break;
            case R.id.bt_equal:
                getResult();
                break;
        }
    }
    private void getResult(){
        String exp=input.getText().toString();
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains("")){
            return;
        }
        if(clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        double result = 0;
        String s1=exp.substring(0,exp.indexOf(" "));
        String act=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2=exp.substring(exp.indexOf(" ")+3);
        if (!s1.equals("")&&!s2.equals("")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);
            if(act.equals("+")){
                result=d1+d2;
            }else if (act.equals("-")){
                result=d1-d2;
            }else if (act.equals("*")){
                result=d1*d2;
            }else if (act.equals("/")){
                if (d2==0){
                    result=0;
                }else {
                    result=d1/d2;
                }
            }
            if (!s1.contains(".")&&!s2.contains(".")&&!act.equals("/")){
                int r=(int)result;
                input.setText(r+"");
            }else {
                input.setText(result+"");
            }
        }else if(!s1.equals("")&&s2.equals("")){
            input.setText(exp);
        }else if (s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if(act.equals("+")){
                result=0+d2;
            }else if (act.equals("-")){
                result=0-d2;
            }else if (act.equals("*")){
                result=0;
            }else if (act.equals("/")){
                result=0;
            }
        }else if (s1.equals("")&&s2.equals("")){
            input.setText("");
        }

    }
}

