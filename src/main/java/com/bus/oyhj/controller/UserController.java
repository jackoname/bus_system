package com.bus.oyhj.controller;

import com.bus.oyhj.mapper.BusMapper;
import com.bus.oyhj.mapper.UserMapper;
import com.bus.oyhj.pojo.*;

import com.bus.oyhj.service.BusService;
import com.bus.oyhj.service.UserService;
import com.bus.oyhj.service.imp.userServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    @Qualifier("busServiceimp")
    private BusService busService;

    @Autowired
    @Qualifier("userServiceimp")
   private UserService userService;

    public  List<busBean> setBus(List<busBean> busbean,List<busStationBean>busS){

        for (busBean bus:busbean) {
            String begign="",end="";
            int max=0;
            for (busStationBean buss:busS) {
                if(bus.getBusid()==buss.getBusid()) {
                    if (buss.getOrder() == 1) {
                        begign = buss.getStationname();
                        bus.setBegin(buss.getStationname());
                    }
                    if(buss.getOrder()>max){
                        max=buss.getOrder();
                        end=buss.getStationname();
                        bus.setEnd(buss.getStationname());
                    }
                }
                busService.updateBusbe(new busBean(bus.getBusid(),begign,end));
            }
        }
        return busbean;
    }

    @RequestMapping("/user/turnlogin")
    public String turnuserlogin(){
        return "index";
    }
    //登录
    @RequestMapping("/user/new")
    public String usernew(Model model,@RequestParam(name="username",required = false,defaultValue = "") String username
    ,@RequestParam(name="password",required = false,defaultValue = "") String userpassword,
                          @RequestParam(name="email",required = false,defaultValue = "") String email) {
        userBean userBean = new userBean(username, userpassword, email);
        try {
            if(!email.equals(""))
                System.out.println(userService.userNew(userBean));
            else if(email.equals("")&&!username.equals("")) {
                int a=0;
                a=7/a;
            }
        }catch (Exception e){
            model.addAttribute("error","用户名重复或邮箱为空！！");
            System.out.println(e.fillInStackTrace());
            return "error";
          }
        return "new";
    }
    @RequestMapping("/user/findpassword")
    public String findpassword(Model model,@RequestParam(name="username",required = false,defaultValue = "") String username,
                               @RequestParam(name="userpassword",required = false,defaultValue = "") String userpassword,
                               @RequestParam(name="email",required = false,defaultValue ="") String email) {
        userBean userBean = new userBean(username, userpassword, email);
        if (!email.equals("")) {
            System.out.println(userService.updateUser(userBean));
        }

    return "findpassword";
}
    @RequestMapping("/user/advice")
    public String advice(HttpSession session,Model model,@RequestParam(name="message",required = false,defaultValue = "") String message){
        faceBackBean faceBackBean =new faceBackBean(String.valueOf(session.getAttribute("loginUser")),message);
        System.out.println(message+"===========");
        if (!message.equals(""))
        System.out.println(userService.addAdvice(faceBackBean));

        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "advice";
    }

    @RequestMapping("/user/notice")
    public String notice(HttpSession session,Model model){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        List<noticeBean> noticeBeans=userService.allNotice();
        for (noticeBean no:noticeBeans) {
            no.setDt(sdf1.format(no.getTime()));
        }
        noticeBeans.sort(Comparator.comparing(noticeBean::getId).reversed());
        model.addAttribute("emps", noticeBeans);
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "notice";
    }

    @RequestMapping("/user/myinf")
    public String myinf(HttpSession session,Model model){
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "myinformation";
    }
    @RequestMapping("/exit")
    public String exit(HttpSession session,Model model){
        //model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "index";
    }

    @PostMapping("/user/login")
    @RequestMapping("/user/login")
    public String login  (@RequestParam(name="username",required = false,defaultValue = "0") String username, @RequestParam(name ="password",required = false,defaultValue = "0") String password,
                        Model model,HttpSession session,String myid){
        userBean b=new userBean(username,password);
        List<busStationBean> busStationBean= busService.queryUserListSta();
        List<busBean>busbeans=busService.queryUserList();
        busbeans=setBus(busbeans,busStationBean);
        //System.out.println(myid+"  ---- "+session.getAttribute("loginUser"));
        System.out.println(userService.loginUser(b).size());

        for (int i = 0; i <busbeans.size() ; i++) {
            System.out.println(busbeans.get(i).toString());
        }
        if(userService.loginUser(b).size()==1){
            session.setAttribute("loginUser",username);
            model.addAttribute("emps",busbeans);
            model.addAttribute("msg","welcom"+username);
            model.addAttribute("myseeion",session.getAttribute("loginUser"));
            return "success";
        }
        else if (session.getAttribute("loginUser").equals(myid)){
            model.addAttribute("myseeion",session.getAttribute("loginUser"));
            model.addAttribute("emps",busbeans);
            return "success";
        }
        else{
            model.addAttribute("error","请输入数字（公车号）！");
            return "error";
        }
    }

    //展示用户
    @RequestMapping("/user/show")
    public String show (Model model,String myid,HttpSession session,String keyword){
     List<busStationBean> busStationBeans =busService.queryUserListbySid(Integer.valueOf(keyword));
        for (busStationBean bb:busStationBeans) {
            System.out.println(bb.toString());
        }
        System.out.println("===============================================");

        for (busStationBean bb:busStationBeans) {
            System.out.println(bb.toString());
        }
     busBean busBeans =busService.queryUserListbyId(Integer.valueOf(keyword)).get(0);
        busStationBeans.sort(Comparator.comparing(busStationBean::getOrder));
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        model.addAttribute("emp",busBeans);
       model.addAttribute("keyst",busStationBeans);
            return "userlist";
    }

    @RequestMapping("/emp")
    public String emp(@RequestParam(name="username",required = false) String username, @RequestParam(name ="password",required = false) String password,
                          Model model){
            model.addAttribute("msg","密码或账号错误！");
            return "/emp/add";

    }


}