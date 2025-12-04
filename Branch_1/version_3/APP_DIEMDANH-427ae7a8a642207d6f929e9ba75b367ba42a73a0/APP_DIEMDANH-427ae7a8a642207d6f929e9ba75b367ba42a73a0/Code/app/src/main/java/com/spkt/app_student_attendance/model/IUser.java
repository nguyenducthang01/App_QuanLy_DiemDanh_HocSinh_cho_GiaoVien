package com.spkt.app_student_attendance.model;

import android.content.Context;

import com.spkt.app_student_attendance.view.ILoginView;

public interface IUser {
        String getUsername();
        String getPassword();
        Boolean getResults();
        void checkUserValidity(ILoginView context);
        void getdata(Context context);
}
