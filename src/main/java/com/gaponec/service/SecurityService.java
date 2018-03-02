package com.gaponec.service;

public interface SecurityService {
    String fingLoggedInUsername();

    void autologin(String username, String password);
}
