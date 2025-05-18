package com.example.customermanagement.controller;

import com.example.customermanagement.model.FamilyMember;
import com.example.customermanagement.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/family-members")
@CrossOrigin(origins = "*")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberService familyMemberService;

    // ➡️ Create a new family member
    @PostMapping
    public FamilyMember createFamilyMember(@RequestBody FamilyMember familyMember) {
        return familyMemberService.createFamilyMember(familyMember);
    }

    // ➡️ Get all family members
    @GetMapping
    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberService.getAllFamilyMembers();
    }

    // ➡️ Get a family member by ID
    @GetMapping("/{id}")
    public Optional<FamilyMember> getFamilyMemberById(@PathVariable Long id) {
        return familyMemberService.getFamilyMemberById(id);
    }

    // ➡️ Update a family member
    @PutMapping("/{id}")
    public FamilyMember updateFamilyMember(@PathVariable Long id, @RequestBody FamilyMember familyMember) {
        return familyMemberService.updateFamilyMember(id, familyMember);
    }

    // ➡️ Delete a family member
    @DeleteMapping("/{id}")
    public void deleteFamilyMember(@PathVariable Long id) {
        familyMemberService.deleteFamilyMember(id);
    }
}
