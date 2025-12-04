package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.ISClassListDetailView;

public interface ISClassListDetailPresenter {
    void doLoadListStudent(String id, ISClassListDetailView context);
}
