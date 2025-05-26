package br.edu.fatecsjc.lgnspringapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatecsjc.lgnspringapi.entity.Marathon;
import br.edu.fatecsjc.lgnspringapi.repository.MarathonRepository;

@Service
public class MarathonService {

  private final MarathonRepository repository;

  public MarathonService(MarathonRepository repository) {
    this.repository = repository;
  }

  public List<Marathon> findAll() {
    return repository.findAll();
  }

  public Optional<Marathon> findById(Long id) {
    return repository.findById(id);
  }

  public Marathon save(Marathon marathon) {
    return repository.save(marathon);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
