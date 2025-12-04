package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import com.spkt.app_student_attendance.model.ClassModel;
import com.spkt.app_student_attendance.model.IClassModel;
import com.spkt.app_student_attendance.model.IPresentTeacherModel;
import com.spkt.app_student_attendance.model.PresentTeacherModel;
import com.spkt.app_student_attendance.view.IAttendenceTeacherView;
import com.spkt.app_student_attendance.view.IPresentTeacherView;
import com.spkt.app_student_attendance.view.IPresentTimeTeacherView;

public class PresentTeacherPresenter implements IPresentTeacherPresenter {
    IClassModel iClass;
    IPresentTeacherView iPresentTeacherView;
    Handler handler;

    IPresentTeacherModel iPresentTeacherModel;
    IPresentTimeTeacherView iPresentTimeTeacherView;

    public PresentTeacherPresenter(IPresentTeacherView iPresentTeacherView) {
        this.iPresentTeacherView = iPresentTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void doLoadListClass(String id, IPresentTeacherView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDTeacher(id, context);
    }

    public PresentTeacherPresenter(IPresentTimeTeacherView iPresentTimeTeacherView) {
        this.iPresentTimeTeacherView = iPresentTimeTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void doLoadListTime(String id, String date_time, String hour_star_for_class, IPresentTimeTeacherView context) {
        iPresentTeacherModel = new PresentTeacherModel(id,date_time,hour_star_for_class ,context);
        iPresentTeacherModel.GetAttendanceForClasstTeacherChoose(context);
    }
}
