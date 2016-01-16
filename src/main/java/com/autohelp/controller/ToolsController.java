package com.autohelp.controller;

import com.autohelp.model.AppointmentsModel;
import com.autohelp.model.AppointmentsRepository;
import com.autohelp.model.PriceModel;
import com.autohelp.model.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jek on 10.01.16.
 */
@Controller
public class ToolsController
{
    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Autowired
    private PriceRepository priceRepository;

    @RequestMapping("/tools")
    public String tools()
    {
        return "redirect:/tools/priceView";
    }

    @RequestMapping(value="/tools/priceView", method= RequestMethod.GET)
    public String priceToolGet(Model model)
    {
        Iterable<PriceModel> priceModels = priceRepository.findAll();
        model.addAttribute("price", priceModels);
        return "tools/priceView";
    }

    @RequestMapping(value="/tools/priceEdit", method= RequestMethod.GET)
    public String priceForm(Model model) {
        model.addAttribute("price", new PriceModel());
        return "tools/priceEdit";
    }

    @RequestMapping(value="/tools/priceEdit", method=RequestMethod.POST)
    public String priceSubmit(@ModelAttribute PriceModel price, Model model) {
        model.addAttribute("price", price);
        priceRepository.save(price);
        return "redirect:/tools/priceView";
    }

    @RequestMapping("/tools/priceDelete")
    public String priceToolDeleteGet(@RequestParam(value="id", required=false) long id, Model model)
    {
        priceRepository.delete(id);
        return "redirect:/tools/priceView";
    }

    @RequestMapping(value="/tools/appointmentsTool", method= RequestMethod.GET)
    public String appointmentsTool(Model model)
    {
        Iterable<AppointmentsModel> appointmentsModels = appointmentsRepository.findAll();
        model.addAttribute("appointmentsTool", appointmentsModels);
        return "tools/appointmentsTool";
    }

    @RequestMapping("/tools/appointmentsToolDelete")
    public String appointmentsToolDeleteGet(@RequestParam(value="id", required=false) long id, Model model)
    {
        appointmentsRepository.delete(id);
        return "redirect:/tools/appointmentsTool";
    }

    @RequestMapping(value="/tools/login", method= RequestMethod.GET)
    public String loginGet(Model model)
    {
        model.addAttribute("login");
        return "tools/login";
    }

    @RequestMapping(value="/tools/login", method=RequestMethod.POST)
    public String loginPost(Model model)
    {
        return "redirect:tools/priceView";
    }
}
