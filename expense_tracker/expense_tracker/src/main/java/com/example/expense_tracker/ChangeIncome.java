package com.example.expense_tracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/submitForm")
public class ChangeIncome {

    @PostMapping
    public Income submitForm(@ModelAttribute Income income) {
        // Handle the form data object here
        System.out.println("Received form data: " + income);

        // Perform further processing, validation, or store the data in a database

        // Redirect to a success page or return a response
        return income; // Assuming you have a success.html template
    }
}
