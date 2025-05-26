package br.edu.fatecsjc.lgnspringapi.resource;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecsjc.lgnspringapi.entity.Organization;
import br.edu.fatecsjc.lgnspringapi.service.OrganizationService;

@RestController
@RequestMapping("/organizations")
public class OrganizationResource {

  private final OrganizationService service;

  public OrganizationResource(OrganizationService service) {
    this.service = service;
  }

  @GetMapping
  public List<Organization> getAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Organization getById(@PathVariable Long id) {
    return service.findById(id).orElseThrow();
  }

  @PostMapping
  public Organization create(@RequestBody Organization organization) {
    return service.save(organization);
  }

  @PutMapping("/{id}")
  public Organization update(@PathVariable Long id, @RequestBody Organization organization) {
    organization.setId(id);
    return service.save(organization);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.deleteById(id);
  }
}