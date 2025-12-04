package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import com.spkt.app_student_attendance.model.ClassModel;
import com.spkt.app_student_attendance.model.IClassModel;
import com.spkt.app_student_attendance.model.IPresentStudentModel;
import com.spkt.app_student_attendance.model.PresentStudentModel;
import com.spkt.app_student_attendance.view.IPresentStudentView;
import com.spkt.app_student_attendance.view.IPresentTimeStudentView;

public class PresentStudentPresenter implements IPresentStudentPresenter {
    IClassModel iClass;
    IPresentStudentModel iPresentStudentModel;
    IPresentStudentView iPresentStudentView;
    IPresentTimeStudentView iPresentTimeStudentView;
    Handler handler;

    public PresentStudentPresenter(IPresentStudentView iPresentStudentView) {
        this.iPresentStudentView = iPresentStudentView;
        handler = new Handler(Looper.getMainLooper());
    }

    public PresentStudentPresenter(IPresentTimeStudentView iPresentTimeStudentView) {
        this.iPresentTimeStudentView = iPresentTimeStudentView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListClass(String id, IPresentStudentView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDStudent(id, context);
    }

    @Override
    public void doLoadtimepresent(String class_id, String student_id, IPresentTimeStudentView context) {
        iPresentStudentModel = new PresentStudentModel(class_id, student_id, context);
        iPresentStudentModel.GetAttendanceForClassStudentChoose(context);
    }
}
