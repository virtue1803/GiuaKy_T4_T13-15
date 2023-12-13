package org.spring.testspring.services.impl;

import org.spring.testspring.models.Experience;
import org.spring.testspring.repositories.ExperienceRepository;
import org.spring.testspring.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienceSerivce implements IServices<Experience, Long> {
    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceSerivce(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public boolean save(Experience entity) {
        experienceRepository.save(entity);
        return true;
    }

    @Override
    public boolean delete(Experience entity) {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }

    @Override
    public Optional<Experience> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Experience> findAll() {
        return null;
    }

    public List<Experience> findAllByCompanyName(String companyName) {
        return experienceRepository.findAllByCompanyName(companyName);
    }

    public List<Experience> findCandidatesWithAtLeast5Years(){
        List<Experience> experiences = experienceRepository.findAll();
        List<Experience> result = new ArrayList<Experience>();

        for(Experience experience : experiences) {
            if((experience.getToDate().getYear() - experience.getFromDate().getYear()) >= 5) {
                result.add(experience);
            }
        }

        return result;
    }
}
