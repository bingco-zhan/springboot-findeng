package com.findeng.mvc.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findeng.util.HttpRequest;

@RestController
@RequestMapping(value = "/admin/api")
public class CommonController {

    @GetMapping("/upload/img")
    public String uploadImg(HttpSession session, HttpRequest req) {

        return null;
    }
}
