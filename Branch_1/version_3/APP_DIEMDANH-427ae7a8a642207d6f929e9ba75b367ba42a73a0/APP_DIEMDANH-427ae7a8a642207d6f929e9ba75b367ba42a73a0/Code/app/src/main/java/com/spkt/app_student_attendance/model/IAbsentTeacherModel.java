package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.IAbsentTimeTeacherView;
import com.spkt.app_student_attendance.view.IPresentTimeTeacherView;

public interface IAbsentTeacherModel {
    String getStudent_id();
    String getStudent_name();

    void GetAbsentForClasstTeacherChoose(IAbsentTimeTeacherView context);
}
