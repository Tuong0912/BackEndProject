package com.example.demo.service.interservice;

import com.example.demo.model.user.User;
import com.example.demo.service.IGeneralService;

public interface IUserService extends IGeneralService<User> {
    User checkApplication(Long id);
}
