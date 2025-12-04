package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.ITScheduleTeacherView;

public interface ITScheduleTeacherPresenter {
    void doLoadListSchedule(String id, ITScheduleTeacherView context);
}
