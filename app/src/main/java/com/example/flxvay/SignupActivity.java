


package com.example.flxvay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.flxvay.OperationRetrofitApi.ApiClient;
import com.example.flxvay.OperationRetrofitApi.ApiInterface;
import com.example.flxvay.OperationRetrofitApi.users;
import com.example.flxvay.Sessions.SessionManger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    ImageView back_arrow;
    LinearLayout signin_text_for_signup;
    private EditText fullName_et;
    private EditText Email_et;
    EditText Password_et;
    EditText Conform_Password_et;
    Button SignUp_btn;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    public static ApiInterface apiInterface;
    SessionManger sessionManger;
    ProgressBar Blue_progressBar;

    String user_email;
    String user_password;
    String user_FullName;
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        sessionManger = new SessionManger(this);
        init();
        Blue_progressBar.setVisibility(View.GONE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        addTextChangedListener();


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SignUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_email = Email_et.getText().toString();
                user_password = Password_et.getText().toString();
                user_FullName = fullName_et.getText().toString();

                checkEmailANDPassword(user_FullName, user_email, user_password);
            }
        });
        function_signin_text_for_signup();

    }


    private void init() {
        back_arrow = findViewById(R.id.back_arrow);
        signin_text_for_signup = findViewById(R.id.signin_btn_for_signup);
        fullName_et = findViewById(R.id.Name_signup);
        Email_et = findViewById(R.id.Email_signup);
        Password_et = findViewById(R.id.password_signup);
        Conform_Password_et = findViewById(R.id.conform_password_signup);
        SignUp_btn = findViewById(R.id.SignUp_btn);
        Blue_progressBar = findViewById(R.id.Blue_progressBar);
    }

    private void function_signin_text_for_signup() {
        signin_text_for_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_signin_text_for_signup = new Intent(SignupActivity.this, LoginActivity.class);
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
                startActivity(goto_signin_text_for_signup);
                finish();
            }
        });
    }

    private void addTextChangedListener() {
        fullName_et.addTextChangedListener(new TextWatcher() {
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
        Email_et.addTextChangedListener(new TextWatcher() {
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
        Password_et.addTextChangedListener(new TextWatcher() {
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
        Conform_Password_et.addTextChangedListener(new TextWatcher() {
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
        if (!TextUtils.isEmpty(Email_et.getText())) {
            if (!TextUtils.isEmpty(fullName_et.getText())) {
                if (!TextUtils.isEmpty(Password_et.getText()) && Password_et.length() >= 8) {
                    if (!TextUtils.isEmpty(Conform_Password_et.getText())) {
                        SignUp_btn.setEnabled(true);
                        SignUp_btn.setTextColor(Color.rgb(255, 255, 255));
                    } else {
                        SignUp_btn.setEnabled(false);
                        SignUp_btn.setTextColor(Color.argb(50, 255, 255, 255));
                    }
                } else {
                    SignUp_btn.setEnabled(false);
                    SignUp_btn.setTextColor(Color.argb(50, 255, 255, 255));
                }
            } else {
                SignUp_btn.setEnabled(false);
                SignUp_btn.setTextColor(Color.argb(50, 255, 255, 255));
            }
        } else {
            SignUp_btn.setEnabled(false);
            SignUp_btn.setTextColor(Color.argb(50, 255, 255, 255));
        }
    }

    private void checkEmailANDPassword(String user_FullName, String user_email, String user_password) {
        if (Email_et.getText().toString().matches(emailPattern)) {
            if (Password_et.getText().toString().equals(Conform_Password_et.getText().toString())) {
                SignUp_btn.setEnabled(false);
                SignUp_btn.setTextColor(Color.argb(50, 255, 255, 255));
                Blue_progressBar.setVisibility(View.VISIBLE);


                Call<users> call = apiInterface.performEmailRegistration(user_FullName, user_email, user_password);
                call.enqueue(new Callback<users>() {
                    @Override
                    public void onResponse(Call<users> call, Response<users> response) {
                        if (response.body().getResponse().equals("ok")) {
                            user_id =response.body().getUserid();
                            sessionManger.createSession(user_id);
                            Blue_progressBar.setVisibility(View.GONE);

                            Intent mainActivityIntent = new Intent(SignupActivity.this, MainActivity.class);
                            startActivity(mainActivityIntent);
                            finish();
                            Toast.makeText(SignupActivity.this, "Account created successfully.", Toast.LENGTH_SHORT).show();

                        } else if (response.body().getResponse().equals("failed")) {
                            SignUp_btn.setEnabled(true);
                            SignUp_btn.setTextColor(Color.rgb( 255, 255, 255));
                            Blue_progressBar.setVisibility(View.GONE);


                            Toast.makeText(SignupActivity.this, "Something went wrong, Please try again!.", Toast.LENGTH_SHORT).show();
                        } else if (response.body().getResponse().equals("already")) {
                            SignUp_btn.setEnabled(true);
                            SignUp_btn.setTextColor(Color.rgb( 255, 255, 255));
                            Blue_progressBar.setVisibility(View.GONE);

                            Toast.makeText(SignupActivity.this, "This email id is already exists, Please try another", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<users> call, Throwable t) {

                        SignUp_btn.setEnabled(true);
                        SignUp_btn.setTextColor(Color.rgb( 255, 255, 255));
                        Blue_progressBar.setVisibility(View.GONE);

                        Toast.makeText(SignupActivity.this, "on failure", Toast.LENGTH_SHORT).show();

                    }
                });
            } else {
                Conform_Password_et.setError("Password doesn't matched!");
            }
        } else {
            Email_et.setError("Invalid Email!");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}