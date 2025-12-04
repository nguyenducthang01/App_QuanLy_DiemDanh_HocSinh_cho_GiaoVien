package com.spkt.app_student_attendance.model;

import android.content.Context;

import com.spkt.app_student_attendance.view.ILoginView;
import com.spkt.app_student_attendance.view.IProfileStudentView;

public interface IUserModel {
        String getUsername();
        String getPassword();
        Boolean getResults();
        void checkUserValidity(ILoginView context);


}
