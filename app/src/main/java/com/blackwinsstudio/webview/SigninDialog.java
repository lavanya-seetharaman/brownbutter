package com.blackwinsstudio.webview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SigninDialog extends DialogFragment {

    VendorUserModel vendorUserObject = new VendorUserModel();

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        if (getArguments() != null) {
            if (getArguments().getBoolean("notAlertDialog")) {
                return super.onCreateDialog(savedInstanceState);
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Alert Dialog");
        builder.setMessage("Alert Dialog inside DialogFragment");
        builder.setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dismiss();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                SigninDialog.this.getDialog().cancel();
            }
        });
        // Add action buttons
        return builder.create();
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_signin, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDone = view.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogListener dialogListener = (DialogListener) getActivity();

                // sign in the user ...
                AttributeMethods vendor_login_methods = BwtLoginRetrofitClient.getRetrofitInstance().create(AttributeMethods.class);
                Call<VendorUserModel> bwt_vendor_call = vendor_login_methods.getVendorLoginUser();
                bwt_vendor_call.enqueue(new Callback<VendorUserModel>() {
                    @Override
                    public void onResponse(Call<VendorUserModel> call, Response<VendorUserModel> response) {
                        Log.i(ApplicationConstant.TAG, "Sign In Vendor OnResponse Code :" + response.code());
                        //Log.i(ApplicationConstant.TAG, "Sign In Vendor data :" + response.body().getData());
                        Log.i(ApplicationConstant.TAG, "Sign In Vendor data :" +response.body().getData().get(0).getAttributes().getVendorEmail());
                        dialogListener.onFinishEditDialog(response.body().getData().get(1).getAttributes().getVendorEmail());
                        // Close the dialog and return back to the parent activity
                        dismiss();
                    }

                    @Override
                    public void onFailure(Call<VendorUserModel> call, Throwable throwable) {
                        Log.e(ApplicationConstant.TAG, "onfailure" + throwable.getMessage());
                    }
                });
                dismiss();
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("SignInDialog", "onCreate");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public interface DialogListener {
        void onFinishEditDialog(String inputText);
    }
}
