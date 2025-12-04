package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.ISClassListDetailView;
import com.spkt.app_student_attendance.view.IStudentListView;
import com.spkt.app_student_attendance.view.ITClassListDetailView;

public interface IStudentModel {
    void getDataStudentForIDClass(String id, ISClassListDetailView context);
    void getDataStudentForIDClass(String id, ITClassListDetailView context);
    void getDataStudentForIDStudent(String id, IStudentListView context);
}
