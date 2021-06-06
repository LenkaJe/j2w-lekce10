package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.service.SkolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SkolaController {
    private final SkolaService skolaService;

    @Autowired
    public SkolaController(SkolaService skolaService) {
        this.skolaService = skolaService;
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznamTrid")
                .addObject("trida", skolaService.seznamTrid());
    }

    @GetMapping("/detailTridy")
    public String form(short id) {
        return String.format("redirect:/detailTridy/%s", id);
    }

    @GetMapping("/detailTridy/{id}")
    public ModelAndView detailTridy(@PathVariable short id) {
        return new ModelAndView("tridaDetail")
                .addObject("trida", skolaService.detailTridy(id));

    }

    @GetMapping("/detailStudenta")
    public String form(Integer id) {
        return String.format("redirect:/detailStudenta/%s", id);
    }

    @GetMapping("/detailStudenta/{id}")
    public ModelAndView detailTridy(@PathVariable Integer id) {
        return new ModelAndView("studentDetail")
                .addObject("student", skolaService.detailStudenta(id));

    }
}
