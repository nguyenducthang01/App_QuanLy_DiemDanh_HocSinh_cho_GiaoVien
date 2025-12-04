package com.spkt.app_student_attendance.presenter;
import android.os.Handler;
import android.os.Looper;

import com.spkt.app_student_attendance.model.AbsentTeacherModel;
import com.spkt.app_student_attendance.model.ClassModel;
import com.spkt.app_student_attendance.model.IAbsentTeacherModel;
import com.spkt.app_student_attendance.model.IClassModel;
import com.spkt.app_student_attendance.model.PresentTeacherModel;
import com.spkt.app_student_attendance.view.IAbsentTeacherView;
import com.spkt.app_student_attendance.view.IAbsentTimeTeacherView;
import com.spkt.app_student_attendance.view.IPresentTeacherView;

import java.util.ArrayList;

public class AbsentTeacherPresenter implements IAbsentTeacherPresenter {
    IClassModel iClass;
    IAbsentTeacherView iAbsentTeacherView;
    IAbsentTimeTeacherView iAbsentTimeTeacherView;
    IAbsentTeacherModel iAbsentTeacherModel;
    Handler handler;
    public AbsentTeacherPresenter(IAbsentTeacherView iAbsentTeacherView) {
        this.iAbsentTeacherView = iAbsentTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListClass(String id, IAbsentTeacherView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDTeacher(id, context);
    }
    public AbsentTeacherPresenter(IAbsentTimeTeacherView iAbsentTimeTeacherView) {
        this.iAbsentTimeTeacherView = iAbsentTimeTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void doLoadListStudent(String id, String date_time, IAbsentTimeTeacherView context) {
        iAbsentTeacherModel = new AbsentTeacherModel(id,date_time,context);
        iAbsentTeacherModel.GetAbsentForClasstTeacherChoose(context);
    }
}
