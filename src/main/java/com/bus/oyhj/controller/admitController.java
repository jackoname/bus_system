package com.bus.oyhj.controller;

import com.bus.oyhj.mapper.AduserMapper;
import com.bus.oyhj.mapper.BusMapper;
import com.bus.oyhj.mapper.UserMapper;
import com.bus.oyhj.pojo.*;
import com.bus.oyhj.service.AduserService;
import com.bus.oyhj.service.BusService;
import com.bus.oyhj.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class admitController {
    @Autowired
    @Qualifier("aduserServiceimp")
    private AduserService aduserService;
    @Autowired
    @Qualifier("userServiceimp")
    private UserService userService;
    @Autowired
    @Qualifier("busServiceimp")
    private BusService busService;
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
    @RequestMapping("/admit/addnotice")
    public String addnotice(HttpSession session, Model model, @RequestParam(name="message",required = false) String message){
        noticeBean noticeBean =new noticeBean(String.valueOf(session.getAttribute("loginUser")),message);
        System.out.println(aduserService.addNotice(noticeBean));
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "/emp/adnotice";
    }
    @RequestMapping("/admit/notice")
    public String notice(HttpSession session,Model model){
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "/emp/adnotice";
    }
    @RequestMapping("/admit/turnlogin")
    public String turnadmitlogin(){
        return "admitlogin";
    }
    @RequestMapping("/admit/show")
    public String show (Model model,String myid,HttpSession session,String keyword){
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        List<busStationBean> busStationBeans =busService.queryUserListbySid(Integer.valueOf(keyword));
        busBean busBeans =busService.queryUserListbyId(Integer.valueOf(keyword)).get(0);
        busStationBeans.sort(Comparator.comparing(busStationBean::getOrder));
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        model.addAttribute("emp",busBeans);
        model.addAttribute("keyst",busStationBeans);
        return "/emp/list";
    }

    @RequestMapping("/admit/login")
    @PostMapping("/admit/login")
    public String login  (@RequestParam(name="username",required = false,defaultValue = "0") String username, @RequestParam(name ="password",required = false,defaultValue = "0") String password,
                          Model model,HttpSession session,String myid){
        admitBean b=new admitBean(username,password);
        List<busStationBean> busStationBean= busService.queryUserListSta();
        List<busBean>busbeans=busService.queryUserList();
        busbeans=setBus(busbeans,busStationBean);
        if(aduserService.loginUser(b).size()==1){
            session.setAttribute("loginUser",username);

            model.addAttribute("emps", busbeans);
            model.addAttribute("msg","welcom"+username);
            model.addAttribute("myseeion",session.getAttribute("loginUser"));
            return "emp/adindex";
        }
        else if (session.getAttribute("loginUser").equals(myid)){
            model.addAttribute("myseeion",session.getAttribute("loginUser"));
            model.addAttribute("emps",busbeans);

            return "emp/adindex";
        }
        else{
            model.addAttribute("error","密码或账号错误！");
            return "error";
        }
    }
    @RequestMapping("/admit/advice")
    public String aadvice(HttpSession session, Model model){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        List<faceBackBean> faceBackBeans=aduserService.allAdvice();
        for (faceBackBean no :faceBackBeans) {
            no.setDt(sdf1.format(no.getTime()));
        }
        faceBackBeans.sort(Comparator.comparing(faceBackBean::getId).reversed());
        model.addAttribute("emps", faceBackBeans);
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "/emp/adadvice";
    }
    @RequestMapping("/admit/delu")
    public String delu(HttpSession session, Model model,String un,String psw){
        userBean userBean =new userBean(un,psw);
        System.out.println(aduserService.delUser(userBean));
        model.addAttribute("emps",userService.queryUserList());
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "/emp/adusers";
    }
    @RequestMapping("/admit/adusers")
    public String ausers(HttpSession session, Model model){

        model.addAttribute("emps",userService.queryUserList());
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "/emp/adusers";
    }
}
