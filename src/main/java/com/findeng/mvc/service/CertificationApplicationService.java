package com.findeng.mvc.service;

import org.json.JSONObject;
import org.springframework.data.domain.Page;

import com.findeng.hibernate.entity.CertificationApplication;

/**
 * 用户认证表接口
 *
 * @author Alien
 */
public interface CertificationApplicationService {

    public JSONObject save(CertificationApplication ce);

    public Page<CertificationApplication> findByPaging(CertificationApplication ca, Integer offset, Integer limit, String field, String sort);

    public JSONObject Application(int applyId, int checkStatus);
}
