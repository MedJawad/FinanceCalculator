package com.example.financecalculator.service;

import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.springframework.stereotype.Service;


@Service
public class TAEGService {

    public double calculateIRR(double[] cashFlows, double guess) {
        UnivariateFunction irrFunction = rate -> {
            double npv = 0.0;
            for (int i = 0; i < cashFlows.length; i++) {
                npv += cashFlows[i] / Math.pow(1 + rate, i);
            }
            return npv;
        };

        UnivariateSolver solver = new BrentSolver(1e-10, 1e-14);
        return solver.solve(1000, irrFunction, guess - 1, guess + 1);
    }

    public double calculateTAEG(double[] cashFlows, double power) {
        double irr = calculateIRR(cashFlows, 0.09);
        return Math.pow(1 + irr, power) - 1;
    }
}
