package com.company.Regex.IPAddress;

import com.company.Regex.IValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidator implements IValidator<String> {

    private String ip;

    public IPAddressValidator(String ip){
        this.ip = ip;
    }

    private Pattern pattern = Pattern.compile("^([1]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([1]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([1]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([1]?\\d\\d?|2[0-4]\\d|25[0-5])\\$");

    @Override
    public boolean validate(String content) {
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }
}
