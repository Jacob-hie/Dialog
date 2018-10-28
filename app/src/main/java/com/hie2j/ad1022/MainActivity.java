package com.hie2j.ad1022;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showSimpleDialog();

        showListDialog();

        showRadioDialog();

        showMoreDialog();

        showCustomDialog();

    }
    //自定义对话框
    private void showCustomDialog() {
        findViewById(R.id.btn_dialog5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请输入姓名和年龄：");
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom,null);
                builder.setView(view);

                final EditText edit_name = (EditText)view.findViewById(R.id.edit_name);
                final EditText edit_age = (EditText)view.findViewById(R.id.edit_age);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = edit_name.getText().toString();
                        int age = Integer.parseInt(edit_age.getText().toString());
                        Toast.makeText(MainActivity.this, "您输入的姓名是："+name+" 您输入的年龄是："+age,
                                Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    //多项选择对话框
    private void showMoreDialog() {
        findViewById(R.id.btn_dialog4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.android);
                builder.setTitle("请选择您的爱好：");
                final String[] hobbies = {"篮球", "足球", "排球", "桌球", "乒乓球", "羽毛球"};
                final boolean[] isCheckd = new boolean[100];
                builder.setMultiChoiceItems(hobbies, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        isCheckd[which] = isChecked;
                        if (isChecked){
                            Toast.makeText(MainActivity.this, "您添加了："+hobbies[which], Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "您删除了："+hobbies[which], Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    StringBuffer sb = new StringBuffer();
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i<isCheckd.length; i++){
                            if (isCheckd[i]){
                                sb.append(hobbies[i]+",");
                            }
                        }
                        Toast.makeText(MainActivity.this, "您的爱好为："+sb, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    //单选项对话框
    private void showRadioDialog() {
        findViewById(R.id.btn_dialog3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请选择您的性别：");
                builder.setIcon(R.drawable.android);
                final String[] sex = {"男","女","未知性别"};
                builder.setSingleChoiceItems(sex, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "您选择的性别是："+sex[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    //下拉列表对话框
    private void showListDialog() {
        findViewById(R.id.btn_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.android);
                builder.setTitle("请选择您所在的城市：");
                final String[] cities = {"北京","上海","广州","深圳","香港"};
                builder.setItems(cities, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"您所在的城市为："+cities[which],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }

    //简单对话框
    private void showSimpleDialog() {
        findViewById(R.id.btn_dialog1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.android);
                builder.setTitle("今天是你的生日！");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "谢谢", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "嗯嗯", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "知道了", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
}
