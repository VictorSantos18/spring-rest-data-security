package br.edu.fatecsjc.lgnspringapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatecsjc.lgnspringapi.entity.Organization;
import br.edu.fatecsjc.lgnspringapi.repository.OrganizationRepository;

@Service
public class OrganizationService {

  private final OrganizationRepository repository;

  public OrganizationService(OrganizationRepository repository) {
    this.repository = repository;
  }

  public List<Organization> findAll() {
    return repository.findAll();
  }

  public Optional<Organization> findById(Long id) {
    return repository.findById(id);
  }

  public Organization save(Organization organization) {
    return repository.save(organization);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}