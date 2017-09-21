package com.example.a7dialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButton1;
    private Button mButton2;
    private Dialog mDlgLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button) findViewById(R.id.Button1);
        mButton2 = (Button) findViewById(R.id.Button2);
        mButton1.setOnClickListener(Button1_OnClick);
        mButton2.setOnClickListener(Button2_OnClick);
    }
    public View.OnClickListener Button2_OnClick = new View.OnClickListener() {
        public void onClick(View v) {
            mDlgLogin = new Dialog(MainActivity.this);
            mDlgLogin.setTitle("提示");
            mDlgLogin.setCancelable(false);
            mDlgLogin.setContentView(R.layout.activity_wearing);
            Button wButton3 = (Button) mDlgLogin.findViewById(R.id.button3);
            wButton3.setOnClickListener(wButton3OnClick);
            mDlgLogin.show();
        }
    };
    public  View.OnClickListener wButton3OnClick=new  View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mDlgLogin.cancel();
        }
    };
    public View.OnClickListener Button1_OnClick = new View.OnClickListener() {
        public void onClick(View v) {
            mDlgLogin = new Dialog(MainActivity.this);
            mDlgLogin.setTitle("登录系统");
            mDlgLogin.setCancelable(false);
            mDlgLogin.setContentView(R.layout.activity_log);
            Button loginBtnOK = (Button) mDlgLogin.findViewById(R.id.btnOK);
            loginBtnOK.setOnClickListener(loginDlgBtnOKOnClick);
            mDlgLogin.show();
        }
    };
        public View.OnClickListener loginDlgBtnOKOnClick = new View.OnClickListener() {
            public void onClick(View v) {
                EditText edtUserName = (EditText) mDlgLogin.findViewById(R.id.edtUserName);
                EditText edtPassword = (EditText) mDlgLogin.findViewById(R.id.edtPassword);
                String userName = edtUserName.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (userName.equals("abc") && password.equals("123")) {
                    Toast.makeText(MainActivity.this, R.string.success, Toast.LENGTH_LONG).show();
                }
                else {
                     Toast.makeText(MainActivity.this, R.string.defeat, Toast.LENGTH_LONG).show();
                }
                mDlgLogin.cancel();
            }
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
                return true;
            }
        };
    }