package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.IAbsentTeacherView;
import com.spkt.app_student_attendance.view.IPresentTeacherView;
import com.spkt.app_student_attendance.view.IAttendenceTeacherView;
import com.spkt.app_student_attendance.view.ISClassListView;
import com.spkt.app_student_attendance.view.IPresentStudentView;
import com.spkt.app_student_attendance.view.ITClassListView;

public interface IClassModel {
    String getClass_id();

    String getClass_name();

    String getClass_idteacher();

    String getClass_time();

    void getDataClassForIDTeacher(String id, IPresentTeacherView context);
    void getDataClassForIDTeacher(String id, IAbsentTeacherView context);
    int getClass_Totalstudent();

    void getDataClassForIDTeacher(String id,IAttendenceTeacherView context);
    void getDataClassForIDTeacher2(String id, ITClassListView context);
    void getDataClassForIDStudent(String id, ISClassListView context);
    void getDataClassForIDStudent(String id, IPresentStudentView context);
}
