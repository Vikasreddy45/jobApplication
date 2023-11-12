package com.jobapplication.jobapplication.companies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {


    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        companyService.updateCompany(id, company);
        return new ResponseEntity<>("Company Updated", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompanies(@RequestBody Company company){
        companyService.createCompanies(company);
        return new ResponseEntity<>("Company Added",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){

        boolean isDeleted = companyService.deleteCompany(id);
        if (isDeleted){
            return new ResponseEntity<>("Company Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(Long id){

        Company company = companyService.getCompanyById(id);

        if(company != null)
            return new ResponseEntity<>(company,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
