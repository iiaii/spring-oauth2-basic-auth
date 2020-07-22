/* Copyright (c) 2020 ZUM Internet, Inc.
 * All right reserved.
 * http://www.zum.com
 * This software is the confidential and proprietary information of ZUM
 * , Inc. You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with ZUM.
 *
 * Revision History
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 *   iiaii                2020-07-22
 */
package me.iiaii.springoauth2.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> listUser() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "success";
    }

}