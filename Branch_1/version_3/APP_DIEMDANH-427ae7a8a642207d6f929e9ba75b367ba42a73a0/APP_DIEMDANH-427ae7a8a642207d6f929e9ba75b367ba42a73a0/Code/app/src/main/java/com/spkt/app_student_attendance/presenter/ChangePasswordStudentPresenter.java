package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.spkt.app_student_attendance.ChangePasswordStudentActivity;
import com.spkt.app_student_attendance.model.ChangePasswordStudentModel;
import com.spkt.app_student_attendance.model.IChangePasswordStudentModel;
import com.spkt.app_student_attendance.view.IChangePasswordStudentView;

public class ChangePasswordStudentPresenter extends AppCompatActivity implements IChangePasswordStudentPresenter {
    IChangePasswordStudentModel iChangePasswordStudentModel;
    IChangePasswordStudentView iChangePasswordStudentView;
    Handler handler;

    public ChangePasswordStudentPresenter(IChangePasswordStudentView iChangePasswordStudentView) {
        this.iChangePasswordStudentView = iChangePasswordStudentView;
        handler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void checkChangePass(String id_student, String old_password, String new_password, IChangePasswordStudentView iChangePasswordStudentView) {
        iChangePasswordStudentModel = new ChangePasswordStudentModel(id_student, old_password, new_password, iChangePasswordStudentView);
        iChangePasswordStudentModel.Changepasswordstudent(id_student, old_password, new_password, iChangePasswordStudentView);
    }

}
