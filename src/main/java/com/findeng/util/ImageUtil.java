package com.findeng.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 图片处理工具类
 *
 * @author Alien
 */
public class ImageUtil {

    /**
     * base64转图片保存
     *
     * @param imgStr   base64字符
     * @param savePath 保存路径
     * @param fileName 文件名
     * @param outType  输出文件格式
     * @return File 输出的文件对象
     */
    public static File saveBase64(String imgStr, String savePath, String fileName, String outType) {
        File file = new File(savePath + fileName + "." + outType);
        CommonUtil.mkdirs(file);//创建保存文件夹
        imgStr = removeBase64Head(imgStr);//去除图片编码头
        try {
            byte[] b = Base64.decodeBase64(imgStr.getBytes());
            FileOutputStream out = new FileOutputStream(file);
            out.write(b);
            out.flush();
            out.close();
            compressImage(file, file.getPath(), 0.3f);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return file;
    }

    /**
     * 图片压缩
     *
     * @param fromPic  源文件
     * @param toPicSrc 压缩后存放目录
     * @param quality  0.01 - 1.0 质量等级
     * @return boolean
     */
    public static boolean compressImage(File fromPic, String toPicSrc, float quality) {
        try {
            Thumbnails.of(fromPic).scale(1f).outputQuality(quality).toFile(toPicSrc);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 图片生成缩略图
     *
     * @param file     需要生成缩略图的源文件
     * @param filePath 缩略图存放路径
     * @param fileName 缩略图文件名
     * @param OutType  输出格式
     * @throws Exception
     */
    public static void thumbnailImage(File file, String filePath, String fileName, String outType) {
        BufferedImage srcBufferImage;
        try {
            srcBufferImage = ImageIO.read(file);
            //输出的高度和宽度
            int width = 300;
            int heigth = 300;
            int yw = srcBufferImage.getWidth();
            int yh = srcBufferImage.getHeight();
            //等比例缩放
            if (yh > yw) {
                heigth = yh * width / yw;
            } else {
                width = heigth * yw / yh;
            }

            // 如果上传图片 宽高 比 压缩的要小 则不压缩
            if ((width > yw && heigth > yh) || file.length() < 20480) {
                File outFile = new File(filePath + fileName);
                CommonUtil.mkdirs(outFile);//创建保存文件夹
                ImageIO.write(srcBufferImage, outType, outFile);
            } else {
                BufferedImage bf = ImageIO.read(file);
                Thumbnails.of(bf).size(width, heigth).toFile(new File(filePath, fileName + "." + outType));
            }
        } catch (IOException e) {
            System.out.println("生成缩略图工具类异常:" + e);
        }
    }

    /**
     * 去除图片base64编码头
     */
    public static String removeBase64Head(String imgStr) {
        imgStr = imgStr.substring(imgStr.indexOf(",") + 1);
        return imgStr;
    }
}
