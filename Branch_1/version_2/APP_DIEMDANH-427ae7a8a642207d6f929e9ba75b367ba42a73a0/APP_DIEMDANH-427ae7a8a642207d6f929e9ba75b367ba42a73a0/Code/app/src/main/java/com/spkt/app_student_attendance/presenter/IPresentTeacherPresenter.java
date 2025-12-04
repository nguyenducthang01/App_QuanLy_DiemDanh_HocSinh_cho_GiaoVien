package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.IAttendenceTeacherView;
import com.spkt.app_student_attendance.view.IPresentTeacherView;
import com.spkt.app_student_attendance.view.IPresentTimeTeacherView;

public interface IPresentTeacherPresenter {
    void doLoadListClass(String id, IPresentTeacherView context);
    void doLoadListTime(String id, String date_time, String hour_star_for_class ,IPresentTimeTeacherView context);
}
