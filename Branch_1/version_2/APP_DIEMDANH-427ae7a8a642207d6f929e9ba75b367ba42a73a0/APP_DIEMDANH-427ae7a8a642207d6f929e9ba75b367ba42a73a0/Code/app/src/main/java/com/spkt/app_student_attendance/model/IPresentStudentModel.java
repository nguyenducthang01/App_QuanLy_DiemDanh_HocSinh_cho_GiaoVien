package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.IPresentTimeStudentView;

public interface IPresentStudentModel {
    String getClass_id();
    String getStudent_id();
    String getAttendancetime();
    void GetAttendanceForClassStudentChoose(IPresentTimeStudentView context);
}
