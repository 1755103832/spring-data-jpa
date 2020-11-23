package com.baosight.bin.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author zyb
 * @Date Create in 2020/10/12 14:40
 * @Description
 **/
@Controller
public class JumpController {

    @GetMapping("/a")
    public String turn2excel() {
        return "export_excel";
    }

    @GetMapping("/")
    public String turn2echarts() {
        return "echarts_demo";
    }

    @GetMapping("/vue")
    public String turn2vue() {
        return "vue_data";
    }

    @GetMapping("/vueDemo")
    public String turn2vueD() {
        return "vue_demo";
    }
}
