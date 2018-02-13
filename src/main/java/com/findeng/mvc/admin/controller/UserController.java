package com.findeng.mvc.admin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.findeng.hibernate.entity.Address;
import com.findeng.hibernate.entity.CertificationApplication;
import com.findeng.hibernate.entity.Customerbinding;
import com.findeng.hibernate.entity.User;
import com.findeng.hibernate.entity.UserPermission;
import com.findeng.hibernate.entity.UserRole;
import com.findeng.hibernate.model.UploadImgModel;
import com.findeng.mvc.service.CustomerbindingService;
import com.findeng.mvc.serviceimpl.AddressServiceImpl;
import com.findeng.mvc.serviceimpl.CertificationApplicationServiceImpl;
import com.findeng.mvc.serviceimpl.UserPermissionServiceImpl;
import com.findeng.mvc.serviceimpl.UserRoleServiceImpl;
import com.findeng.mvc.serviceimpl.UserServiceImpl;
import com.findeng.util.CommonUtil;
import com.findeng.util.ReturnUtil;
import com.findeng.util.UploadFileUtil;
import com.findeng.util.WebUtil;

@RestController
@RequestMapping(value = "/admin/api")
public class UserController {

    //本机保存认证图片路径
    @Value("${systemFile.CertificationApplicationPicSrc}")
    private String systemCertificationApplicationPicSrc;

    //外网访问认证图片路径
    @Value("${httpFile.CertificationApplicationPicSrc}")
    private String httpCertificationApplicationPicSrc;

    @Value("${systemFile.LampPermissionAuthroPicSrc}")
    private String systemLampPermissionAuthroPicSrc;

    @Value("${httpFile.LampPermissionAuthroPicSrc}")
    private String httpLampPermissionAuthroPicSrc;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private AddressServiceImpl addressServiceImpl;

    @Autowired
    private UserRoleServiceImpl userRoleServiceImpl;

    @Autowired
    private CustomerbindingService customerbindingService;

    @Autowired
    private UserPermissionServiceImpl userPermissionServiceImpl;

    @Autowired
    private CertificationApplicationServiceImpl certificationApplicationServiceImpl;

