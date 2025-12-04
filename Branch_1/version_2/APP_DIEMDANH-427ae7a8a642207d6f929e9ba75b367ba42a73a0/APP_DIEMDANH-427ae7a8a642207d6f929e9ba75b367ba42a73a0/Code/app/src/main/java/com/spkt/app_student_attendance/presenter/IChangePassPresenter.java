package com.spkt.app_student_attendance.presenter;

import android.content.Context;
import android.widget.EditText;

import com.spkt.app_student_attendance.view.IChangePassView;

public interface IChangePassPresenter {
    void OnCheckUser(EditText username, Context context);
    void checkpass(String password, IChangePassView iChangePassView);
    void changePassword(String username, String newPassword);
    void responseChangePassword(String message);
}
