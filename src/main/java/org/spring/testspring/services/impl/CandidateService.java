package org.spring.testspring.services.impl;

import org.spring.testspring.models.Candidate;
import org.spring.testspring.repositories.CandidateRepository;
import org.spring.testspring.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements IServices<Candidate, Long> {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public boolean save(Candidate entity) {
        candidateRepository.save(entity);
        return true;
    }

    @Override
    public boolean delete(Candidate entity) {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }

    @Override
    public Optional<Candidate> findById(Long aLong) {
        return candidateRepository.findById(aLong);
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }
}
