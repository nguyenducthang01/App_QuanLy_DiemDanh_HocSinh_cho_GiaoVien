package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import com.spkt.app_student_attendance.model.IScheduleModel;
import com.spkt.app_student_attendance.model.IStudentModel;
import com.spkt.app_student_attendance.model.ScheduleModel;
import com.spkt.app_student_attendance.model.StudentModel;
import com.spkt.app_student_attendance.view.ISClassListDetailView;
import com.spkt.app_student_attendance.view.IScheduleStudentView;

public class ScheduleStudentPresenter implements IScheduleStudentPresenter {

    IScheduleModel iSchedule;
    IScheduleStudentView iScheduleStudentView;
    Handler handler;

    public ScheduleStudentPresenter(IScheduleStudentView iScheduleStudentView) {
        this.iScheduleStudentView = iScheduleStudentView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListSchedule(String id, IScheduleStudentView context) {
        iSchedule = new ScheduleModel(id, context);
        iSchedule.getDataScheduleForStudent(id, context);
    }
}
