package com.spkt.app_student_attendance.presenter;


import com.spkt.app_student_attendance.view.ITClassListView;

public interface ITClassListPresenter {
    void doLoadListTeacher(String id, ITClassListView context);
}
