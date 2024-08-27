package com.example.financecalculator.controllers;

import com.example.financecalculator.service.TAEGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TAEGController {

    private final TAEGService taegService;

    @Autowired
    public TAEGController(TAEGService taegService) {
        this.taegService = taegService;
    }

    @GetMapping("/calculate-taeg")
    public double calculateTAEG(@RequestParam double[] cashFlows, @RequestParam double power) {
        return taegService.calculateTAEG(cashFlows, power);
    }
}
