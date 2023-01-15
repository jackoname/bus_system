package com.bus.oyhj.controller;


import com.bus.oyhj.mapper.AduserMapper;
import com.bus.oyhj.mapper.BusMapper;
import com.bus.oyhj.mapper.UserMapper;
import com.bus.oyhj.pojo.admitBean;
import com.bus.oyhj.pojo.busBean;
import com.bus.oyhj.pojo.busStationBean;

import com.bus.oyhj.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Controller
public class busController {
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
    @RequestMapping("/station/show")
    public String sshow(HttpSession session, Model model){
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        List<busStationBean> busStationBean= busService.queryUserListSta();
        for (int  i= 0;  i<busStationBean.size() ;i++) {
            System.out.println(busStationBean.get(i).toString());
        }
        model.addAttribute("stas",busStationBean);
        return "station/showstation";
    }
    @RequestMapping("/station/modif")
    public String smodif(HttpSession session, Model model, @RequestParam(name="busid",required = false, defaultValue = "0") Integer busid,
                         @RequestParam(name="order",required = false, defaultValue = "0") Integer order,
                         @RequestParam(name="stationname",required = false) String stationname){
        busStationBean busStationBean=new busStationBean(order,busid,stationname);
        if(busid!=0&&order!=0){
            System.out.println(busService.updateSta(busStationBean));}
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "station/modifstation";
    }
    @RequestMapping("/station/add")
    public String sadd(HttpSession session, Model model,
    @RequestParam(name="busid",required = false, defaultValue = "0") Integer busid,
                       @RequestParam(name="order",required = false,defaultValue = "0") Integer order,
                       @RequestParam(name="stationname",required = false) String stationname){

        int max=1;
        if(busid!=0) {
            List<busStationBean> busStationBeans = busService.queryUserListbySid(busid);
            busStationBeans.sort(Comparator.comparing(busStationBean::getOrder).reversed());
            System.out.println(busStationBeans.size() + "=======");
            max = busStationBeans.get(0).getOrder() + 1;
            //int max=5;
        }
      System.out.println("max:"+max+"  =============    "+"order:"+order);
        model.addAttribute("myseeion", session.getAttribute("loginUser"));
        if(order>0&&order<=max) {
            if(max!=order) {
                busStationBean b = new busStationBean();
                b.setBusid(busid);
                b.setOrder(order);
                System.out.println(busService.updateStaBadd(b) + "        11111111");
            }
            busStationBean buss = new busStationBean(order, busid, stationname);
            if (busid != 0 && order != 0) {
                System.out.println(busService.addBusStations(buss));
            }

            List<busStationBean> busStationBean = busService.queryUserListSta();
            List<busBean> busbeans = busService.queryUserList();
            setBus(busbeans, busStationBean);
            return "station/addstation";
        }
        else if(order<=0||max<order){
            model.addAttribute("error", "输入的站点序号不合法！！");
            return "error";
        }

        return "station/addstation";
    }

    @RequestMapping("/station/del")
    public String sdel(HttpSession session, Model model,
                       @RequestParam(name="busid",required = false, defaultValue = "0") Integer busid,
                       @RequestParam(name="order",required = false,defaultValue = "0") Integer order,
                       @RequestParam(name="stationname",required = false) String stationname){
        busStationBean b=new busStationBean();
        b.setBusid(busid);b.setOrder(order);
        if(busid!=0&&order!=0){
            System.out.println(busService.delBusStations(b));
            System.out.println(busService.updateStaBdel(b));}

        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        List<busStationBean> busStationBean= busService.queryUserListSta();
        List<busBean>busbeans=busService.queryUserList();
        setBus(busbeans,busStationBean);
        return "station/delstation";
    }
    @RequestMapping("/bus/add")
    public String badd(HttpSession session, Model model,
                       @RequestParam(name="busid",required = false,defaultValue = "0") Integer busid, @RequestParam(name="busbgo",required = false) String busbgo,
                       @RequestParam(name="busego",required = false) String busego, @RequestParam(name="begin",required = false) String begin,
                       @RequestParam(name="end",required = false) String end, @RequestParam(name="busno",required = false) String busno   ){
        busBean bus =new busBean(busid,begin, end, busbgo, busego,busno);

        if(busid!=0){
            System.out.println(busService.addBus(bus));}
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        List<busStationBean> busStationBean= busService.queryUserListSta();
        List<busBean>busbeans=busService.queryUserList();
        setBus(busbeans,busStationBean);
        return "bus/addbus";
    }

    @RequestMapping("/bus/modif")
    public String bmodif(HttpSession session, Model model,
                         @RequestParam(name="busid",required = false,defaultValue = "0") Integer busid, @RequestParam(name="busbgo",required = false) String busbgo,
                         @RequestParam(name="busego",required = false) String busego, @RequestParam(name="begin",required = false) String begin,
                         @RequestParam(name="end",required = false) String end, @RequestParam(name="busno",required = false) String busno  ){
        busBean bus =new busBean(busid,begin, end, busbgo, busego,busno);
        if(busid!=0){
            System.out.println(busService.updateBus(bus));}
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        return "bus/modifbus";
    }

    @RequestMapping("/bus/del")
    public String bdel(HttpSession session, Model model,@RequestParam(name="busno",required = false) String busno){
        model.addAttribute("myseeion",session.getAttribute("loginUser"));
        busBean bus =new busBean();
        bus.setBusno(busno);
        System.out.println(busService.delBus(bus));
        List<busStationBean> busStationBean= busService.queryUserListSta();
        List<busBean>busbeans=busService.queryUserList();
        setBus(busbeans,busStationBean);
        return "bus/delbus";
    }

    @RequestMapping("/bus/search")
    public String search(Model model,@RequestParam(name="keyword") String keyword){
        int i=Integer.valueOf(keyword);
        try {
            if (Integer.valueOf(keyword) == null)
                i = 0;
            model.addAttribute("msg", "hello word");
            busBean bus = new busBean(i, keyword, keyword, keyword, keyword, keyword);
            List<busBean> busBeans = busService.queryUserListByinf(bus);
            model.addAttribute("emps", busBeans);
        }catch (Exception e){
            model.addAttribute("error","请输入数字！！");
            return "error";
        }
        return "success";
    }
    @RequestMapping("/bus/adsearch")
    public String adsearch(Model model,@RequestParam(name="keyword") String keyword){
        int i=Integer.valueOf(keyword);
        try {
            if (Integer.valueOf(keyword) == null)
                i = 0;
            model.addAttribute("msg", "hello word");
            busBean bus = new busBean(i, keyword, keyword, keyword, keyword, keyword);
            List<busBean> busBeans = busService.queryUserListByinf(bus);
            model.addAttribute("emps", busBeans);
        }catch (Exception e){
            model.addAttribute("error","请输入数字！！");
            return "error";

        }
        return "emp/adindex";
    }
}
