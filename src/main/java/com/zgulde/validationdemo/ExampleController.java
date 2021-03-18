package com.zgulde.validationdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class ExampleController implements WebMvcConfigurer {


    @GetMapping("/")
    public String index(ExampleForm exampleForm) {
        return "index";
    }

    @PostMapping("/")
    public String submit(@Valid ExampleForm exampleForm, BindingResult result, RedirectAttributes redirectAttributes) {
        if (exampleForm.getName().equalsIgnoreCase("cody")) {
            String message = "I said your name can't be Cody!";
            result.rejectValue("name", "exampleForm.name", message);
        }
        if (result.hasErrors()) {
            return "index";
        }
        redirectAttributes.addFlashAttribute(
            "flashMessage",
            String.format("Success! Welcome, %s!", exampleForm.getName())
        );
        return "redirect:/?success";
    }


}
