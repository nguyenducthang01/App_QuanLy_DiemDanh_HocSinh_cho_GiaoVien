package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.example.myapplication.presenter.AttendanceStudentPresenter;
import com.example.myapplication.presenter.DateTime_Format;
import com.example.myapplication.presenter.IAttendanceStudentPresenter;
import com.example.myapplication.view.IAttendanceStudentView;

import java.util.Calendar;
import java.util.Date;

public class AttendenceStudentActivity extends AppCompatActivity implements IAttendanceStudentView {
    private CodeScanner mCodeScanner;
    PopupWindow popupSucessfull;
    PopupWindow popupError;
    private IAttendanceStudentPresenter iAttendanceStudentPresenter = new AttendanceStudentPresenter(this);
    private String student_id;
    private DateTime_Format dateTime_format = new DateTime_Format();
    private String Class_id_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.acctivity_attendence_student);
//        CodeScannerView scannerView = findViewById(R.id.scanner_view);

//        mCodeScanner = new CodeScanner(this, scannerView);
        //Toast.makeText(this, barcode.displayValue.toString(), Toast.LENGTH_LONG).show();
//        mCodeScanner.setDecodeCallback(new DecodeCallback() {
//            @Override
//            public void onDecoded(@NonNull final Result result) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Class_id_scan = result.getText();
//                        infoAttendance();
//                    }
//                });
//            }
//        });
//        scannerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mCodeScanner.startPreview();
//            }
//        });
    }

//    public void infoAttendance() {
//        Intent intent = getIntent();
//        student_id = intent.getStringExtra("ID_STUDENT");
//        Date currentTime = Calendar.getInstance().getTime();
//        String Attendance_time = dateTime_format.getDateString(currentTime) + " " + dateTime_format.getTime12String(currentTime);
//        iAttendanceStudentPresenter.AddAttendanceStudentPresenter(Class_id_scan, student_id, Attendance_time, "1", this);
//    }

//    public void ReturnLayout() {
//        Intent student = new Intent(this, StudentActivity.class);
//        student.putExtra("ID_STUDENT", student_id);  // Truyền ID_STUDENT
//        startActivity(student);
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        mCodeScanner.startPreview();
//    }

//    @Override
//    protected void onPause() {
//        mCodeScanner.releaseResources();
//        super.onPause();
//    }

    @Override
    public void OnCheckattendanceResult(int checkattendance) {
//        // result
//        if (checkattendance == 1) {
//            // show popup checking
//            LayoutInflater inflater_sucess = (LayoutInflater)
//                    getSystemService(LAYOUT_INFLATER_SERVICE);
//            View popupView = inflater_sucess.inflate(R.layout.popup_success, null);
//            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
//            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
//            boolean focusable = true; // lets taps outside the popup also dismiss it
//            popupSucessfull = new PopupWindow(popupView, width, height, focusable);
//            popupSucessfull.setAnimationStyle(R.style.Animation);
//            popupSucessfull.showAtLocation(popupView, Gravity.CENTER, 0, 0);
//
//            //Map button ok
//            Button btnpopupSucessfull = (Button) popupView.findViewById(R.id.btnOKpopupSucessful);
//            // dismiss the popup window when touched
//            btnpopupSucessfull.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    popupSucessfull.dismiss();
//                    ReturnLayout();
//                }
//            });
//        } else {
//            // Error - run here
//            LayoutInflater inflater_error = (LayoutInflater)
//                    getSystemService(LAYOUT_INFLATER_SERVICE);
//            View popupView = inflater_error.inflate(R.layout.popup_error, null);
//            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
//            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
//            boolean focusable = true; // lets taps outside the popup also dismiss it
//            popupError = new PopupWindow(popupView, width, height, focusable);
//            popupError.setAnimationStyle(R.style.Animation);
//            popupError.showAtLocation(popupView, Gravity.CENTER, 0, 0);
//
//            //Map button ok
//            Button btnpopupSucessfull = (Button) popupView.findViewById(R.id.btnOKError);
//            // dismiss the popup window when touched
//            btnpopupSucessfull.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    popupError.dismiss();
//                    ReturnLayout();
//                }
//            });
//        }
    }
}
