package com.example.expense_tracker;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
public class IncomeRestController {

    private final IncomeService Service;
    private static String user;

    public IncomeRestController(IncomeService Service) {
        this.Service = Service;
    }
    @GetMapping("home")
    public String displayData(Model model) {
        if(!(user.equals(""))){
        model.addAttribute("Income", Service.getAllOrders(user));
        model.addAttribute("User",Service.getAllOrders(user));
        return "home_page";}else{
            return "login";
        }
    }
    @RequestMapping("change")
    public String call(Model model){
        if(!(user.equals(""))){
        model.addAttribute("Income",Service.getAllOrders(user));
        return "change income";}else{
            return "login";
        }
    }

    @GetMapping("login")
    public String log(){
        return "login";
    }

    @PostMapping(value="user",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String login(@RequestBody MultiValueMap<String,String> data){
        user = data.getFirst("username");
        String pass = data.getFirst("password");
        Login p = Service.getPass(user);
        String pas = p.getPassword();
        assert pass != null;
        if(pass.equals(pas) && user.equals((p.getUsername()))){
            return "redirect:/home";
        }else{
            return "invalid";
        }

    }
    @PostMapping(value = "change_add",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String change(@RequestBody MultiValueMap<String, String> data){
        int in = Integer.parseInt(data.getFirst("Income"));
        int sa = Integer.parseInt(data.getFirst("saving"));
        return this.Service.updateOrder(in,sa,user);
    }
    @RequestMapping("tran")
    public String calltran(){
        if(!(user.equals("")))
            return "add transction";
        else
            return "login";
    }
    @PostMapping("add")
    public String trandb(@RequestParam("amount") String amount,
                         @RequestParam("category") String category,
                         @RequestParam("desc") String desc){
        return this.Service.createNewTransaction(amount,category,desc,user);
    }
    @GetMapping("history")
    public String his(Model model){
        if(!(user.equals(""))){
        model.addAttribute("Transaction", Service.getAllTrans(user));
        return "transction history";}else{
            return "login";
        }
    }

    @PostMapping("del")
    public String del(@RequestParam("id") String id){
        return this.Service.delTran(Integer.parseInt(id),user);
    }
    @GetMapping("out")
    public String out(){
        user ="";
        return "logout";
    }
    @PostMapping("gen_rep")
    public String genR(){
        return this.Service.getreport(user);
    }
    @RequestMapping("report")
    public String put(Model model) {
        if(!(user.equals(""))){
        model.addAttribute("Report", this.Service.findrep(user));
        return "report";}else{
            return "login";
        }
    }
}