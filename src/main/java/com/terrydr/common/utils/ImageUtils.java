package com.terrydr.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.utils
 * @Description: 简单图片工具类
 * @author: YanZhengYuan
 * @Date: 6/12/2018 2:51 PM
 * @version: 1.00
 */
public class ImageUtils {

    private static final Log logger = LogFactory.getLog(ImageUtils.class);

    /**
    * @Description: 绘制验证码
    * @param width,height,randomStr
    * @return BufferedImage.class
    * @throws
    * @author YanZhengYaun
    * @date 6/12/2018 3:26 PM
    */
    public static BufferedImage createVerifyCodePicture(int width, int height, String randomStr){
        return createGraphics(width, height, BufferedImage.TYPE_INT_RGB, new GraphicsDoing() {
            @Override
            public void doing(Graphics gra) {
                Random random = new Random(System.currentTimeMillis());
                gra.setColor(getRandColor(110, 200, random)); // 设置背景色
                gra.fillRect(0, 0, width, height);

                gra.setColor(Color.black); // 设置字体色
                gra.setFont(new Font("Times New Roman", Font.PLAIN, 36));

                // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
                for (int i = 0; i < 155; i++) {
                    int x = random.nextInt(width);
                    int y = random.nextInt(height);
                    int xl = random.nextInt(width / 2);
                    int yl = random.nextInt(height / 2);
                    gra.setColor(getRandColor(200, 250, random));
                    gra.drawLine(x, y, x + xl, y + yl);
                }

                // 取随机产生的认证码
                for (int i = 0; i < randomStr.length(); i++) {
                    char rand = randomStr.charAt(i);
                    // 将认证码显示到图象中
                    gra.setColor(getRandColor(0,110, random));
                    gra.drawString("" + rand, 18 * i + 6, 28);
                }
            }
        });
    }

    /**
    * @Description: 创建图片
    * @param width,height,imageType,gd
    * @return BufferedImage.class
    * @throws
    * @author YanZhengYaun
    * @date 6/12/2018 3:01 PM
    */
    public static BufferedImage createGraphics(int width, int height, int imageType, GraphicsDoing gd){
        BufferedImage image = new BufferedImage(width, height, imageType);
        Graphics gra = image.getGraphics();
        gd.doing(gra);
        return image;
    }

    /**
    * @Description: fc-bc,获得随机颜色
    * @param fc,bc
    * @return Color.class
    * @throws
    * @author YanZhengYaun
    * @date 6/12/2018 2:54 PM
    */
    public static Color getRandColor(int fc, int bc, Random random) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        logger.debug("随机产生颜色（RGB）： " + r + "-" + g + "-" + b);
        return new Color(r, g, b);
    }

    /**
    * @Description: 获得随机验证码数字
    * @param len
    * @return ${return_type}
    * @throws
    * @author YanZhengYaun
    * @date 6/12/2018 3:30 PM
    */
    public static String getRandomString(int len){
        StringBuilder sb = new StringBuilder();
        if(len < 1){
            len = 1;
        }
        for(int i = 0; i < len; i++){
            sb.append(getChar());
        }
        return sb.toString();
    }

    /**
    * @Description: 获取字符
    * @return char
    * @throws
    * @author YanZhengYaun
    * @date 6/12/2018 3:12 PM
    */
    private static char getChar() {
        char ch = '0';
        LinkedList<String> ls = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {// 0-9
            ls.add(String.valueOf(48 + i));
        }
        int index = (int) (Math.random() * ls.size());
        if (index > (ls.size() - 1)) {
            index = ls.size() - 1;
        }
        ch = (char) Integer.parseInt(String.valueOf(ls.get(index)));
        return ch;
    }

    interface GraphicsDoing{
            void doing(Graphics graphics);
    }

}
