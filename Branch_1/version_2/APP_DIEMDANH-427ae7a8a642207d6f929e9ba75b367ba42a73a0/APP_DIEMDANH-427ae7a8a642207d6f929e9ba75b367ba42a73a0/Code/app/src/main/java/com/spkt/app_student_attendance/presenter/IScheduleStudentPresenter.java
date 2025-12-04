package com.spkt.app_student_attendance.presenter;


import com.spkt.app_student_attendance.view.IScheduleStudentView;

public interface IScheduleStudentPresenter {
    void doLoadListSchedule(String id, IScheduleStudentView context);
}
