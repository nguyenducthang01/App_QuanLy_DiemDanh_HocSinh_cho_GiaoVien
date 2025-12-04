package com.spkt.app_student_attendance.adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.spkt.app_student_attendance.R;
import com.spkt.app_student_attendance.model.ClassModel;
import com.spkt.app_student_attendance.model.IPresentStudentModel;
import com.spkt.app_student_attendance.model.PresentStudentModel;

import java.util.ArrayList;
public class TimePresentAdapterForStudentActivity extends BaseAdapter {
    // Dữ liệu
    final ArrayList<PresentStudentModel> ListTimePresent;

    public TimePresentAdapterForStudentActivity(ArrayList<PresentStudentModel> LissTimePresent) {
        this.ListTimePresent = LissTimePresent;
    }

    @Override
    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView
        return ListTimePresent.size();
    }

    @Override
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        return ListTimePresent.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Trả về một ID của phần
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
        //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
        //Nếu null cần tạo mới
        View viewClass;
        if (convertView == null) {
            viewClass = View.inflate(parent.getContext(), R.layout.layoutcustom_presentstudent, null);
        } else viewClass = convertView;
        PresentStudentModel Time_list = (PresentStudentModel) getItem(position);
        ((TextView) viewClass.findViewById(R.id.txttime_attendancestudent)).setText(String.format(Time_list.getAttendancetime()));
        return viewClass;
    }
}
