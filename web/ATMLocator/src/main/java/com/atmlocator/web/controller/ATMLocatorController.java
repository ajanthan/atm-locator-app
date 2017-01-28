package com.atmlocator.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.atmlocator.web.from.FindATM;

@Controller
public class ATMLocatorController {

    private static final String INTEGRATION_SERVER_EP = "http://localhost:8280/";
    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showATMForm(Model model) {
        System.out.println("######");
        FindATM user = new FindATM();
        model.addAttribute("findATMform", user);
        return "atmlocator";
    }

    @RequestMapping(value = "/findatm", method = RequestMethod.POST)
    public ModelAndView saveOrUpdateUser(@ModelAttribute("findATMform") FindATM findATM, BindingResult bindResult,
            Model model) {
        ModelAndView mod = new ModelAndView();
        System.out.println(
                "Submitted...#######.." + findATM.getZipcode() + "|" + findATM.getLag() + "|" + findATM.getLat());
        mod.setViewName("atmlocator");
        mod.addObject("msg", findATM.getZipcode());
        String result = "";
        if (!findATM.getZipcode().isEmpty()) {
            System.out.println("find atm with zip code");
            result = restTemplate.getForObject(INTEGRATION_SERVER_EP + "atmlocator/zip/" + findATM.getZipcode(),
                    String.class, "42", "21");
        } else if(!findATM.getLat().isEmpty() && !findATM.getLag().isEmpty()) {
            System.out.println("find atm with coordination");
            result = restTemplate.getForObject(INTEGRATION_SERVER_EP + "/atmlocator/coordination/" + findATM.getLag()+"/"+findATM.getLat(),
                    String.class, "42", "21");

        }

        mod.addObject("mapResuls", result);
        System.out.println("MS4J" + result);
        return mod;
    }

    @RequestMapping(value = "/findatm/{zipcode:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView findatmAPI(@PathVariable("zipcode") String zipcode) {

        ModelAndView model = new ModelAndView();
        model.setViewName("atmlocator");
        model.addObject("msg", zipcode);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(INTEGRATION_SERVER_EP + "atmlocator/" + zipcode, String.class, "42",
                "21");
        model.addObject("mapResuls", result);
        System.out.println("MS4J" + result);
        return model;

    }

}