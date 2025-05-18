package com.example.customermanagement.service;

import com.example.customermanagement.model.FamilyMember;
import com.example.customermanagement.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyMemberService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    public FamilyMember createFamilyMember(FamilyMember familyMember) {
        return familyMemberRepository.save(familyMember);
    }

    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberRepository.findAll();
    }

    public Optional<FamilyMember> getFamilyMemberById(Long id) {
        return familyMemberRepository.findById(id);
    }

    public FamilyMember updateFamilyMember(Long id, FamilyMember familyMemberDetails) {
        Optional<FamilyMember> familyMemberOptional = familyMemberRepository.findById(id);

        if (familyMemberOptional.isPresent()) {
            FamilyMember familyMember = familyMemberOptional.get();
            familyMember.setName(familyMemberDetails.getName());
            familyMember.setRelation(familyMemberDetails.getRelation());
            familyMember.setCustomer(familyMemberDetails.getCustomer());
            return familyMemberRepository.save(familyMember);
        } else {
            throw new RuntimeException("Family Member not found with id: " + id);
        }
    }

    public void deleteFamilyMember(Long id) {
        familyMemberRepository.deleteById(id);
    }
}
