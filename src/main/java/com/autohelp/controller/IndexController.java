package com.autohelp.controller;

import com.autohelp.model.AppointmentsModel;
import com.autohelp.model.AppointmentsRepository;
import com.autohelp.model.PriceModel;
import com.autohelp.model.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by jek on 20.12.15.
 */
@Controller
public class IndexController
{
    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Autowired
    private PriceRepository priceRepository;

    @RequestMapping("/")
    public String start()
    {
        return "redirect:/index";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/index")
    public String index()
    {
       // throw new IOException("finish");
        return "index";
    }

    @RequestMapping("/contact")
    public String contact()
    {
        return "contact";
    }

    @RequestMapping(value="/appointments", method= RequestMethod.GET)
    public String appointmentsForm(Model model) {
        model.addAttribute("appointments", new AppointmentsModel());
        return "appointments";
    }

    @RequestMapping(value="/appointments", method=RequestMethod.POST)
    public String appointmentsSubmit(@ModelAttribute AppointmentsModel appointments, Model model) {
        model.addAttribute("appointments", appointments);
        appointmentsRepository.save(appointments);
        return "appointmentsResult";
    }

    @RequestMapping(value="/price", method= RequestMethod.GET)
    public String priceView(Model model)
    {
        Iterable<PriceModel> priceModels = priceRepository.findAll();
        model.addAttribute("price", priceModels);
        return "price";
    }

    @RequestMapping(value="/price", method= RequestMethod.POST)
    public String pricePost(Model model)
    {
        return "price";
    }

//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "IOException exception! check arguments!")
//    @ExceptionHandler(value ={Exception.class})
//    public void handleIOException() {
//
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleIOException(IOException exception) {
//        ModelAndView modelAndView = new ModelAndView("/catchedException");
//        modelAndView.addObject("message", exception.getMessage());
//        return modelAndView;
//    }
}
