package com.spkt.app_student_attendance.view;

import com.spkt.app_student_attendance.model.AbsentTeacherModel;
import com.spkt.app_student_attendance.model.PresentTeacherModel;

import java.util.ArrayList;

public interface IAbsentTimeTeacherView {
    void onLisTimeTeacherResult(ArrayList<AbsentTeacherModel> list_absent);
}
