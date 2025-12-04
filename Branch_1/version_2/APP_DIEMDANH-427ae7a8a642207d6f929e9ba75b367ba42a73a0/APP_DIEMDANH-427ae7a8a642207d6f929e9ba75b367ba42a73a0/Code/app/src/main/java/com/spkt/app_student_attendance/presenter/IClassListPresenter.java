package com.spkt.app_student_attendance.presenter;

import com.spkt.app_student_attendance.view.ISClassListView;

public interface IClassListPresenter {
    void doLoadListClass(String id, ISClassListView context);

}
