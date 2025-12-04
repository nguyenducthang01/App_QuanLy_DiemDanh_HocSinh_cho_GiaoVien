package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import com.spkt.app_student_attendance.model.ClassModel;
import com.spkt.app_student_attendance.model.IClassModel;
import com.spkt.app_student_attendance.view.ISClassListView;


public class ClassListPresenter implements IClassListPresenter{
    IClassModel iClass;
    ISClassListView iClassListView;
    Handler handler;

    public ClassListPresenter(ISClassListView iClassListView) {
        this.iClassListView = iClassListView;
        handler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void doLoadListClass(String id, ISClassListView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDStudent(id, context);
    }
}
