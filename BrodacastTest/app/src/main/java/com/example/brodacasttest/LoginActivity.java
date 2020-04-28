package com.example.brodacasttest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private EditText accountEdit;
    private EditText passEdit;
    private Button login;
    private CheckBox checkBox;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = findViewById(R.id.account);
        passEdit = findViewById(R.id.password);
        login = findViewById(R.id.login);
        checkBox = findViewById(R.id.remember_pass);
        final boolean isRemember = preferences.getBoolean("remember_password",false);
        if (isRemember){
            String account = preferences.getString("account","");
            String password = preferences.getString("password","");
            accountEdit.setText(account);
            passEdit.setText(password);
            checkBox.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passEdit.getText().toString();
                if(account.equals("admin")&&password.equals("123456")){
                    editor = preferences.edit();
                    if(checkBox.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
