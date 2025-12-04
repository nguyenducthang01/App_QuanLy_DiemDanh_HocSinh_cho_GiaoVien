package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.IStudentListView;

public interface IStudentListPresenter {
    void doLoadListStudent(String id, IStudentListView context);
}
