package org.example.service;

import org.example.dto.Student;
import org.example.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private Studentrepository studentrepository;


}
