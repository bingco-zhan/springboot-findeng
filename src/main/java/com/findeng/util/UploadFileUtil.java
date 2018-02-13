package com.findeng.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.findeng.hibernate.model.UploadImgModel;

/**
 * 文件上传工具类
 *
 * @author Alien
 */
public class UploadFileUtil {

    /**
     * 图片上传方法
     *
     * @param images    图片请求对象
     * @param savePath  文件保存路径
     * @param accessUrl 文件访问前缀
     * @param fileName  文件名
     * @throws IOException
     */
    public static List<UploadImgModel> UploadImg(MultipartFile[] images, String savePath, String accessUrl, String fileName) throws IOException {
        List<UploadImgModel> list = new ArrayList<>();
        if (images != null && images.length > 0) {
            for (int i = 0; i < images.length; i++) {
                String Suffix = "." + CommonUtil.getFileType(images[i].getOriginalFilename());//获取文件后缀
                File file = new File(savePath + fileName + Suffix);//得到输出文件对象
                CommonUtil.mkdirs(file);//判断文件目录是否存在并创建
                byte[] bytes = images[i].getBytes();
                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(file));
                buffStream.write(bytes);
                buffStream.close();
                //压缩图片
                ImageUtil.compressImage(file, file.getPath(), 0.3f);
                //生成缩略图
                UploadImgModel model = new UploadImgModel();
                model.setHttpSrc(accessUrl + file.getName());
                model.setFile(file);
                list.add(model);
            }
        }
        return list;
    }
}
