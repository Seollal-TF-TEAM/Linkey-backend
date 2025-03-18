package com.linkey.core.controller;


import com.linkey.core.domain.entity.Sprint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/sprints")
public class SprintController {

    @GetMapping("")
    public List<Sprint> getAllSprints() {
        return null;
    }

    @PostMapping("/create")
    public boolean createSprint(){//@RequestParam String name, @RequestParam int year) {
        return false;

    }


}
