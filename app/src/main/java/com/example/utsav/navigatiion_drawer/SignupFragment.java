package com.example.utsav.navigatiion_drawer;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragment extends android.support.v4.app.Fragment {
    static final int REQUEST_IMAGE_OPEN = 1001;
    static final int REQUEST_IMAGE_CAPTURE = 1002;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AppCompatEditText etEmail, etPassword, etConfirmPassword;
    private AppCompatButton btnSignup;
    private CircleImageView imageView;
    private Uri camera, gallary;
    private SharedPreferences preferencesEmail;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SignupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Signup");
        preferencesEmail = getActivity().getSharedPreferences("Signup", Context.MODE_PRIVATE);
        etEmail = (AppCompatEditText) view.findViewById(R.id.et_email);

        imageView = (CircleImageView) view.findViewById(R.id.profile_image);
        etPassword = (AppCompatEditText) view.findViewById(R.id.et_password);
        etConfirmPassword = (AppCompatEditText) view.findViewById(R.id.et_cfpassword);
        btnSignup = (AppCompatButton) view.findViewById(R.id.bt_register);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select();


            }
        });
    }

    private void select() {
        final CharSequence[] utsav = {"Take Photo", "Select From Gallary", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select Image");
        builder.setItems(utsav, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (utsav[which].equals("Take Photo")) {
                    capturePhoto();

                } else if (utsav[which].equals("Select From Gallary")) {
                    selectImage();
                    //  SigninFragment.newInstance(gallary.getPath());
                } else if (utsav[which].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        })
                .setCancelable(false)
                .show();
    }

    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        // Only the system receives the ACTION_OPEN_DOCUMENT, so no need to test.
        startActivityForResult(intent, REQUEST_IMAGE_OPEN);
    }

    public void capturePhoto() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_OPEN && resultCode == RESULT_OK) {

            gallary = data.getData();
            imageView.setImageURI(gallary);

            // Do work with full size photo saved at fullPhotoUri

        } else if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            camera = data.getData();

            imageView.setImageURI(camera);
            Toast.makeText(getActivity(), "" + camera, Toast.LENGTH_SHORT).show();
        }
    }

    private void registerUser() {
        String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();
        SharedPreferences.Editor edit = preferencesEmail.edit();
        edit.putString("email", email);
        edit.putString("password", password);

        edit.apply();


        if (TextUtils.isEmpty(email)) {
            etEmail.setError("enter email");
            Toast.makeText(getActivity(), "enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setText("enter password");
            Toast.makeText(getActivity(), "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(confirmPassword)) {
            etConfirmPassword.setText("Enter Confirm password");
            Toast.makeText(getActivity(), "Enter Confirm Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (checkPassword() == true) {
            Toast.makeText(getActivity(), "Sucess", Toast.LENGTH_SHORT).show();
            SigninFragment signinFragment = SigninFragment.newInstance("", "");
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.addFragment(R.id.fragment_container, signinFragment);


        } else {
            Toast.makeText(getActivity(), "not same", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean checkPassword() {
        String password, confirmPassword;
        password = etPassword.getText().toString();
        confirmPassword = etConfirmPassword.getText().toString();
        boolean answer = password.equals(confirmPassword.toString());


        return answer;
    }
}
