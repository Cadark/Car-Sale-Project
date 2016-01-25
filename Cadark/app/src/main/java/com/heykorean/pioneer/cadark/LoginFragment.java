package com.heykorean.pioneer.cadark;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.heykorean.pioneer.cadark.retrofit_api.Curator;
import com.heykorean.pioneer.cadark.retrofit_api.Retrofit_Interface;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Android on 1/22/2016.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

    public static final String API_URL = "http://ap.heykorean.com";
    private static final String API_KEY = "";

    EditText emailInput, passwordEdt;
    CheckBox checkRememberPass;
    TextView forgotPassTv;
    Button loginBtn;
    ImageView fbImg, twitterImg, gpusImg;

    private String userNameLogin = "";
    private String passLogin = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_fragment_layout, container, false);

        emailInput = (EditText) v.findViewById(R.id.emailEdt);
        passwordEdt = (EditText) v.findViewById(R.id.passwordEdt);
        checkRememberPass = (CheckBox) v.findViewById(R.id.checkRemindPass);
        forgotPassTv = (TextView) v.findViewById(R.id.forgetPassTv);
        loginBtn = (Button) v.findViewById(R.id.loginBtn);
        fbImg = (ImageView) v.findViewById(R.id.loginFb);
        twitterImg = (ImageView) v.findViewById(R.id.loginTwitter);
        gpusImg = (ImageView) v.findViewById(R.id.loginGplus);

        SetLineColorEdittext mailSet = new SetLineColorEdittext(emailInput, MainActivity.colorLineEdt);
        SetLineColorEdittext passSet = new SetLineColorEdittext(passwordEdt, MainActivity.colorLineEdt);

        loginBtn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginBtn) {
            //login in there
            userNameLogin = emailInput.getText().toString();
            passLogin = passwordEdt.getText().toString();

            if (userNameLogin.equals("") || passLogin.equals("")) {
                Toast.makeText(getActivity(), "Input null", Toast.LENGTH_SHORT).show();
            }
            else {
                LoginFunct(userNameLogin, passLogin);
            }
        }
    }

    public void LoginFunct(String username, String password) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
        Retrofit_Interface methods = restAdapter.create(Retrofit_Interface.class);
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                Curator curators = (Curator) o;
                Toast.makeText(getActivity(), "Login Success: " + curators.RESULT.toString()
                        + ", " + curators.sessionid.toString() + ", " + curators.userkey.toString(), Toast.LENGTH_SHORT).show();
                Log.d("SHOW_ME", curators.RESULT + ", " + curators.sessionid + ", " + curators.userkey);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
            }
        };

        methods.getCurators1(API_KEY, callback);
    }
}
