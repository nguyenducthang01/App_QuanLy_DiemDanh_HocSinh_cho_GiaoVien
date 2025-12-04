package com.spkt.app_student_attendance.presenter;

import android.content.Context;
import android.widget.EditText;

import com.spkt.app_student_attendance.view.ILoginView;

public interface ILoginPresenter {
        void doLogin(String user, String password, ILoginView context);

}
