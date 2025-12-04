package com.spkt.app_student_attendance.presenter;

import android.app.AppComponentFactory;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.spkt.app_student_attendance.model.ChangePassModel;
import com.spkt.app_student_attendance.model.IChangePassModel;
import com.spkt.app_student_attendance.model.IProfileStudentModel;
import com.spkt.app_student_attendance.view.IChangePassView;
import com.spkt.app_student_attendance.view.IProfileStudentView;

public class ChangePassPresenter extends AppCompatActivity implements IChangePassPresenter{
    IChangePassModel iChangePassModel;
    IChangePassView iChangePassView;

    public ChangePassPresenter(IChangePassView iChangePassView) {
        this.iChangePassView = iChangePassView;
    }

    @Override
    public void OnCheckUser(EditText username, Context context) {
        String user = username.getText().toString().trim();
        if(TextUtils.isEmpty(user))
        {
            username.requestFocus();
            username.setError("Not Blank!!");
            return;
        }

    }

    @Override
    public void checkpass(String password, IChangePassView iChangePassView) {
        iChangePassModel = new ChangePassModel(password, iChangePassView);


    }

    @Override
    public void changePassword(String username, String newPassword) {
        iChangePassModel = new ChangePassModel(newPassword, iChangePassView);
        iChangePassModel.changePass(newPassword,username,iChangePassView);
    }

    @Override
    public void responseChangePassword(String message) {

    }
}
