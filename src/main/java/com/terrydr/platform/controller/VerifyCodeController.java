package com.terrydr.platform.controller;

import com.terrydr.common.utils.OSSContext;
import com.terrydr.common.utils.ImageUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.controller
 * @Description: 验证码controller
 * @author: YanZhengYuan
 * @Date: 2018/4/17 11:19
 * @version: 1.00
 */
@Controller
@RequestMapping("verifyCode")
public class VerifyCodeController {

    private static final Log logger = LogFactory.getLog(VerifyCodeController.class);

    /**
    * @Description: 获取验证码
    * @param request,response
    * @throws
    * @author YanZhengYaun
    * @date 6/12/2018 2:49 PM
    */
    @GetMapping("get")
    public void verifycode(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession(true);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 240);
        int width = 120, height = 34;
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
        }
        catch (IOException ioe) {
            logger.error(ioe.getMessage());
        }
        String sRand = ImageUtil.getRandomString(6);
        BufferedImage image = ImageUtil.createVerifyCodePicture(width, height, sRand);


        //将验证码塞入缓存
        /**
         * Modify by liutao
         * date 2013-11-26
         * reason:verifyCode、sysUser没有用常量定义
         */
        OSSContext.saveVerifyCode(sRand);
        try {
            ImageIO.write(image,"JPEG",out);
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if(out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }

}