    /**
     * 登录管理系统
     */
    @PostMapping(value = "/login")
    public String login(HttpSession session, HttpServletRequest req)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String data = userServiceImpl.adminLogin(req.getParameter("username"), req.getParameter("password"), session)
                .toString();
        return data;
    }

    /**
     * 注销登录管理系统
     */
    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        return userServiceImpl.adminLogout(session).toString();
    }

    /**
     * 获取登陆用户信息
     */
    @GetMapping("/userInfo")
    public String userInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return new JSONObject(user).toString();
    }

    /**
     * 获取分页用户列表
     */
    @GetMapping(value = "/user")
    public String pagingList(HttpSession session, User user,
                             @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                             @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                             @RequestParam(value = "field", required = false) String field,
                             @RequestParam(value = "sort", required = false) String sort) {
        return userServiceImpl.findByPaging(user, offset, limit, field, sort).toString();
    }

    /**
     * 获取分页用户列表
     */
    @GetMapping(value = "/select/user")
    public String pagingList(HttpSession session, @RequestParam(value = "role") Integer role) {
        return userServiceImpl.findSelectData(role).toString();
    }

    /**
     * 更新user
     */
    @PutMapping(value = "/user")
    public String modifyUser(HttpSession session, User user) {
        return userServiceImpl.updata(user).toString();
    }

    /**
     * 查询用户
     */
    @GetMapping("/user/{id}")
    public String findUser(@PathVariable("id") Integer id) {
        User user = userServiceImpl.findByUserId(id);
        return new JSONObject(user).toString();
    }

    /**
     * 删除用户
     */
    @DeleteMapping(value = "/user/{id}")
    public String deleteUser(@PathVariable int id, HttpSession session, HttpServletRequest req,
                             HttpServletResponse rep) {
        return userServiceImpl.delete(id).toString();
    }

    /**
     * 获取所有用户角色
     */
    @GetMapping(value = "/userRole/all")
    public String getUserRoleAll(HttpSession session) {
        List<UserRole> list = userRoleServiceImpl.findByAll();
        return WebUtil.resposeTableData(list.size(), list).toString();
    }

    /**
     * 获取所有权限
     */
    @GetMapping(value = "/userPermission/all")
    public String getUserPermissionAll(HttpSession session) {
        List<UserPermission> list = userPermissionServiceImpl.findByAll();
        return WebUtil.resposeTableData(list.size(), list).toString();
    }

    /**
     * 修改用户角色
     */
    @PutMapping(value = "/userRole")
    public String modifyRole(HttpSession session, HttpServletRequest req, UserRole userRole) {
        return userRoleServiceImpl.updata(userRole).toString();
    }

    /**
     * 保存用户角色
     */
    @PostMapping(value = "/userRole")
    public String saveRole(HttpSession session, HttpServletRequest req, UserRole userRole) {
        return userRoleServiceImpl.save(userRole).toString();
    }

    /**
     * 配灯系统授权图片上传
     *
     * @throws IOException
     */
    @PostMapping("/lampPermission/uploadImage")
    public String lampPermissionUploadImage(HttpSession session, @RequestParam("file") MultipartFile[] images) throws IOException {
        //如果用户没有登录
        if (session.getAttribute("user") == null) WebUtil.resposeJSONObject(ReturnUtil.retParam(156), "", null, null);
        //开始保存上传图片
        List<UploadImgModel> list = UploadFileUtil.UploadImg(images,
                systemLampPermissionAuthroPicSrc,
                httpLampPermissionAuthroPicSrc,
                CommonUtil.getUUID());
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", "", list).toString();
    }

    /**
     * 修改用户配灯系统的权限
     */
    @PutMapping("/lampPermission/authentication")
    public String lampPermission(
            @RequestParam(value = "userId", required = true) int userId,
            @RequestParam(value = "lampSelectionLogin", required = true) int lampSelectionLogin,
            @RequestParam(value = "lampPermissionAuthroPic") String lampPermissionAuthroPic) {
        return userServiceImpl.lampAuthentication(userId, lampSelectionLogin, lampPermissionAuthroPic).toString();
    }

    /**
     * 通过角色类型查找角色坐标
     *
     * @param roles 角色类型int数组
     */
    @GetMapping("/findCoordinateByRoles")
    public String findUserCoordinateByRole(@RequestParam("roles[]") Integer[] roles) {
        List<String[]> list = userServiceImpl.findUserCoordinateByRole(roles);
        return JSONObject.valueToString(list);
    }

    /**
     * 保存用户认证表
     */
    @PostMapping("/certificationApplication")
    public String certificationApplication(HttpSession session, CertificationApplication ce) {
        return certificationApplicationServiceImpl.save(ce).toString();
    }

    /**
     * 上传用户认证表图片
     *
     * @throws IOException
     */
    @PostMapping("/certificationApplication/uploadImage")
    public String uploadImage(HttpSession session, @RequestParam("file") MultipartFile[] images) throws IOException {
        //如果用户没有登录
        if (session.getAttribute("user") == null) WebUtil.resposeJSONObject(ReturnUtil.retParam(156), "", null, null);
        //开始保存上传图片
        List<UploadImgModel> list = UploadFileUtil.UploadImg(images,
                systemCertificationApplicationPicSrc,
                httpCertificationApplicationPicSrc,
                CommonUtil.getUUID());
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", "", list).toString();
    }

    /**
     * 获取用户认证表分页
     */
    @GetMapping(value = "/certificationApplication")
    public String certificationApplicationPagingList(CertificationApplication ce, HttpSession session,
                                                     @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                     @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                                     @RequestParam(value = "field", required = false) String field,
                                                     @RequestParam(value = "sort", required = false) String sort) {
        Page<CertificationApplication> page = certificationApplicationServiceImpl.findByPaging(ce, offset, limit, field, sort);
        return WebUtil.resposeTableData(page.getTotalElements(), page.getContent()).toString();
    }

    /**
     * 审批用户认证表
     *
     * @param applyId     认证表id
     * @param checkStatus 审批认证状态 1待审核，2失败，3成功
     */
    @PutMapping(value = "/certificationApplication")
    public String certificationApplicationApproval(HttpSession session, @RequestParam(value = "applyId") int applyId,
                                                   @RequestParam(value = "checkStatus") int checkStatus) {
        return certificationApplicationServiceImpl.Application(applyId, checkStatus).toString();
    }

    /**
     * 申请用户绑定
     */
    @PostMapping(value = "/customerBinding")
    public Map<String, Object> addCustomerBinding(HttpSession session, User unbundling) {
        User apply = (User) session.getAttribute("user");
        return customerbindingService.save(apply, unbundling);
    }

    /**
     * 获取用户绑定分页列表
     */
    @GetMapping(value = "/customerBinding")
    public String findCustomerBindingList(Customerbinding customerbinding,
                                          @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                          @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                          @RequestParam(value = "field", required = false) String field,
                                          @RequestParam(value = "sort", required = false) String sort) {
        Page<Customerbinding> page = customerbindingService.findCustomerBindingList(customerbinding, offset, limit, field, sort);
        return WebUtil.resposeTableData(page.getTotalElements(), page.getContent()).toString();
    }

    /**
     * 审核用户绑定
     *
     * @param id      表ID
     * @param keyword 状态码
     */
    @PutMapping("/customerBinding")
    public Map<String, Object> updataCustomerBinding(@RequestParam("id") Integer id,
                                                     @RequestParam("status") Integer status) {
        return customerbindingService.update(id, status);
    }

    /**
     * 根据上级ID查询地址集合
     */
    @GetMapping("/address/upId")
    public String queryAddressByUpId(@RequestParam("upId") String upId) {
        List<Address> addrList = addressServiceImpl.findeByUpId(upId);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, addrList).toString();
    }

    /**
     * 根据ID查询Address
     */
    @GetMapping("/address/id")
    public Address queryAddressById(@RequestParam("id") String id) {
        return addressServiceImpl.findById(id);
    }

}
