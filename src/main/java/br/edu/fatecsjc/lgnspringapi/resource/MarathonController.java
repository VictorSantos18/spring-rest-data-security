package br.edu.fatecsjc.lgnspringapi.resource;

import org.springframework.web.bind.annotation.*;

import br.edu.fatecsjc.lgnspringapi.entity.Marathon;
import br.edu.fatecsjc.lgnspringapi.service.MarathonService;

import java.util.List;

@RestController
@RequestMapping("/marathons")
public class MarathonController {

  private final MarathonService service;

  public MarathonController(MarathonService service) {
    this.service = service;
  }

  @GetMapping
  public List<Marathon> getAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Marathon getById(@PathVariable Long id) {
    return service.findById(id).orElseThrow();
  }

  @PostMapping
  public Marathon create(@RequestBody Marathon marathon) {
    return service.save(marathon);
  }

  @PutMapping("/{id}")
  public Marathon update(@PathVariable Long id, @RequestBody Marathon marathon) {
    marathon.setId(id);
    return service.save(marathon);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.deleteById(id);
  }
}