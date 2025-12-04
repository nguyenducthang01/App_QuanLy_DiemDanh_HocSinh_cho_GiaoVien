package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.spkt.app_student_attendance.model.ClassModel;
import com.spkt.app_student_attendance.model.IClassModel;
import com.spkt.app_student_attendance.view.IAttendenceTeacherView;

public class AttendenceTeacherPresenter extends AppCompatActivity implements IAttendenceTeacherPresenter {
    IClassModel iClass;
    IAttendenceTeacherView iAttendenceTeacherView;
    Handler handler;

    public AttendenceTeacherPresenter(IAttendenceTeacherView iAttendenceTeacherView) {
        this.iAttendenceTeacherView = iAttendenceTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void doLoadListClass(String id, IAttendenceTeacherView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDTeacher(id, context);
    }
}
