package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.IAttendanceStudentView;

public interface IAttendanceStudentModel {
    String getClass_id();
    String getStudent_id();
    String getAttendance_time();
    String getStatus();
    void AddAttendanceStudentModel(IAttendanceStudentView iAttendanceStudentView);
}
