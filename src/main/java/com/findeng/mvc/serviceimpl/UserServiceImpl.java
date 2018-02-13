package com.findeng.mvc.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeng.Enum.UserCheckStatus;
import com.findeng.Enum.UserType;
import com.findeng.hibernate.dao.UserDao;
import com.findeng.hibernate.daoimpl.RedisDaoImpl;
import com.findeng.hibernate.entity.User;
import com.findeng.hibernate.entity.UserRole;
import com.findeng.mvc.service.UserService;
import com.findeng.util.CommonUtil;
import com.findeng.util.ReturnUtil;
import com.findeng.util.WebUtil;
import com.findeng.wechat.WeChatCoreService;

/**
 * 用户表Service层实现
 *
 * @author Alien
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    WeChatCoreService weChatCoreService;

    @Autowired
    private RedisDaoImpl redisDaoImpl;

    @Autowired
    private UserRoleServiceImpl userRoleServiceImpl;

    @Value("${wechat.ourEmployees}")
    private String ourEmployees;

    @Value("${systemFile.LampPermissionAuthroPicSrc}")
    private String LampPermissionAuthroPicSrc;

    /**
     * 重新关注平台用户
     *
     * @param User 关注的用户实体类
     * @return 关注的用户实体类
     */
    public User CreateAgainUser(User user) {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());// 获取时间戳
        JSONObject userInfo = weChatCoreService.getUserInfo(user.getOpenId());
        user.setUserNickname(userInfo.getString("nickname"));
        user.setUserProtraitPic(userInfo.getString("headimgurl"));
        user.setUnionId(userInfo.getString("unionid"));
        user.setIsConcern(1);
        user.setRentVisitTime(timeStamp);
        int role = user.getRole().getId();
        List<String> openidList = new ArrayList<String>();
        openidList.add(user.getOpenId());

        if (role == UserType.SALESMAN) {
            weChatCoreService.batchTagging("101", openidList, false);
        } else if (role == UserType.FACTORY) {
            weChatCoreService.batchTagging("102", openidList, false);
        } else {
            weChatCoreService.batchTagging("103", openidList, false);
        }
        userDao.save(user);
        return user;
    }

    /**
     * 创建通过扫描二维码方式关注用户
     *
     * @param OpenId   用户OpenId
     * @param upUserId 上级id
     * @return User
     */
    @Override
    public User CreatScanUser(String OpenId, int upUserId) {
        User user = CreatGeneralUser(OpenId);// 得到普通用户
        int[] Employees = CommonUtil.arrayStrToInt(ourEmployees.split(","));// 获取公司员工id列表
        if (upUserId == 2)
            upUserId = Employees[(int) (Math.random() * Employees.length)];// 如果二维码为平台二维码，随机分配给公司员工

        User upUser = userDao.findOne(upUserId);// 获取上级用户信息
        int upUserRole = upUser.getRole().getId();// 获取上级用户角色

        if (upUserRole == UserType.RETAIL_SALES) {// 上级是经销商或者门市业务员
            user.setUpperUserId(upUser.getUpperUserId());// 设置注册用户上级id为上上级id
            user.setSalesmanId(upUser.getUserId());// 设置销售员id为为上级id
        } else {
            user.setUpperUserId(upUserId);//// 设置注册用户上级id为上级id
        }

        // 发送通知消息给上级用户
        weChatCoreService.sendTextMessage(upUser.getOpenId(), "用户" + user.getUserNickname() + "成为了你的客户");

        userDao.save(user);// 保存用户实体
        return user;
    }

    /**
     * 创建普通关注用户
     *
     * @param OpenId 用户OpenId
     * @return User
     */
    @Override
    public User CreatGeneralUser(String OpenId) {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());// 获取时间戳
        UserRole role = new UserRole();
        role.setId(UserType.CUSTOMER);
        User user = new User();
        user.setOpenId(OpenId);// 设置微信OpenId
        user.setRole(role); // 设置权限为普通客户
        user.setWithdrawMoney(0.0f);// 设置已提现金额为0
        user.setFlowMoney(0.0f);// 设置可支配金额为0
        user.setPendingMoney(0.0f);// 设置待结算金额为0
        user.setIsConcern(1);// 设置是否关注平台1为关注了
        user.setFollowTime(timeStamp);// 设置关注时间
        user.setRentVisitTime(timeStamp);// 设置最后登录时间
        user.setCheckStatus(UserCheckStatus.AUTHENTICATION_SUCCESS);// 设置用户认证状态
        user.setUpperUserId(1);// 设置上级id为1

        JSONObject userInfo = weChatCoreService.getUserInfo(OpenId);// 获取用户详情

        user.setUserNickname(userInfo.getString("nickname"));// 设置用户昵称
        user.setUserProtraitPic(userInfo.getString("headimgurl"));// 设置用户头像
        user.setUnionId(userInfo.getString("unionid"));// 设置多平台唯一id

        // 生成随机用户编码
        List<User> TempUser;
        do {
            String Code = CommonUtil.getLetterRandomNumber(5);
            TempUser = userDao.findByuserIdenticalCode(Code);
            if (TempUser.size() == 0)
                user.setUserIdenticalCode(Code);
        } while (TempUser.size() != 0);

        userDao.save(user);
        return user;
    }

    /**
     * 通过OpenId查找用户
     *
     * @param OpenId 查找的OpenId
     */
    @Override
    public User findByOpenId(String openId) {
        return (openId == null || openId.isEmpty()) ? null : userDao.findByopenId(openId);
    }

    /**
     * 通过id查找用户
     *
     * @param id 查找的id
     */
    @Override
    public User findByUserId(int id) {
        return userDao.findOne(id);
    }

    /**
     * 保存用户实体类
     *
     * @param user 用户实体类
     */
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    /**
     * 删除用户
     *
     * @param id 需要删除的用户id
     */
    public JSONObject delete(int id) {
        userDao.delete(id);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(4), "", null, null);
    }

    /**
     * 更新用户实体
     */
    public JSONObject updata(User user) {
        if (user.getUserId() == null) WebUtil.resposeJSONObject(ReturnUtil.retParam(250), "", null, null);//如果传入userid为空
        User userSource = findByUserId(user.getUserId());
        if (userSource == null) WebUtil.resposeJSONObject(ReturnUtil.retParam(251), "", null, null);//如果查询不到该用户
        try {
            userSource = (User) CommonUtil.coverObject(user, userSource);//覆盖对象
        } catch (Exception e) {
            e.printStackTrace();
            WebUtil.resposeJSONObject(ReturnUtil.retParam(252), "", null, null);
        }
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null);
    }

    /**
     * 创建用户分页查询规范
     *
     * @param user 查询的实体类
     * @return Specification<User>
     */
    public Specification<User> createSpecification(final User user) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> arr = new ArrayList<>();
                //查询条件不为空
                if (user != null) {
                    if (user.getUserId() != null && user.getUserId() != 0) {
                        Expression<Integer> eps = root.get("userId").as(Integer.class);
                        Predicate term = cb.equal(eps, user.getUserId());
                        arr.add(term);
                    }

                    if (user.getUpperUserId() != null) {
                        Expression<Integer> eps = root.get("upperUserId").as(Integer.class);
                        Predicate term = cb.equal(eps, user.getUpperUserId());
                        arr.add(term);
                    }

                    if (user.getUserNickname() != null && !user.getUserNickname().isEmpty()) {
                        Expression<String> eps = root.get("userNickname").as(String.class);
                        Predicate term = cb.like(eps, "%" + user.getUserNickname() + "%");
                        arr.add(term);
                    }

                    if (user.getCompanyName() != null && !user.getCompanyName().isEmpty()) {
                        Expression<String> eps = root.get("companyName").as(String.class);
                        Predicate term = cb.like(eps, "%" + user.getCompanyName() + "%");
                        arr.add(term);
                    }

                    if (user.getLampSelectionLogin() != null) {
                        Expression<Integer> eps = root.get("lampSelectionLogin").as(Integer.class);
                        Predicate term = cb.equal(eps, user.getLampSelectionLogin());
                        arr.add(term);
                    }

                    if (user.getPhoneNumber() != null && !user.getPhoneNumber().isEmpty()) {
                        Expression<String> eps = root.get("phoneNumber").as(String.class);
                        Predicate term = cb.like(eps, "%" + user.getPhoneNumber() + "%");
                        arr.add(term);
                    }

                    if (user.getRole() != null) {
                        Expression<Integer> eps = root.get("role").get("id").as(Integer.class);
                        Predicate term = cb.equal(eps, user.getRole().getId());
                        arr.add(term);
                    }
                }
                return query.where(arr.toArray(new Predicate[arr.size()])).getRestriction();
            }
        };
    }

    /**
     * 查询用户并分页
     *
     * @param offset 偏移值
     * @param limit  查询长度
     * @return JSONObject
     */
    @Override
    public JSONObject findByPaging(User user, Integer offset, Integer limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "userId";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        Page<User> userList = userDao.findAll(createSpecification(user), pageReq);
        return WebUtil.resposeTableData(userList.getTotalElements(), userList.getContent());
    }

    public JSONObject getUser(String token, HttpSession session) {
        return redisDaoImpl.getUser(token, session);
    }

    /**
     * 后台管理系统登录
     *
     * @param username 用户手机号码
     * @param password 用户密码
     * @return JSONObject 登录数据
     */
    @Override
    public JSONObject adminLogin(String username, String password, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        password = CommonUtil.EncrypMD5Util(password);
        User user = userDao.findByPhoneNumber(username);
        if (user == null) {//数据库没有登记该手机号码
            return WebUtil.resposeJSONObject(ReturnUtil.retParam(103), "", null, null);
        } else {
            UserRole userRole = userRoleServiceImpl.findById(user.getRole().getId());
            if (userRole.getLoginBackstage() == 0) {
                return WebUtil.resposeJSONObject(ReturnUtil.retParam(103), "", null, null);
            } else if (user.getPassword() != null && user.getPassword().equals(password)) {//登录成功
                session.setAttribute("user", user);
                return WebUtil.resposeJSONObject(ReturnUtil.retParam(100), "/admin/index", null, null);
            } else {//密码不正确
                return WebUtil.resposeJSONObject(ReturnUtil.retParam(104), "", null, null);
            }
        }
    }

    /**
     * 后台管理系统会话注销
     *
     * @param session 会话实体
     * @return JSONObject
     */
    @Override
    public JSONObject adminLogout(HttpSession session) {
        session.invalidate();
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(101), "/admin/loginPage", null, null);
    }

    /**
     * 通过电话号码查询客户
     *
     * @param phoneNumber
     * @return
     */
    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return userDao.findByPhoneNumber(phoneNumber);
    }

    /**
     * 统计记录条数
     *
     * @return int 记录数
     */
    @Override
    public long findByCountItem() {
        return userDao.count();
    }

    /**
     * 根据权限获取用户信息 -> 用于地图分布页面
     */
    @Override
    public List<String[]> findUserCoordinateByRole(Integer[] roles) {
        return userDao.findUserCoordinateByRole(roles);
    }

    /**
     * 根据角色获取用户id和公司简称 -> 用于输入框备选
     */
    @Override
    public List<String[]> findSelectData(Integer role) {
        UserRole userRole = new UserRole();
        userRole.setId(role);
        return userDao.findUserIdAndShortCompanyNameByRole(userRole);
    }

    /**
     * 配灯系统授权
     */
    @Override
    public JSONObject lampAuthentication(int userId, int lampSelectionLogin, String lampPermissionAuthroPic) {
        User user = findByUserId(userId);
        if (user == null) WebUtil.resposeJSONObject(ReturnUtil.retParam(157), "", null, null);
        user.setLampSelectionLogin(lampSelectionLogin);
        user.setLampPermissionAuthroPic(lampPermissionAuthroPic);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null);
    }
}
