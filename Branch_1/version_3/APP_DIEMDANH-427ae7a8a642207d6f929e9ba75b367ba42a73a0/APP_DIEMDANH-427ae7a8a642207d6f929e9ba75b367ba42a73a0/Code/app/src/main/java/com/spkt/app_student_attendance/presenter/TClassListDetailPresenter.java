package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import com.spkt.app_student_attendance.model.IStudentModel;
import com.spkt.app_student_attendance.model.StudentModel;
import com.spkt.app_student_attendance.view.ISClassListDetailView;
import com.spkt.app_student_attendance.view.ITClassListDetailView;

public class TClassListDetailPresenter implements ITClassListDetailPresenter {
    IStudentModel iStudent;
    ITClassListDetailView itClassListDetailView;
    Handler handler;

    public TClassListDetailPresenter(ITClassListDetailView itClassListDetailView) {
        this.itClassListDetailView = itClassListDetailView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void doLoadListStudent(String id, ITClassListDetailView context) {
        iStudent = new StudentModel(id, context);
        iStudent.getDataStudentForIDClass(id, context);
    }
}
