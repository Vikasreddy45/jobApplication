package com.jobapplication.jobapplication.companies;

import com.jobapplication.jobapplication.job.Job;
import com.jobapplication.jobapplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    public boolean updateCompany(Long id, Company company){

        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {
            Company company1 = companyOptional.get();
            company1.setDescription(company.getDescription());
            company1.setName(company.getName());
            company1.setJobs(company.getJobs());
            companyRepository.save(company1);
            return true;
        }
        return false;

    }

    public void createCompanies(Company company){

        companyRepository.save(company);
    }

    public boolean deleteCompany(Long id){

        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public  Company getCompanyById(Long id){
        return companyRepository.findById(id).orElse(null);
    }

}
