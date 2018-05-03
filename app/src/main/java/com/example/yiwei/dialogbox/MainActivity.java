package com.example.yiwei.dialogbox;
import android.content.DialogInterface;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.buttonTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View view1=inflater.inflate(R.layout.login_dialog ,null);
                builder.setView(view1)

                        .setTitle("Login")

                        .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText edittext = (EditText)view1.findViewById(R.id.editTestUserId);
                                EditText edit2 = (EditText)view1.findViewById(R.id.editTestPwd);
                                String zh = edittext.getText().toString();
                                String mm =edit2.getText().toString();


                                if(zh.equals("abc") && mm.equals("123")) {
                                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "帐号或密码错误", Toast.LENGTH_LONG).show();
                                }
                            }

                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                builder.show();

            }
        });
        Button btn2 = (Button) findViewById(R.id.buttonRead);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setIcon(android.R.drawable.ic_dialog_info);
                dialog.setTitle("提示对话框");
                dialog.setMultiChoiceItems(new String[]{"是", "否"},new boolean[]{false,false} ,new DialogInterface.OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // TODO Auto-generated method stub

                    }
                });

                dialog.setPositiveButton("确定",null);
                dialog.show();

            }
        });
    }
}

