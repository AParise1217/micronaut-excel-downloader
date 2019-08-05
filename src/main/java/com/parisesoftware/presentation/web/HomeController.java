package com.parisesoftware.presentation.web;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    public HomeController() {}

    @View("index")
    @Get
    Map<String, String> index() {
        return new HashMap<>();
    }

}
