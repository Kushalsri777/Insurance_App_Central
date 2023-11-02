package com.example.service;

import com.example.dao.InsuranceDao;
import com.example.entities.Company;
import com.example.entities.Policy;
import com.example.entities.User;
import com.example.models.AddPolicyRequest;
import com.example.models.ApplyPolicyRequest;
import com.example.models.ProvideInfoRequest;
import com.example.models.RegisterCompanyRequest;
import com.example.models.UserInfoRequest;
import com.example.repo.CompanyRepository;
import com.example.repo.PolicyRepository;
import com.example.repo.UserRepository;
import com.example.entities.Policy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceDao insuranceDao;
    
    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    // User Operations

    @Override
    public String applyPolicy(ApplyPolicyRequest request) {
    	User user = User.builder()
    			.policyId(request.getPolicyId())
                .userId(request.getUserId())
                .age(request.getAge())
                .city(request.getCity())
                .medicalHistory(request.getMedicalHistory())
                .tobaccoUser(request.isTobaccoUser())
                .alcoholConsumer(request.isAlcoholConsumer())
                .build();

        userRepository.save(user);

        return insuranceDao.applyPolicy(request);
    }

    @Override
    public String provideInfo(UserInfoRequest request) {
    	User user = User.builder()
                .userId(request.getUserId())
                .age(request.getAge())
                .city(request.getCity())
                .medicalHistory(request.getMedicalHistory())
                .tobaccoUser(request.isTobaccoUser())
                .alcoholConsumer(request.isAlcoholConsumer())
                .build();

        userRepository.save(user);

        return insuranceDao.provideInfo(request);
    }
    
    @Override
    public List<Policy> getAllPolicies() {
        return insuranceDao.getAllPolicies();
    }
    // Admin Operations

    @Override
    public String registerCompany(RegisterCompanyRequest request) {
    	Company company = Company.builder()
                .companyName(request.getCompanyName())
                .gstIn(request.getGstIn())
                .build();
    	
        companyRepository.save(company);
        return insuranceDao.registerCompany(request);
    }

    @Override
    public String addPolicy(AddPolicyRequest request) {
    	Policy policy = Policy.builder()
                .policyName(request.getPolicyName())
                .description(request.getDescription())
                .coverageAmount(request.getCoverageAmount())
                .premium(request.getPremium())
                .build();

        policyRepository.save(policy);
        return insuranceDao.addPolicy(request);
    }
    @Override
    public String updatePolicy(int policyId, AddPolicyRequest request) {
        return insuranceDao.updatePolicy(policyId, request);
    }

    // Owner Operations

    @Override
    public String provideInfoToBuyers(ProvideInfoRequest request) {
    	User user = User.builder()
                .userId(request.getUserId())
                .age(request.getAge())
                .city(request.getCity())
                .medicalHistory(request.getMedicalHistory())
                .tobaccoUser(request.isTobaccoUser())
                .alcoholConsumer(request.isAlcoholConsumer())
                .build();

        userRepository.save(user);

        return insuranceDao.provideInfoToBuyers(request);
    }

    @Override
    public String provideInfoToCompanies(ProvideInfoRequest request) {
    	 User user = User.builder()
    	            .userId(request.getUserId())
    	            .age(request.getAge())
    	            .city(request.getCity())
    	            .medicalHistory(request.getMedicalHistory())
    	            .tobaccoUser(request.isTobaccoUser())
    	            .alcoholConsumer(request.isAlcoholConsumer())
    	            .build();

    	    userRepository.save(user);
    	    
    	    return insuranceDao.provideInfoToCompanies(request);
    }
}
