package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import com.spkt.app_student_attendance.model.IStudentModel;

import com.spkt.app_student_attendance.model.StudentModel;
import com.spkt.app_student_attendance.view.IStudentListView;

public class StudentListPresenter implements IStudentListPresenter {
    IStudentModel iStudent;
    IStudentListView iStudentListView;
    Handler handler;

    public StudentListPresenter(IStudentListView iStudentListView) {
        this.iStudentListView = iStudentListView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void doLoadListStudent(String id, IStudentListView context) {
        iStudent = new StudentModel(id, context);
        iStudent.getDataStudentForIDStudent(id, context);
    }
}
