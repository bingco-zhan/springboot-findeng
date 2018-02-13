package com.findeng.hibernate.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * 聊天信息表实体类
 *
 * @author Alien
 */
@Entity
@Table(name = "information")
public class Information implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "information_id")
    private Integer informationId;

    @Column(name = "from_user_id")
    private Integer fromUserId;

    @Lob
    @Column(name = "info_content")
    private String infoContent;

    @Column(name = "info_type")
    private Integer infoType;

    @Column(name = "media_id")
    private String mediaId;

    @Column(name = "read_flag")
    private Integer readFlag;

    @Column(name = "send_time")
    private Timestamp sendTime;

    @Column(name = "to_user_id")
    private Integer toUserId;

    @Column(name = "voice_upload_time")
    private Timestamp voiceUploadTime;

    public Integer getInformationId() {
        return this.informationId;
    }

    public void setInformationId(int informationId) {
        this.informationId = informationId;
    }

    public Integer getFromUserId() {
        return this.fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getInfoContent() {
        return this.infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public Integer getInfoType() {
        return this.infoType;
    }

    public void setInfoType(int infoType) {
        this.infoType = infoType;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getReadFlag() {
        return this.readFlag;
    }

    public void setReadFlag(int readFlag) {
        this.readFlag = readFlag;
    }

    public Timestamp getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getToUserId() {
        return this.toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public Timestamp getVoiceUploadTime() {
        return this.voiceUploadTime;
    }

    public void setVoiceUploadTime(Timestamp voiceUploadTime) {
        this.voiceUploadTime = voiceUploadTime;
    }

}