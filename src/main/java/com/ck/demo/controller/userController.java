package com.ck.demo.controller;


import com.ck.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class userController {
    //引入日志
    private final Logger logger=LoggerFactory.getLogger(userController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("/add")
    public String add(){

        return "user/add";
    }
    @RequestMapping("/update")
    public String update(){

        return "user/update";
    }
    @RequestMapping("/tologin")
    public String tologin(){

        return "login";
    }
    /**
     * 测试thymeleaf
     */
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){
        //把数据存入model
        model.addAttribute("name", "黑马程序员");
        //返回test.html

        userService.userService("haha");
        return "test";
    }
    /**
     * 登陆页面
     */
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,Model model){
        /**
         * 使用shiro编写认证操作
         */
        Subject subject = SecurityUtils.getSubject();

        /**
         * 封装用户数据
         */
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            //登陆成功
            logger.info("登陆成功");
            return "redirect:/testTemplates";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            logger.info("没有此用户名");

            model.addAttribute("msg", "用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
            logger.info("密码错误");

            model.addAttribute("msg", "密码错误");
            return "login";
        }

    }

}
