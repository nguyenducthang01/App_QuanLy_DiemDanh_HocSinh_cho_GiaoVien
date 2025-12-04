package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.IPresentTimeTeacherView;

public interface IPresentTeacherModel {
    String getStudent_id();
    String getStudent_name();
    String getAttendancetime();
    String getStatusAttendance();
    void GetAttendanceForClasstTeacherChoose(IPresentTimeTeacherView context);
}
