package com.sound.cloud.api.soundTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewRepresentationController {

    @RequestMapping({"", "/", "/index"})
    public String mainPageRepresentation() {
        return "home";
    }

    @GetMapping("/tracks")
    public String tracksPageRepresentation(Model model) {
        return "tracks";
    }

}
