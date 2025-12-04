package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.IChangePasswordStudentView;

public interface IChangePasswordStudentModel {
    void Changepasswordstudent(String id_student, String old_password, String new_password, IChangePasswordStudentView iChangePasswordStudentView);
}
