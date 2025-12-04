package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.spkt.app_student_attendance.model.ForgotPassModel;
import com.spkt.app_student_attendance.model.IForgotPassModel;
import com.spkt.app_student_attendance.view.IForgotPassView;
import com.spkt.app_student_attendance.view.IProfileStudentView;

public class forgotPassPresenter extends AppCompatActivity implements IforgotPassPresenter{
    IForgotPassView iForgotPassView;
    IForgotPassModel iForgotPassModel;
    Handler handler;

    public forgotPassPresenter(IForgotPassView iForgotPassView) {
        this.iForgotPassView = iForgotPassView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void checkUsername(String username, IForgotPassView iForgotPassView) {
        iForgotPassModel = new ForgotPassModel(username,iForgotPassView);
        iForgotPassModel.checkUser(username, iForgotPassView);
    }
}
