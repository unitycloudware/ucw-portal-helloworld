/* Copyright 2017 Unity{Cloud}Ware - UCW Industries Ltd. All rights reserved.
 */

package com.unitycloudware.portal.tutorial.helloworld.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.nsys.portal.controller.AbstractPortalController;

/**
 * Hello World Controller
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://unitycloudware.com">Unity{Cloud}Ware</a>
 */
@Controller
@RequestMapping("/ucw-helloworld")
public class HelloWorldController extends AbstractPortalController {

    public static final String DISPLAY_NAME = "UCW Hello World";
    public static final String LOCATION_HEADER_ACTIONS = "ucw.tutorial.helloworld.header.actions";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showDefaultPage(
            final HttpServletRequest request,
            final HttpServletResponse response) {

        return new ModelAndView("redirect:/ucw-helloworld/page");
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView showPage(
            final HttpServletRequest request,
            final HttpServletResponse response) {

        String imageUri = getResourceUrl("/resources/images/ucw_logo.png", request);
        String msg = "Greetings from UCW Hello World!";

        Map<String, Object> context = new HashMap<String, Object>();
        context.put("msg", msg);

        setDisplayName(DISPLAY_NAME);
        showHeader(imageUri, LOCATION_HEADER_ACTIONS, null);

        return render("/templates/helloworld-page.vm", context, request, response);
    }
}