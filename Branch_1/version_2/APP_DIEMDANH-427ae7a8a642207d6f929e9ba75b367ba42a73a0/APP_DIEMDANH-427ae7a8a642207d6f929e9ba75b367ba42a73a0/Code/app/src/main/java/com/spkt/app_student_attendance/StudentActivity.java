package com.spkt.app_student_attendance;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.spkt.app_student_attendance.presenter.IProfileStudentPresenter;
import com.spkt.app_student_attendance.presenter.ProfileStudentPresenter;
import com.spkt.app_student_attendance.view.IProfileStudentView;
import com.squareup.picasso.Picasso;

public class StudentActivity extends AppCompatActivity implements IProfileStudentView, View.OnClickListener {
    private Button btn_attendence_student, btn_information_student, btn_present_student, btn_schedule_student, btn_classlist_student, btn_studentlist_student, btn_about;
    private ImageView img_logout_student, img_avatar_main_student;
    private TextView fullname_main_student, numberId_main_student;
    private String id_student;
    private IProfileStudentPresenter profileStudentPresenter = new ProfileStudentPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_student);
        mapping();
        Intent intent_student = getIntent();
        id_student = intent_student.getStringExtra("ID_STUDENT");
        profileStudentPresenter.getIDMainStudent(id_student, this);
        img_logout_student.setOnClickListener(this);
        btn_attendence_student.setOnClickListener(this);
        btn_information_student.setOnClickListener(this);
        btn_present_student.setOnClickListener(this);
        btn_schedule_student.setOnClickListener(this);
        btn_classlist_student.setOnClickListener(this);
        btn_studentlist_student.setOnClickListener(this);
        btn_about.setOnClickListener(this);
    }

    public void mapping() {
        img_logout_student = (ImageView) findViewById(R.id.img_logout);
        btn_attendence_student = (Button) findViewById(R.id.btn_attendence_student);
        btn_information_student = (Button) findViewById(R.id.btn_information_teacher);
        btn_present_student = (Button) findViewById(R.id.btn_present_student);
        btn_schedule_student = (Button) findViewById(R.id.btn_schedule_student);
        btn_classlist_student = (Button) findViewById(R.id.btn_classlist_student);
        btn_studentlist_student = (Button) findViewById(R.id.btn_studentlist_student);
        img_avatar_main_student = (ImageView) findViewById(R.id.img_avatar_main_teacher);
        fullname_main_student = (TextView) findViewById(R.id.fullnam_main_teacher);
        numberId_main_student = (TextView) findViewById(R.id.Number_ID_main_teacher);
        btn_about = (Button) findViewById(R.id.btn_about);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_attendence_student:
                Intent studentattendance = new Intent(this, AttendenceStudentActivity.class);
                studentattendance.putExtra("ID_STUDENT", id_student);  // Truyền ID_TEACHER
                startActivity(studentattendance);
                break;
            case R.id.btn_information_teacher:
                Intent student = new Intent(this, ProfileStudentActivity.class);
                student.putExtra("ID_STUDENT", id_student);  // Truyền ID_STUDENT
                startActivity(student);
                break;
            case R.id.btn_present_student:
                Intent studentpresent = new Intent(this, PresentStudentActivity.class);
                studentpresent.putExtra("ID_STUDENT", id_student);  // Truyền ID_STUDENT
                startActivity(studentpresent);
                break;
            case R.id.btn_schedule_student:
                Intent studentschedule = new Intent(this, StudentScheduleActivity.class);
                studentschedule.putExtra("ID_STUDENT", id_student);   // Truyền ID_STUDENT
                startActivity(studentschedule);
                break;
            case R.id.btn_classlist_student:
                Intent studentclasslist = new Intent(this, SClassListActivity.class);
                studentclasslist.putExtra("ID_STUDENT", id_student);  // Truyền ID_STUDENT
                startActivity(studentclasslist);
                break;
            case R.id.btn_studentlist_student:
                Intent studentlist = new Intent(this, StudentListActivity.class);
                studentlist.putExtra("ID_STUDENT", id_student);   // Truyền ID_STUDENT
                startActivity(studentlist);
                break;
            case R.id.img_logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(StudentActivity.this);
                builder.setTitle("LOGOUT ACCOUNT").
                        setMessage("You sure, that you want to logout?");
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                        });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
                break;
            case R.id.btn_about:
                Intent about = new Intent(this, AboutActivity.class);
                about.putExtra("ID_STUDENT", id_student);   // Truyền ID_STUDENT
                startActivity(about);
        }
    }

    @Override
    public void showInforStudent(String student_id, String student_name, String student_birth, String student_gender, String student_mail, String student_phone, String student_hinhanh) {

    }

    @Override
    public void updateSuccessfully(int result) {

    }

    @Override
    public void showInforStudentMain(String student_id, String student_name, String student_image) {
        numberId_main_student.setText(student_id);
        fullname_main_student.setText(student_name);
        Picasso.get().load(student_image).into(img_avatar_main_student);
    }
}
