package br.edu.fatecsjc.lgnspringapi.dto;

public class MarathonRequest {

  private String name;
  private String date;
  private Long organizationId;

  public MarathonRequest() {
  }

  public MarathonRequest(String name, String date, Long organizationId) {
    this.name = name;
    this.date = date;
    this.organizationId = organizationId;
  }

  // Getters e Setters

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Long getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
  }
}
