package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.ChangePasswordStudentActivity;
import com.spkt.app_student_attendance.view.IChangePasswordStudentView;

public interface IChangePasswordStudentPresenter {
    void checkChangePass(String id_student, String old_password, String new_password, IChangePasswordStudentView iChangePasswordStudentView);
}
