package com.spkt.app_student_attendance.model;

import com.spkt.app_student_attendance.view.IAttendenceTeacherView;

public interface IClass {
    String getClass_id();

    String getClass_name();

    String getClass_idteacher();

    int getClass_Totalstudent();

    void getDataClassForID(String id,IAttendenceTeacherView context);
}
