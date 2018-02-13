package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 首页欢迎图
 *
 * @author Alien
 */
@Entity
@Table(name = "welcome_pic")
public class WelcomePic implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Fields

    private Integer welcomePicId;
    private String welcomePicUrl;
    private String welcomePicLink;
    private Integer deleteFlag;

    // Constructors

    /**
     * default constructor
     */
    public WelcomePic() {
    }

    /**
     * full constructor
     */
    public WelcomePic(String welcomePicUrl, String welcomePicLink,
                      Integer deleteFlag) {
        this.welcomePicUrl = welcomePicUrl;
        this.welcomePicLink = welcomePicLink;
        this.deleteFlag = deleteFlag;
    }

    // Property accessors
    @Id
    @GeneratedValue
    @Column(name = "welcome_pic_id", unique = true, nullable = false)
    public Integer getWelcomePicId() {
        return this.welcomePicId;
    }

    public void setWelcomePicId(Integer welcomePicId) {
        this.welcomePicId = welcomePicId;
    }

    @Column(name = "welcome_pic_url", length = 256)
    public String getWelcomePicUrl() {
        return this.welcomePicUrl;
    }

    public void setWelcomePicUrl(String welcomePicUrl) {
        this.welcomePicUrl = welcomePicUrl;
    }

    @Column(name = "welcome_pic_link")
    public String getWelcomePicLink() {
        return this.welcomePicLink;
    }

    public void setWelcomePicLink(String welcomePicLink) {
        this.welcomePicLink = welcomePicLink;
    }

    @Column(name = "delete_flag")
    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}