package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.IScheduleStudentView;
import com.spkt.app_student_attendance.view.ITScheduleTeacherView;

public interface IScheduleModel {
    void getDataScheduleForStudent(String id, IScheduleStudentView context);
    void getDataScheduleForStudent(String id, ITScheduleTeacherView context);
}
