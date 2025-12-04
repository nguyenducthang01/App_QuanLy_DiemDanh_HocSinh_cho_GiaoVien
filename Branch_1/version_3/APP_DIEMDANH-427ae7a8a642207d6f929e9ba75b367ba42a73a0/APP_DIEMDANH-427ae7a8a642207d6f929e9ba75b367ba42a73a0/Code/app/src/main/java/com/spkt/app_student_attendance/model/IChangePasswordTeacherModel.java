package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.IChangePasswordTeacherView;

public interface IChangePasswordTeacherModel {
    void Changepasswordteacher(String id_teacher, String old_password, String new_password, IChangePasswordTeacherView iChangePasswordTeacherView);
}
