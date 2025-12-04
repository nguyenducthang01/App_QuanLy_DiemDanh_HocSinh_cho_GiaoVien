package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;
import com.spkt.app_student_attendance.model.IStudentModel;
import com.spkt.app_student_attendance.model.StudentModel;
import com.spkt.app_student_attendance.view.ISClassListDetailView;

public class SClassListDetailPresenter implements  ISClassListDetailPresenter{
    IStudentModel iStudent;
    ISClassListDetailView iSClassListDetailView;
    Handler handler;

    public SClassListDetailPresenter(ISClassListDetailView iSClassListDetailView) {
        this.iSClassListDetailView = iSClassListDetailView;
        handler = new Handler(Looper.getMainLooper());
    }



    @Override
    public void doLoadListStudent(String id, ISClassListDetailView context) {
        iStudent = new StudentModel(id, context);
        iStudent.getDataStudentForIDClass(id, context);
    }
}
