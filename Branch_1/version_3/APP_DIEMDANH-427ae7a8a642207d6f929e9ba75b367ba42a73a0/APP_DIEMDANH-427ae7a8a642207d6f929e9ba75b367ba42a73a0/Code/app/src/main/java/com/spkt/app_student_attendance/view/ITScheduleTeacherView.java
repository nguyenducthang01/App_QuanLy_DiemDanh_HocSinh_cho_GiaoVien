package com.spkt.app_student_attendance.view;

import com.spkt.app_student_attendance.model.ScheduleModel;

import java.util.ArrayList;

public interface ITScheduleTeacherView {
    void onListScheduleStudentResult(ArrayList<ScheduleModel> List_Schedule);
}
