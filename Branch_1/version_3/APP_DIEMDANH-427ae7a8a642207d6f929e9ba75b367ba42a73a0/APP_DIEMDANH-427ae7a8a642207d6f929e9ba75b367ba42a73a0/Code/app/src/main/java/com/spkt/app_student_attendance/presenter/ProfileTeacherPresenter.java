package com.spkt.app_student_attendance.presenter;

import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.spkt.app_student_attendance.TeacherActivity;
import com.spkt.app_student_attendance.model.IProfileTeacherModel;
import com.spkt.app_student_attendance.model.ProfileTeacherModel;
import com.spkt.app_student_attendance.view.IProfileTeacherView;

public class ProfileTeacherPresenter extends AppCompatActivity implements IProfileTeacherPresenter{
    IProfileTeacherModel iProfileTeacherModel;
    IProfileTeacherView iProfileTeacherView;
    Handler handler;

    public ProfileTeacherPresenter(IProfileTeacherView iProfileTeacherView) {
        this.iProfileTeacherView = iProfileTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void getIDTeacher(String ID, IProfileTeacherView iProfileTeacherView) {
        iProfileTeacherModel = new ProfileTeacherModel(ID,iProfileTeacherView);
        iProfileTeacherModel.checkInforValidity(ID, iProfileTeacherView);
    }

    public void checkUpdate (String teacher_id, String teacher_name,String teacher_birth,String teacher_gender,String teacher_mail,String teacher_phone, String teacher_image, IProfileTeacherView iProfileTeacherView)
    {
        iProfileTeacherModel = new ProfileTeacherModel(teacher_id, teacher_name, teacher_birth, teacher_gender, teacher_mail, teacher_phone,teacher_image, iProfileTeacherView);
        iProfileTeacherModel.updateInforTeacher(teacher_id, teacher_name, teacher_birth, teacher_gender, teacher_mail, teacher_phone,teacher_image, iProfileTeacherView);
    }

    @Override
    public void getIDMainTeacher(String id_teacher, TeacherActivity teacherActivity) {
        iProfileTeacherModel = new ProfileTeacherModel(id_teacher,iProfileTeacherView);
        iProfileTeacherModel.checkInforValidityMain(id_teacher, iProfileTeacherView);
    }
}
