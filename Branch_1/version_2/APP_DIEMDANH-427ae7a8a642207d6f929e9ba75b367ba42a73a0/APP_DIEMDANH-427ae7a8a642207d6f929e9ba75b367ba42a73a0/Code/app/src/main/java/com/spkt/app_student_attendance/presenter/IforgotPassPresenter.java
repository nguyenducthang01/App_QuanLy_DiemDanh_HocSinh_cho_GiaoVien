package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.IForgotPassView;

public interface IforgotPassPresenter {
    void checkUsername(String username, IForgotPassView iForgotPassView);
}
