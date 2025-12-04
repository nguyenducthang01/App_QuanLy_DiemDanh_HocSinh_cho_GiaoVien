package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.IChangePasswordTeacherView;

public interface IChangePasswordTeacherPresenter {
    void checkChangePass(String id_teacher, String old_password, String new_password, IChangePasswordTeacherView iChangePasswordTeacherView);
}
