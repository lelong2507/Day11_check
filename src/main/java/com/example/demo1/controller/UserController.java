package com.example.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.User;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Note
/**
 * Note 1
 * Hai Annotation: Controller và RestController
 * Giống nhau: Giúp mình đăng kí đường dẫn
 * Khác nhau: Giá trị trả ra của Controller là một file html
 * Còn giá trị trả ra của RestController là một dạng chuỗi
 * 
 * @Controller + @ResponseBody : Return HTML file || String
 * @RestController: Return String
 */

/**
 * Note 2
 * RESTful Api
 * @PathVariable, @RequestParam
 * @RequestBody, @ReponseBody
 * 
 * @RestController
 *                 1. @PathVariable: Được sử dụng để xử lý những URI động có một
 *                 hoặc nhiều parameter bên trong URI
 */

/**
 * ORM là gì?
 * ORM là một database ảo
 */

@RestController
@RequestMapping("/users") // Annotation này giúp mình đăng kí đường dẫn (Register URL)
public class UserController {

    @GetMapping("/getAllUser")
    public String handleShowAllUser() {
        return "Hello getAllUser";
    }

    @GetMapping("/add")
    public String handleShowAddUser(@RequestParam String userName, @RequestParam int id) {
        return "Hello Add User " + userName + " - " + id;
    }

    @GetMapping("/getDetailUser/{id}/{username}")
    public String handleGetDetailUserById(@PathVariable int id, @PathVariable String username) {
        return "Hello User " + username + " with id: " + id;
    }

    @PostMapping("/update")
    public String handleUpdate(@RequestBody List<User> userList) {
        if (userList.size() > 0) {
            for (User user : userList) {
                System.out.println(user.getUserName() + " - " + user.getPassWord() + " - " + user.getId());
            }
        }
        return "Something null";
    }

}
