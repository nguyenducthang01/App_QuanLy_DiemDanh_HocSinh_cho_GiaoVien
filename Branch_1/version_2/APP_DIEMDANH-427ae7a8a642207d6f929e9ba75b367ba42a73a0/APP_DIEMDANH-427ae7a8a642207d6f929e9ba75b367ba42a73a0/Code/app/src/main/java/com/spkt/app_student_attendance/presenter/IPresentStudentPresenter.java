package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.IAttendenceTeacherView;
import com.spkt.app_student_attendance.view.IPresentStudentView;
import com.spkt.app_student_attendance.view.IPresentTimeStudentView;

public interface IPresentStudentPresenter {
    void doLoadListClass(String id, IPresentStudentView context);
    void doLoadtimepresent(String class_id, String student_id, IPresentTimeStudentView context);
}
