/* Copyright 2017 Unity{Cloud}Ware - UCW Industries Ltd. All rights reserved.
 */
package com.unitycloudware.portal.tutorial.helloworld.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.nsys.portal.controller.AbstractPortalController;

/**
 * HelloWorldController
 *
 * @author Jonáš Václavek <vaclavek@unitycloudware.com>
 * @see <a href="http://unitycloudware.com">Unity{Cloud}Ware</a>
 */
@Controller
@RequestMapping("/ucw-helloworld")
public class HelloWorldController extends AbstractPortalController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPage(final HttpServletRequest request, final HttpServletResponse response) {
        Map<String, Object> context = new HashMap<>();
        return render("/templates/helloworld-page.vm", context, request, response);
    }
}
