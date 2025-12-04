package com.spkt.app_student_attendance.presenter;

import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.spkt.app_student_attendance.model.ProfileStudentModel;
import com.spkt.app_student_attendance.model.IProfileStudentModel;
import com.spkt.app_student_attendance.view.IProfileStudentView;

import android.os.Handler;



public class ProfileStudentPresenter extends AppCompatActivity implements IProfileStudentPresenter {
    IProfileStudentModel iProfileStudentModel;
    IProfileStudentView iProfileStudentView;
    Handler handler;

    public ProfileStudentPresenter(IProfileStudentView iProfileStudentView) {
        this.iProfileStudentView = iProfileStudentView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void getIDStudent(String ID, IProfileStudentView iProfileStudentView) {
        iProfileStudentModel = new ProfileStudentModel(ID,iProfileStudentView);
        iProfileStudentModel.checkInforValidity(ID, iProfileStudentView);
    }
    @Override
    public void getIDMainStudent(String ID, IProfileStudentView iProfileStudentView) {
        iProfileStudentModel = new ProfileStudentModel(ID,iProfileStudentView);
        iProfileStudentModel.checkInforValidityMain(ID, iProfileStudentView);
    }

    public void checkUpdate (String student_id, String student_name,String student_birth,String student_gender,String student_mail,String student_phone, String hinhanh, IProfileStudentView iProfileStudentView)
    {
        iProfileStudentModel = new ProfileStudentModel(student_id, student_name, student_birth, student_gender, student_mail, student_phone, hinhanh, iProfileStudentView);
        iProfileStudentModel.updateInforStudent(student_id, student_name, student_birth, student_gender, student_mail, student_phone, hinhanh, iProfileStudentView);
    }


}
