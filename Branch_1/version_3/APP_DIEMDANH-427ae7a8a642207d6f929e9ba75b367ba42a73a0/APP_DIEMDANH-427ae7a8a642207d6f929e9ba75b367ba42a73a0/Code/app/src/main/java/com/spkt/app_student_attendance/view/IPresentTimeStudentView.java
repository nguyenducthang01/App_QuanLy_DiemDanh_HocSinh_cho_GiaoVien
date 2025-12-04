package com.spkt.app_student_attendance.view;

import com.spkt.app_student_attendance.model.ClassModel;
import com.spkt.app_student_attendance.model.PresentStudentModel;

import java.util.ArrayList;

public interface IPresentTimeStudentView {
    void onLisTimeStudentResult(ArrayList<PresentStudentModel> List_Class);
}
