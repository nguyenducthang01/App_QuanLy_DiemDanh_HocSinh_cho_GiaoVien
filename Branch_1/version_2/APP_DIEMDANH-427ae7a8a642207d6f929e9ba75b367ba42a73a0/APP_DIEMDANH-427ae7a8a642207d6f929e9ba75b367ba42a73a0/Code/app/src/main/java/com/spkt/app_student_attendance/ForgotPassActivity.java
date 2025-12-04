package com.spkt.app_student_attendance;

import  androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.spkt.app_student_attendance.Ultils.OTPCode;
import com.spkt.app_student_attendance.presenter.IforgotPassPresenter;
import com.spkt.app_student_attendance.presenter.forgotPassPresenter;
import com.spkt.app_student_attendance.view.IForgotPassView;

import java.util.concurrent.TimeUnit;

public class ForgotPassActivity extends AppCompatActivity implements IForgotPassView,View.OnClickListener{
    // nếu code gửi fail, sử dụng tính năng resend
    private PhoneAuthProvider.ForceResendingToken forceResendingToken;
    // hàm để nhận biết code đã đc gửi hay chưa
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private String mVerificationId; // giữ OTP/ verify OTP
    // Kết nối với firebase gọi ra để dùng
    private FirebaseAuth firebaseAuth;
    private static final String TAG = "MAIN_TAG";



    // progres dialog cái này để hiển thị cái màn hình chờ gửi code
    private ProgressDialog pd;
    Button checkbtn, btn_contact;
    EditText phoneEt, userEt;
    Boolean result =false;
    String dauso = "+84";

    private IforgotPassPresenter forgotPassPresenter = new forgotPassPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_sms);

        firebaseAuth = FirebaseAuth.getInstance();
        checkbtn = (Button) findViewById(R.id.btn_confirm);
        phoneEt = (EditText) findViewById(R.id.NewPassET);
        userEt = (EditText) findViewById(R.id.UserEt);
        btn_contact = (Button) findViewById(R.id.btn_contact_by_phonenumber);

        checkbtn.setOnClickListener(this);
        btn_contact.setOnClickListener(this);
        phoneEt.setFocusable(false);




        // trong progress dialog
        pd = new ProgressDialog(this);
        pd.setTitle("Please wait....");
        pd.setCanceledOnTouchOutside(false);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            // verify thành công
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                OTPCode.setSms_code(phoneAuthCredential.getSmsCode());
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }


            // verify cái code bị sai
            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                pd.dismiss();
                Toast.makeText(ForgotPassActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            // Cái này sau khi nó chạy xong cái màn hình dialog và gửi code tới đth
            // thì ẩn cái phoneLl đi hiện cái codeLl lên
            @Override
            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken token) {
                super.onCodeSent(verificationId, forceResendingToken);
                Log.d(TAG, "onCodeSent: " + verificationId);
                mVerificationId = verificationId;
                forceResendingToken = token;
                pd.dismiss();
                OTPCode.setOtp_code(verificationId);
                OTPCode.setPhoneNumber(phoneEt.getText().toString());

                //change screen to Verify OTP SCreen
                ///change screen
                Toast.makeText(ForgotPassActivity.this, "Verification code sent.....", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ForgotPassActivity.this,VerifyOTPActivity.class);
                intent.putExtra("username",userEt.getText().toString().trim());
                startActivity(intent);


                //binding.codeSentDeCription.setText("Please type the verification code we sent... \n" + binding.phoneEt.getText().toString().trim());
            }
        };
    }

    // Hàm có tác dụng gửi mã xác thực
    private void startPhoneNumberVerification(String phone) {
        pd.setMessage("Verifying Phone Number");
        pd.show();

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber(phone)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(ForgotPassActivity.this)
                        .setCallbacks(mCallbacks)
                        .setForceResendingToken(forceResendingToken)     // ForceResendingToken from callbacks
                        .build();

        PhoneAuthProvider.verifyPhoneNumber(options);

    }


    // Hàm verify cái code nhận được
    private void verifyPhoneNumberWithCode(String verificationId, String code) {
        pd.setMessage("Verifying code");
        pd.show();

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithPhoneAuthCredential(credential);

    }

    // hàm này để kiểm tra cái code và login vào
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        pd.setMessage("Logging in");
        firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //Sucessfully
                        pd.dismiss();
                        String phone = firebaseAuth.getCurrentUser().getPhoneNumber();
                        Toast.makeText(ForgotPassActivity.this, "Logged In as", Toast.LENGTH_SHORT).show();

                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // failure
                        pd.dismiss();
                        Toast.makeText(ForgotPassActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public void showPhone(String student_phone)
    {
        if(student_phone.equals("Not Exist"))
        {
            phoneEt.setError("This username not exist");
        }
        else
        {
            phoneEt.setText("+84" + student_phone);
            checkbtn.setText("Continue");
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirm:
                if(checkbtn.getText().toString().equals("Check")) {
                    String user = userEt.getText().toString();
                    if (user.equals("")) {
                        Toast.makeText(ForgotPassActivity.this, "Username not Blank!", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        forgotPassPresenter.checkUsername(user, this);
                    }
                    break;
                }
                else
                {
                    String phone = phoneEt.getText().toString().trim();
                    String username = userEt.getText().toString().trim();
                    if (TextUtils.isEmpty(phone)) {
                        Toast.makeText(ForgotPassActivity.this, "Please enter phone number ...", Toast.LENGTH_SHORT).show();
                    } else {
                        startPhoneNumberVerification(phone);
                    }
                    break;
                }
            case R.id.btn_contact_by_phonenumber:
                startActivity(new Intent(ForgotPassActivity.this, ForgotPasswordActivity.class));
                finish();
                break;
        }
    }



}