package com.findeng.mvc.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.findeng.hibernate.entity.User;

public interface UserService {

    public User CreatScanUser(String OpenId, int upUserId);

    public User CreatGeneralUser(String OpenId);

    public User findByOpenId(String OpenId);

    public User findByUserId(int id);

    public User save(User user);

    public JSONObject adminLogin(String username, String password, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException;

    public JSONObject adminLogout(HttpSession session);

    public JSONObject findByPaging(User user, Integer offset, Integer limit, String field, String sort);

    public long findByCountItem();

    public JSONObject updata(User user);

    public JSONObject delete(int id);

    public List<String[]> findUserCoordinateByRole(Integer[] roles);

    public List<String[]> findSelectData(Integer role);

    public User findByPhoneNumber(String phoneNumber);

    public JSONObject lampAuthentication(int userId, int lampSelectionLogin, String lampPermissionAuthroPic);
}
