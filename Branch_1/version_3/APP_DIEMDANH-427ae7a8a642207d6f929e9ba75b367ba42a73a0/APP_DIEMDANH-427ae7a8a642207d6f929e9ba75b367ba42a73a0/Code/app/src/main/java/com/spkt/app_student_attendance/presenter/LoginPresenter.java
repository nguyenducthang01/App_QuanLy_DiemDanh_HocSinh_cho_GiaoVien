package com.spkt.app_student_attendance.presenter;

import android.os.Looper;

import com.spkt.app_student_attendance.model.IUserModel;
import com.spkt.app_student_attendance.model.UserModelModel;
import com.spkt.app_student_attendance.view.ILoginView;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPresenter extends AppCompatActivity implements ILoginPresenter {
    ILoginView iLoginView;
    IUserModel userlogin;
    Handler handler;
    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        handler = new Handler(Looper.getMainLooper());
    }
    private void initUser(String usern, String pass, ILoginView loginView){
        userlogin = new UserModelModel(usern,pass, loginView);
    }
    @Override
    public void doLogin(String user, String password, ILoginView loginView) {
        initUser(user,password, loginView);
        userlogin.checkUserValidity(loginView);
    }


}
