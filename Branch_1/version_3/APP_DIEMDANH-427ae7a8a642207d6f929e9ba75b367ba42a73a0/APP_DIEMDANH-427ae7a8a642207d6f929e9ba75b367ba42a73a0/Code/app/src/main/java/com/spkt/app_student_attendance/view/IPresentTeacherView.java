package com.spkt.app_student_attendance.view;

import com.spkt.app_student_attendance.model.ClassModel;

import java.util.ArrayList;

public interface IPresentTeacherView {
    void onListClassResult(ArrayList<ClassModel> List_Class);
}
