package org.cogip.cogiprestapi.controllers;

import org.cogip.cogiprestapi.model.Company;
import org.cogip.cogiprestapi.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public String storeCompany(@RequestBody Company company){
        return companyService.storeCompany(company);
    }

    @GetMapping
    public List<Company> findCompanies(){
        return companyService.findAllCompanies();
    }

    @GetMapping("/{id}")
    public Company findCompanyById(@PathVariable("id") String id){
        return companyService.findCompanyById(Integer.valueOf(id));
    }

    @PutMapping("/{id}")
    public String updateCompany(@PathVariable("id") String id,@RequestBody Company company){
        return companyService.updateCompany(Integer.valueOf(id), company);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable("id") String id){
        return companyService.deleteCompany(Integer.valueOf(id));
    }

}
