package com.spkt.app_student_attendance.model;

import android.widget.EditText;

import com.spkt.app_student_attendance.view.IForgotPassView;

public interface IForgotPassModel {
    void checkUser (String username,  IForgotPassView context);

}
