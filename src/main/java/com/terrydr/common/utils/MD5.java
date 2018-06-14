package com.terrydr.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.utils
 * @Description: MD5 工具类
 * @author: YanZhengYuan
 * @Date: 6/13/2018 10:40 AM
 * @version: 1.00
 */
public class MD5 {

    private static final Log logger = LogFactory.getLog(MD5.class);

    /**
    * @Description: 对一个字符串进行MD5加密
    * @param sourceStr
    * @return String
    * @throws
    * @author YanZhengYaun
    * @date 6/13/2018 10:41 AM
    */
    public static String getMD5(String sourceStr) {
        if(sourceStr==null || "".equals(sourceStr.trim())){
            return null;
        }
        byte[] source=sourceStr.getBytes();
        String s = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',  'e', 'f'};
        try{
            MessageDigest md = MessageDigest.getInstance( "MD5" );
            md.update(source);
            byte tmp[] = md.digest();					// MD5 的计算结果是一个 128 位的长整数， 用字节表示就是 16 个字节
            char str[] = new char[16 * 2];				// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16 进制需要 32 个字符
            int k = 0;                                	// 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) {          	// 从第一个字节开始，对 MD5 的每一个字节 ,转换成 16 进制字符的转换
                byte byte0 = tmp[i];                 	// 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 取字节中高 4 位的数字转换,  >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf];      // 取字节中低 4 位的数字转换
            }
            s = new String(str);						// 换后的结果转换为字符串
        }catch(NoSuchAlgorithmException e){
            logger.info("MD5加密失败");
            e.printStackTrace();
        }
        return s;
    }

}
