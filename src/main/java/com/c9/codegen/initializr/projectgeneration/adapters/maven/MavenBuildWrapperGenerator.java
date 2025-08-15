package com.c9.codegen.initializr.projectgeneration.adapters.maven;

import com.c9.codegen.initializr.projectgeneration.model.ProjectMetadata;
import com.c9.codegen.initializr.projectgeneration.model.templating.TemplateType;
import com.c9.codegen.initializr.projectgeneration.ports.ProjectBuildWrapperGenerator;
import com.c9.codegen.initializr.projectgeneration.ports.TemplateEngine;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component("mavenBuildWrapperGenerator")
public class MavenBuildWrapperGenerator implements ProjectBuildWrapperGenerator {

  private static final String MAVEN_VERSION = "3.9.6";
  private static final String WRAPPER_VERSION = "3.1.1";
  private static final String WRAPPER_FILE_DIR = ".mvn/wrapper";

  private final TemplateEngine freeMarkerTemplateEngine;

  public MavenBuildWrapperGenerator(TemplateEngine freeMarkerTemplateEngine) {
    this.freeMarkerTemplateEngine = freeMarkerTemplateEngine;
  }

  @Override
  public void generateBuildWrapper(File projectDestination, ProjectMetadata projectMetadata)
      throws IOException {
    Map<String, Object> wrapperModel = new HashMap<>();
    wrapperModel.put("wrapperVersion", WRAPPER_VERSION);
    wrapperModel.put("mavenVersion", MAVEN_VERSION);
    File wrapperFileDestination = new File(projectDestination, WRAPPER_FILE_DIR);
    freeMarkerTemplateEngine.generateFileFromTemplate(
        TemplateType.MAVEN_WRAPPER, wrapperModel, wrapperFileDestination);
  }
}
