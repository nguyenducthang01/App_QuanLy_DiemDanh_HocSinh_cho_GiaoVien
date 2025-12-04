package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.ITClassListDetailView;

public interface ITClassListDetailPresenter {
    void doLoadListStudent(String id, ITClassListDetailView context);
}
