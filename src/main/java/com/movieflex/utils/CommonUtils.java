package com.movieflex.utils;

import com.movieflex.auth.utils.RegisterRequest;

import java.util.regex.Pattern;

public class CommonUtils {

    public static void validateRegisterRequest(RegisterRequest registerRequest){
        if (checkIsNullOrEmpty(registerRequest.getUsername())) {
            throw new IllegalArgumentException("Username is required");
        }
        if (checkIsNullOrEmpty(registerRequest.getPassword())) {
            throw new IllegalArgumentException("Password is required");
        }
        if (checkIsNullOrEmpty(registerRequest.getName())) {
            throw new IllegalArgumentException("Name is required");
        }
        isValidEmailFormat(registerRequest.getEmail());
    }

    public static void isValidEmailFormat(String email) {
        if (checkIsNullOrEmpty(email))
            throw new IllegalArgumentException("Email is required");

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        boolean isEmail =  pattern.matcher(email).matches();

        if(!isEmail)
            throw new IllegalArgumentException("Email is not in valid format");
    }

    public static boolean isOtpValid(String otp){
        if(CommonUtils.checkIsNullOrEmpty(otp)) return false;
        String otpRegex = "^[0-9]{6}$";
        Pattern pattern = Pattern.compile(otpRegex);
        return pattern.matcher(otp).matches();
    }

    public static boolean checkIsNullOrEmpty(String str){
        return str == null || str.isBlank();
    }
}
