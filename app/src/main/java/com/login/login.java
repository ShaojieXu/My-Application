package com.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


import com.SQlite.MySQLiteOpenHelper;
import com.example.myapplication.R;
import com.firstpage.firstpage;
import com.publicClass.User;

/**
 * 用户登录界面的控件设置
 */
public class login extends AppCompatActivity {
    private MySQLiteOpenHelper MS;
    private Button myBtnLogin;
    private String password;
    private String email;
    private Boolean isSignin;
    private Boolean isSignup;
    private Button signinButton ;
    private Button signupButton;
    private EditText mailEditText;
    private  EditText passwordEditText;



    private Context myContext;
    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase db;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG","--------login界面-------");
        this.isSignin=false;
        this.isSignup=false;
        //MS = new MySQLiteOpenHelper((this));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        myContext = login.this;
        mySQLiteOpenHelper = new MySQLiteOpenHelper(myContext);


        //找到控件
        myBtnLogin = findViewById(R.id.SigninButton);
        signinButton =(Button) findViewById(R.id.SigninButton);
        signupButton = (Button) findViewById(R.id.SignupButton);
        mailEditText=(EditText) findViewById(R.id.Email);
        passwordEditText=(EditText) findViewById(R.id.password);
    }

    /**
     * 登录与注册按钮的带年纪效果，点击后将窗口的两个字符串读取进来
     * @param view 按钮的点击操作
     */
     @SuppressLint("NonConstantResourceId")
     public void getInformation(View view) {
         this.email = String.valueOf(this.mailEditText.getText());
         this.password = String.valueOf(this.passwordEditText.getText());
         switch (view.getId()){
             case R.id.SigninButton:
                 this.isSignin=true;
                 this.isSignup=false;
                 Log.d("TAG","--------点击按钮-------");
                 Intent intent= new Intent(login.this, firstpage.class);
                 startActivity(intent);
                 break;
             case R.id.SignupButton:
                 this.isSignup=true;
                 this.isSignup=false;
                 break;
         }

         User user = new User();
         user.setPhoneNumber(null);
         user.setPassword(this.password);
         user.setName("xyz");
         user.setMail(this.email);


        mySQLiteOpenHelper.insertData(user);
        mySQLiteOpenHelper.queryFromDBByName("xyz");

     }




    /**
     * 用户输入信息，验证是否正确,使用类的内部变量
     * @return Boolean
     */
    Boolean judge() {

        return false;
    }
}
