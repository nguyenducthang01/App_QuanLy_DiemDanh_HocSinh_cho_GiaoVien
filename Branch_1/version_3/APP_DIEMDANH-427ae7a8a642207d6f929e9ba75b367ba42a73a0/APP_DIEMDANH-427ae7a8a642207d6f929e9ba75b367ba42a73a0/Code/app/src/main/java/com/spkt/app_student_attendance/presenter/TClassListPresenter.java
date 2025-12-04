package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import com.spkt.app_student_attendance.model.ClassModel;
import com.spkt.app_student_attendance.model.IClassModel;
import com.spkt.app_student_attendance.view.ISClassListView;
import com.spkt.app_student_attendance.view.ITClassListView;

public class TClassListPresenter implements ITClassListPresenter{
    IClassModel iClass;
    ITClassListView itClassListView;
    Handler handler;

    public TClassListPresenter(ITClassListView itClassListView) {
        this.itClassListView = itClassListView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListTeacher(String id, ITClassListView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDTeacher2(id, context);
    }
}
