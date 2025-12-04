package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.IChangePassView;
import com.spkt.app_student_attendance.view.IProfileStudentView;

public interface IChangePassModel {
    void changePass(String password, String username, IChangePassView iChangePassView);
}
