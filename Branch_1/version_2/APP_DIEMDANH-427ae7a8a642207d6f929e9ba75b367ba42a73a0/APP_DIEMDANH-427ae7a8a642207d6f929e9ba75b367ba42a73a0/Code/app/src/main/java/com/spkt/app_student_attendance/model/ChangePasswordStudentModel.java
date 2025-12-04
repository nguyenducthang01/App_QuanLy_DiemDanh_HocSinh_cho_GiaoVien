package com.spkt.app_student_attendance.model;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.spkt.app_student_attendance.ChangePasswordStudentActivity;
import com.spkt.app_student_attendance.view.IChangePasswordStudentView;
import com.spkt.app_student_attendance.view.IProfileStudentView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangePasswordStudentModel extends AppCompatActivity implements IChangePasswordStudentModel{
    private String id_student, old_password, new_password;
    private IChangePasswordStudentView iChangePasswordStudentView;
    private IPConfigModel ipConfigModel =  new IPConfigModel();

    public ChangePasswordStudentModel(String id_student, String old_password, String new_password, IChangePasswordStudentView iChangePasswordStudentView) {
        this.id_student = id_student;
        this.old_password = old_password;
        this.new_password = new_password;
        this.iChangePasswordStudentView = iChangePasswordStudentView;
    }

    @Override
    public void Changepasswordstudent(String id_student, String old_password, String new_password, IChangePasswordStudentView iChangePasswordStudentView) {
        String url = "http://"+ipConfigModel.getIpconfig()+"/student_attendence/changpasswordstudent.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) iChangePasswordStudentView);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int checkresult = 0;
                if (response.equals("Done")) {
                    checkresult = 1;
                    iChangePasswordStudentView.ChangeResult(checkresult);

                } else {
                        iChangePasswordStudentView.ChangeResult(checkresult);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iChangePasswordStudentView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("i_student", id_student);
                params.put("oldpass", old_password);
                params.put("password", new_password);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
