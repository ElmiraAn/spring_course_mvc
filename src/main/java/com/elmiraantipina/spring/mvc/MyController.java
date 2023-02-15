package com.elmiraantipina.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

//import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")//при адресе "/" будет срабатывать данный метод, который будет отображать first-view.jsp
    public String showFirstView() {
        return "first-view";//имя нашего view
    }

    /*@RequestMapping("/askDetails")//при адресе "/askDetails" будет срабатывать данный метод,
    // который будет отображать ask-emp-details-view.jsp
    public String askEmployeeDetails(){
        return "ask-emp-details-view";//имя нашего view
    }*/
    @RequestMapping("/askDetails")//при адресе "/askDetails" будет срабатывать данный метод,
    // который будет отображать ask-emp-details-view.jsp
    public String askEmployeeDetails(Model model) {
        Employee emp = new Employee();
        /*emp.setName("Ivan");
        emp.setSurname("Petrov");
        emp.setSalary(500);
        model.addAttribute("employee", emp);*/
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";//имя нашего view
    }

    @RequestMapping("/showDetails")//при адресе "/showDetails" будет срабатывать данный метод,
    // который будет отображать show-emp-details-view.jsp
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp
            , BindingResult bindingResult) { //добавляем параметр, чтобы получить из View данные
        //@Valid означает, что наш аттрибут подвергается проверке(валидации), результат валидации будет
        //помещен в BindingResult

        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";
        }
    }
        /*String name = emp.getName();
        emp.setName("Mr "+name);
        String surname = emp.getSurname();
        emp.setSurname(surname+"!");
        int salary = emp.getSalary();
        emp.setSalary(salary*10);
        return "show-emp-details-view";//имя нашего view*/



    /*@RequestMapping("/showDetails")//при адресе "/showDetails" будет срабатывать данный метод,
    // который будет отображать show-emp-details-view.jsp
    public String showEmpDetails(){
        return "show-emp-details-view";//имя нашего view
    }*/

   /* @RequestMapping("/showDetails")//при адресе "/showDetails" будет срабатывать данный метод,
    // который будет отображать show-emp-details-view.jsp
    public String showEmpDetails(HttpServletRequest request,
                                 Model model){ //добавляем параметр, чтобы получить из View данные

        String empName = request.getParameter("employeeName"); //получили имя, указываем такое имя как было в jsp-файле

                empName = "Mr. "+empName;
        model.addAttribute("nameAttribute", empName);//добавляем атрибут в модель
        model.addAttribute("description", " - stepik student");

        return "show-emp-details-view";//имя нашего view
    }*/
    /*@RequestMapping("/showDetails")//при адресе "/showDetails" будет срабатывать данный метод,
    // который будет отображать show-emp-details-view.jsp
    public String showEmpDetails(@RequestParam("employeeName") String empName,
                                 Model model){ //добавляем параметр, чтобы получить из View данные

        empName = "Mr. "+empName+"!";
        model.addAttribute("nameAttribute", empName);//добавляем атрибут в модель

        return "show-emp-details-view";//имя нашего view
    }*/

}
