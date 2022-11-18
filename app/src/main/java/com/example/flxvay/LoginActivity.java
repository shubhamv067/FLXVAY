package com.example.flxvay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.flxvay.OperationRetrofitApi.ApiClient;
import com.example.flxvay.OperationRetrofitApi.ApiInterface;
import com.example.flxvay.OperationRetrofitApi.users;
import com.example.flxvay.Sessions.SessionManger;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ImageView back_arrow;
    LinearLayout signUp_text_for_signin;

    EditText Email_Login, password_Login;
    Button Loginbtn;
    public static ApiInterface apiInterface;
     String user_email ;
     String user_password;
     String user_id;
     SessionManger sessionManger;
     ProgressBar Blue_progressBar;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        sessionManger = new SessionManger(this);
        init();

        Blue_progressBar.setVisibility(View.GONE);


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_email = Email_Login.getText().toString();
                user_password = password_Login.getText().toString();

                checkEmailANDPassword(user_email,user_password);
            }
        });

        addTextchangeListner();

        function_signUp_text_for_Login();
    }



    private void init() {
        back_arrow = findViewById(R.id.back_arrow);
        signUp_text_for_signin = findViewById(R.id.signUp_btn_for_signin);
        Email_Login = findViewById(R.id.Email_Login);
        password_Login = findViewById(R.id.password_Login);
        Loginbtn = findViewById(R.id.Continue_btn);
        Blue_progressBar = findViewById(R.id.Blue_progressBar);
    }

    private void addTextchangeListner(){
        Loginbtn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password_Login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(Email_Login.getText())) {
            if (!TextUtils.isEmpty(password_Login.getText())) {
                Loginbtn.setEnabled(true);
                Loginbtn.setTextColor(Color.rgb(255, 255, 255));
            } else {
                Loginbtn.setEnabled(false);
                Loginbtn.setTextColor(Color.argb(50, 255, 255, 255));
            }
        } else {
            Loginbtn.setEnabled(false);
            Loginbtn.setTextColor(Color.argb(50, 255, 255, 255));
        }
    }


    private void checkEmailANDPassword(String Email,String Password) {
        if (Email_Login.getText().toString().matches(emailPattern)){
            if (password_Login.length() >= 8){
                Blue_progressBar.setVisibility(View.VISIBLE);
                Loginbtn.setEnabled(false);
                Loginbtn.setTextColor(Color.argb(50,255,255,255));

                Call<users> call = apiInterface.performEmailLogin(Email,Password);
                call.enqueue(new Callback<users>() {
                    @Override
                    public void onResponse(Call<users> call, Response<users> response) {
                        if (response.body().getResponse().equals("ok")) {

                            user_id = response.body().getUserid();

                            sessionManger.createSession(user_id);
                            Blue_progressBar.setVisibility(View.GONE);
                            Intent mainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(mainActivityIntent);
                            finish();


                        } else if (response.body().getResponse().equals("no_account")) {
                            Loginbtn.setEnabled(true);
                            Loginbtn.setTextColor(Color.rgb( 255, 255, 255));
                            Blue_progressBar.setVisibility(View.GONE);


                            Toast.makeText(LoginActivity.this, "Something went wrong,Please Create Account !.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<users> call, Throwable t) {

                        Loginbtn.setEnabled(true);
                        Loginbtn.setTextColor(Color.rgb( 255, 255, 255));
                        Blue_progressBar.setVisibility(View.GONE);

                    }
                });
            }else {
                password_Login.setError("Enter valid Password!.");
            }
        }else {
            Email_Login.setError(" Enter valid Email!.");
        }
    }

    private void function_signUp_text_for_Login() {
        signUp_text_for_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_signin_text_for_signup = new Intent(LoginActivity.this, SignupActivity.class);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
                startActivity(goto_signin_text_for_signup);
                finish();
            }
        });
    }

}