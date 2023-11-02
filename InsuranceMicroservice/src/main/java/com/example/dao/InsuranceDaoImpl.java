package com.example.dao;

import com.example.models.AddPolicyRequest;
import com.example.models.ApplyPolicyRequest;
import com.example.models.ProvideInfoRequest;
import com.example.models.RegisterCompanyRequest;
import com.example.models.UserInfoRequest;
import com.example.repo.PolicyRepository;
import com.example.entities.Policy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InsuranceDaoImpl implements InsuranceDao {
	@Autowired
    private PolicyRepository policyRepository;
    // User Operations

    @Override
    public String applyPolicy(ApplyPolicyRequest request) {
        return "Policy applied for user ";
    }

    @Override
    public String provideInfo(UserInfoRequest request) {
        return "Information provided for user ";
    }
//    @Override
//    public List<String> getAddOnFeatures(int policyId) {
//        // Implementation for getting add-on features
//    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }
    // Admin Operations

    @Override
    public String registerCompany(RegisterCompanyRequest request) {
        return "Company registered: ";
    }

    @Override
    public String addPolicy(AddPolicyRequest request) {
        return "Policy added: ";
    }
    @Override
    public String updatePolicy(int policyId, AddPolicyRequest request) {
    	 Optional<Policy> optionalPolicy = policyRepository.findUpdatePolicyByPolicyId((int) policyId);

    	    if (optionalPolicy.isPresent()) {
    	        Policy existingPolicy = optionalPolicy.get();

    	        // Update policy fields
    	        existingPolicy.setPolicyName(request.getPolicyName());
    	        existingPolicy.setDescription(request.getDescription());
    	        existingPolicy.setCoverageAmount(request.getCoverageAmount());
    	        existingPolicy.setPremium(request.getPremium());

    	        // Save the updated policy
    	        policyRepository.save(existingPolicy);

    	        return "Policy updated with ID: " + policyId;
    	    } else {
    	        return "Policy with ID " + policyId + " not found.";
    	    }
    }


    // Owner Operations

    @Override
    public String provideInfoToBuyers(ProvideInfoRequest request) {
        return "Information provided to buyers for policy ";
    }

    @Override
    public String provideInfoToCompanies(ProvideInfoRequest request) {
        return "Information provided to companies for policy ";
    }
}
