package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.IAbsentTeacherView;
import com.spkt.app_student_attendance.view.IAbsentTimeTeacherView;
import com.spkt.app_student_attendance.view.IPresentTeacherView;
import com.spkt.app_student_attendance.view.IPresentTimeTeacherView;

public interface IAbsentTeacherPresenter {
    void doLoadListClass(String id, IAbsentTeacherView context);
    void doLoadListStudent(String id, String date_time, IAbsentTimeTeacherView context);
}
