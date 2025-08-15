package com.c9.codegen.initializr.projectgeneration.registry.configuration;

import com.c9.codegen.initializr.projectgeneration.generator.ProjectGenerator;
import com.c9.codegen.initializr.projectgeneration.model.ProjectType;
import com.c9.codegen.initializr.projectgeneration.model.techstack.BuildTool;
import com.c9.codegen.initializr.projectgeneration.model.techstack.Framework;
import com.c9.codegen.initializr.projectgeneration.model.techstack.Language;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectGeneratorRegistryConfiguration {

  private final ProjectGenerator springBootMavenJavaProjectGenerator;

  public ProjectGeneratorRegistryConfiguration(
      ProjectGenerator springBootMavenJavaProjectGenerator) {
    this.springBootMavenJavaProjectGenerator = springBootMavenJavaProjectGenerator;
  }

  @Bean
  Map<ProjectType, ProjectGenerator> registeredProjectGenerators() {
    Map<ProjectType, ProjectGenerator> generatorFactories = new HashMap<>();

    ProjectType springBootMavenJavaProjectType =
        new ProjectType(Framework.SPRING_BOOT, BuildTool.MAVEN, Language.JAVA);

    generatorFactories.put(springBootMavenJavaProjectType, springBootMavenJavaProjectGenerator);

    return generatorFactories;
  }
}
