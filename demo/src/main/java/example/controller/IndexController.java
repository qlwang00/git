package example.controller;

import example.dao.UserDao;
import example.entiy.User;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/home")
public class IndexController {

    @Autowired
    private UserService ser;

    @RequestMapping("/test")
    public String index(Model model) {
        List<User> list=ser.getUsers();
        model.addAttribute("users",list);
        return "index";
    }

    @RequestMapping("/Add")
    public String Add(){
        return "Add";
    }

    @RequestMapping("/AddUser")
    public String AddUser(@ModelAttribute("form") User us){
        ser.Add(us);
        return "redirect:test";
    }

    @RequestMapping("/Delete")
    public String delete(HttpServletRequest request){
        String id=request.getParameter("id");
        System.out.println(id);
        ser.Delete(id);
        return "redirect:test";
    }

    @RequestMapping("/Update")
    public String update(HttpServletRequest request,Model model){
        String id=request.getParameter("id");
        List<User> list=ser.findUser(id);
        model.addAttribute("users",list);
        return "Update";
    }

    @RequestMapping("/UpdateUser")
    public String updateUser(@ModelAttribute("form") User us){
        ser.update(us);
        return "redirect:test";
    }
}
