package com.example.accesskeybackend.utils.IPv6Validator.controller;

import com.example.accesskeybackend.utils.IPv6Validator.dto.IPv6DTO;
import com.example.accesskeybackend.utils.IPv6Validator.service.IPv6Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/web")
public class IPv6ValidatorController {


    public IPv6ValidatorController(IPv6Service iPv6Service) {
        this.iPv6Service = iPv6Service;
    }


    IPv6Service iPv6Service;
    @GetMapping("/checkIpv6Support")
    public IPv6DTO ipv6Validator(@RequestParam String siteUrl) {
        IPv6DTO iPv6DTO = new IPv6DTO();
        iPv6DTO.setURL(siteUrl);
        iPv6DTO.setSuccessful(iPv6Service.validate(siteUrl));
        return iPv6DTO;
    }
}
