package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.IAttendanceStudentView;

public interface IAttendanceStudentPresenter {
    void AddAttendanceStudentPresenter(String class_id, String student_id, String attendance_time, String status, IAttendanceStudentView AttendanceStudentView);
}
