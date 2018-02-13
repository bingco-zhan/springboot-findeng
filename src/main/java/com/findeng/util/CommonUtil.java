package com.findeng.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

/**
 * 通用工具类
 *
 * @author Alien
 */
public class CommonUtil {

    /**
     * XML字符串转Map
     *
     * @param xml xml格式字符串
     * @return Map<String   ,   Object>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseXML(String xml) {
        SAXReader reader = new SAXReader();
        StringReader sr = new StringReader(xml);
        InputSource is = new InputSource(sr);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Document document = reader.read(is);
            Element root = document.getRootElement();
            List<Element> list = root.elements();
            for (int i = 0; i < list.size(); i++) {
                Element element = list.get(i);
                map.put(element.getName(), element.getData());
            }
        } catch (DocumentException e) {
            System.out.println("解析字符串失败!");
            e.printStackTrace();
        }
        return map;
    }

    /**
     * <p>
     * 对象字段覆盖，要求：
     * <ol>
     * <li>两个对象的字段必须一致,字段不一样的将会被忽略.
     * <li>覆盖字段以from对象为蓝本.
     * <li>忽略不存在的字段和Null值得字段.
     * </ol>
     *
     * @param form 从这个对象中克隆
     * @param to   覆盖到此对象
     * @return 返回覆盖后的 to 对象
     * @throws Exception
     */
    public static Object coverObject(Object form, Object to) throws Exception {
        Class<? extends Object> formclazz = form.getClass();
        BeanInfo formInfo = Introspector.getBeanInfo(formclazz);
        PropertyDescriptor[] formPropertys = formInfo.getPropertyDescriptors();
        Class<? extends Object> toclazz = to.getClass();
        if (formPropertys != null && formPropertys.length > 0) {
            for (PropertyDescriptor prop : formPropertys) { // 遍历from对象的属性封装类
                Method method = prop.getReadMethod();
                Object obj = method.invoke(form);
                if (obj != null) { // 字段的值为空就跳过
                    try {
                        // 克隆的字段不存在就会抛异常。直接忽略
                        Field field = toclazz.getDeclaredField(prop.getName());
                        field.setAccessible(true); // 私有化解除
                        field.set(to, obj); // 设置参数
                    } catch (NoSuchFieldException e) {
                    }
                }
            }
        }
        return to;
    }

    /**
     * MD5加密算法
     *
     * @param 需要被加密字符串
     * @return 加密后的字符串
     */
    public static String EncrypMD5Util(String info) {
        return DigestUtils.md5Hex(info);
    }

	/**
	 * 通过路径得到文件名
	 * @param Path文件全路径
	 * @return 返回文件名或null
	 */
	public static String getFileName(String Path) {
		String fileName = Path.substring(Path.lastIndexOf("/") + 1);
		fileName = Path.substring(fileName.lastIndexOf("\\") + 1);
		return fileName.equals("") ? null : fileName;
	}
	
	/**
	 * 通过文件名获取文件后缀类型
	 * @param Suffix 后缀类型
	 */
	public static String getFileType(String fileName){
		String Suffix = fileName == null?"":fileName.split("\\.")[1];
		return Suffix;
	}
	
	/**
	 * 通过文件名获取文件前缀名
	 * @param prefix 前缀类型
	 */
	public static String getFilePrefix(String fileName){
		String Prefix = fileName == null?"":fileName.substring(0,fileName.lastIndexOf("."));
		return Prefix;
	}

    /**
     * 获取指定位数的随机字符串
     *
     * @param length 字符串长度
     * @return String 返回的随机字符
     */
    public static String getRandomNumber(int length) {
        String[] str = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String result = "";
        for (int i = 0; i <= length; i++) {
            result += str[(int) (Math.random() * 36)];
        }
        return result;
    }

    /**
     * 生成字母首位的随机字符串
     *
     * @param length 字符长度
     * @return String 返回的随机字符
     */
    public static String getLetterRandomNumber(int length) {
        char[] Letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] Nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String result = "";
        for (int i = 0; i < length; i++) {
            if (i == 0)
                result += Letters[(int) (Math.random() * 26)];
            else
                result += Nums[(int) (Math.random() * 10)];
        }
        return result;
    }

    /**
     * String数组转换为int数组
     *
     * @param 字符数组
     * @return int数组
     */
    public static int[] arrayStrToInt(String[] strArray) {
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++)
            intArray[i] = Integer.parseInt(strArray[i]);
        return intArray;
    }

    /**
     * 获取去除'-'的jdk的uuid
     *
     * @return String 随机字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 判断文件目录是否存在并创建
     */
    public static void mkdirs(File file) {
        if (!file.exists()) file.getParentFile().mkdirs();
    }

    /**
     * List拼接成字符串方法
     *
     * @param strs  java.util.List<?> 分割对象
     * @param split 分割字符
     */
    public static String join(List<String> list, String split) {
        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            if (!s.isEmpty())
                sb.append(s + split);
        }
        return sb.toString().substring(0, ((sb.toString().length()) - (split.length())));
    }
}
