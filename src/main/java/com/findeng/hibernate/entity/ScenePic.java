package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 配灯系统场景图表
 *
 * @author Alien
 */
@Entity
@Table(name = "scene_pic")
public class ScenePic implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer scenePicId;
    private Integer userId;
    private Integer deleteFlag;
    private String scenePicUrl;
    private Integer sceneStyle;
    private Integer sceneSpace;

    @Id
    @GeneratedValue
    @Column(name = "scene_pic_id", unique = true, nullable = false)
    public Integer getScenePicId() {
        return this.scenePicId;
    }

    public void setScenePicId(Integer scenePicId) {
        this.scenePicId = scenePicId;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "delete_flag")
    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Column(name = "scene_pic_url")
    public String getScenePicUrl() {
        return this.scenePicUrl;
    }

    public void setScenePicUrl(String scenePicUrl) {
        this.scenePicUrl = scenePicUrl;
    }

    @Column(name = "scene_style")
    public Integer getSceneStyle() {
        return this.sceneStyle;
    }

    public void setSceneStyle(Integer sceneStyle) {
        this.sceneStyle = sceneStyle;
    }

    @Column(name = "scene_space")
    public Integer getSceneSpace() {
        return this.sceneSpace;
    }

    public void setSceneSpace(Integer sceneSpace) {
        this.sceneSpace = sceneSpace;
    }

}