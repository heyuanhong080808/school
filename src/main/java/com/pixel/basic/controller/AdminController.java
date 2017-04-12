package com.pixel.basic.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.pixel.basic.dto.AuthToken;
import com.pixel.basic.model.User;
import com.pixel.basic.service.UserService;
import com.pixel.basic.tools.SecurityUtil;


@Controller
@RequestMapping(value = "admin")
public class AdminController {//管理员控制器

    @Autowired   //依赖注入 自动装配
    private UserService userService;

    /** 后台首页 */
    @RequestMapping(value={"", "/"}, method= RequestMethod.GET)   //get请求
    public String index(Model model, HttpServletRequest request) {
        return "admin/basic/index";   //返回给index页面
    }

    /** 修改密码 */ 
    @RequestMapping(value="updatePwd")
    public String updatePwd(Model model, Integer flag, String oldPwd, String password, String nickname, HttpServletRequest request) {
        String method = request.getMethod(); //获取请求方式，GET、POST
        if("get".equalsIgnoreCase(method)) {
            model.addAttribute("flag", flag); //flag为标记
            return "admin/basic/updatePwd";
        } else if("post".equalsIgnoreCase(method)) {
            AuthToken at = (AuthToken) request.getSession().getAttribute(AuthToken.SESSION_NAME);
            User user = at.getUser();
            try {
                if(password!=null && !"".equals(password)) { //如果没有输入密码，则不修改
                    if(!SecurityUtil.md5(user.getUsername(), oldPwd).equals(user.getPassword())) {
                        model.addAttribute("errorMsg", "原始密码输入错误");
                        return "admin/basic/updatePwd";
                    }
                    user.setPassword(SecurityUtil.md5(user.getUsername(), password));
                }
                user.setNickname(nickname);
                userService.save(user);
                return "redirect:/admin/updatePwd?flag=1";//flag=1表示修改信息成功
            } catch (Exception e) {
                //e.printStackTrace();
                return "redirect:/admin/updatePwd?flag=2";
            }
        }
        return "redirect:/admin/updatePwd";
    }
}
