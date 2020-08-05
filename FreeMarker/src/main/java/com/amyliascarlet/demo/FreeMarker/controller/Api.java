package com.amyliascarlet.demo.FreeMarker.controller;

import com.alibaba.fastjson.JSON;
import com.amyliascarlet.demo.FreeMarker.service.FreeMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Api {

    @Autowired
    private FreeMarkerService freeMarkerService;


    @PostMapping("/Set")
    public Integer Set(@RequestParam String tname,@RequestParam String params) {
        freeMarkerService.genTemplate(tname,(Map)JSON.parse(params));
        return 1;
    }



}
