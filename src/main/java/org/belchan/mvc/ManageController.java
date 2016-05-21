package org.belchan.mvc;

import org.belchan.entity.Staff;
import org.belchan.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/manage/")
public class ManageController {

    @Autowired
    StaffService staffService;

    @RequestMapping(
            value = {"crud/staff"},
            method = {RequestMethod.GET}
    )
    public @ResponseBody
    List<Staff> get(HttpServletRequest request, HttpServletResponse response) {
        return staffService.get();
    }

    @RequestMapping(
            value = {"crud/staff/{username}"},
            method = {RequestMethod.GET}
    )
    public @ResponseBody
    List<Staff> findByUserName(@PathVariable("username") String username) {
        return staffService.findByUsername(username);
    }
}
