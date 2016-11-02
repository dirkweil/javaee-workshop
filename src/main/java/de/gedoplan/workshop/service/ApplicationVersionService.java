package de.gedoplan.workshop.service;

import de.gedoplan.baselibs.utils.util.ApplicationProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import lombok.Getter;

@ApplicationScoped
@Getter
public class ApplicationVersionService
{
  private String groupId;
  private String artifactId;
  private String version;

  private String name;
  private String gav;

  @PostConstruct
  void postConstruct()
  {
    this.groupId = ApplicationProperties.getProperty("project.groupId");
    this.artifactId = ApplicationProperties.getProperty("project.artifactId");
    this.version = ApplicationProperties.getProperty("project.version");

    this.name = this.artifactId + "-" + this.version;

    this.gav = this.groupId + ":" + this.artifactId + ":" + this.version;
  }
}
