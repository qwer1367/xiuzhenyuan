package com.wtl.ui;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText phone1;
    private EditText password1;
    private EditText editText_verification;
    private Button register;
    private Button signIn ;
    private Button verification;
    Random random = new Random();
    private String verficationCode = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone1 = (EditText)findViewById(R.id.phone);
        password1 = (EditText)findViewById(R.id.password);
        register = (Button)findViewById(R.id.register);
        signIn = (Button)findViewById(R.id.signIn);
        verification = (Button)findViewById(R.id.sendVerification);
        editText_verification = (EditText)findViewById(R.id.verificationCode);
        //注册按钮上的逻辑
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag_phone = 0;
                int flag_password = 0;
                int flag_verification = 0;

                //判断手机号是否符合
                String phoneNumber = phone1.getText().toString();
                if (phoneNumber.length() != 11){
                    Toast.makeText(MainActivity.this,"手机号必须为18位",Toast.LENGTH_SHORT).show();
                } else {
                    flag_phone = 1;
                }

                //判断密码是否合乎
                String passwordNumber = password1.getText().toString();
                if ((passwordNumber.length() < 7) || (passwordNumber.length() > 17)){
                    Toast.makeText(MainActivity.this,"密码必须在7到16位之间",Toast.LENGTH_SHORT).show();
                } else {
                    flag_password = 1;
                }

                //判断验证码是否合乎
                String s = editText_verification.getText().toString();
                if (s.equals(verficationCode)){
                    flag_verification = 1;
                } else {
                    Toast.makeText(MainActivity.this,"验证码不正确",Toast.LENGTH_SHORT).show();
                }

                //检查是否全都符合
                if ((flag_password == 1) && (flag_phone == 1) && (flag_verification == 1)){
                    Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"尚未开发",Toast.LENGTH_SHORT).show();
            }
        });

        verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first = random.nextInt(10);
                int second = random.nextInt(10);
                int third = random.nextInt(10);
                String s = String.valueOf(first) + String.valueOf(second) + String.valueOf(third);
                verficationCode = s;
                Toast.makeText(MainActivity.this,"此次验证码为" + s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
