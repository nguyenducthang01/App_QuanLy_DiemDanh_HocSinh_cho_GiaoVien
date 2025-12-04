package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import com.spkt.app_student_attendance.model.IScheduleModel;
import com.spkt.app_student_attendance.model.ScheduleModel;
import com.spkt.app_student_attendance.view.IScheduleStudentView;
import com.spkt.app_student_attendance.view.ITScheduleTeacherView;

public class TScheduleTeacherPresenter implements ITScheduleTeacherPresenter {
    IScheduleModel iSchedule;
    ITScheduleTeacherView itScheduleTeacherView;
    Handler handler;

    public TScheduleTeacherPresenter(ITScheduleTeacherView itScheduleTeacherView) {
        this.itScheduleTeacherView = itScheduleTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void doLoadListSchedule(String id, ITScheduleTeacherView context) {
        iSchedule = new ScheduleModel(id, context);
        iSchedule.getDataScheduleForStudent(id, context);
    }
}
