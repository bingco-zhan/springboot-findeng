package com.findeng.hibernate.model;

import java.io.File;

/**
 * 上传文件返回模型
 *
 * @author Alien
 */
public class UploadImgModel {
    //本机源文件地址
    private String src;
    //本机缩略图文件地址
    private String thumbnails;
    //外网http访问源文件地址
    private String httpSrc;
    //外网http访问缩略图地址
    private String httpThumbnails;
    //文件对象
    private File file;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getHttpSrc() {
        return httpSrc;
    }

    public void setHttpSrc(String httpSrc) {
        this.httpSrc = httpSrc;
    }

    public String getHttpThumbnails() {
        return httpThumbnails;
    }

    public void setHttpThumbnails(String httpThumbnails) {
        this.httpThumbnails = httpThumbnails;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
