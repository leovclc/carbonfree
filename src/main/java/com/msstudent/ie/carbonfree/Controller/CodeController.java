package com.msstudent.ie.carbonfree.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/codes")
public class CodeController {

    private Set<String> generatedCodes = new HashSet<>();

    @GetMapping("/generate")
    @ResponseStatus(HttpStatus.CREATED)
    public String generateCode() {
        String code = generateRandomCode();
        generatedCodes.add(code);
        return code;
    }

    private String generateRandomCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int codeLength = 8;
        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder();

        while (codeBuilder.length() < codeLength) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            codeBuilder.append(randomChar);
        }

        String code = codeBuilder.toString();
        if (generatedCodes.contains(code)) {
            // If the code is already generated, recursively call the method to generate a new one
            return generateRandomCode();
        }

        return code;
    }
}

