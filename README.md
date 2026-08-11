# Workarounds for IntelliJ Issue [IDEA-264036](https://youtrack.jetbrains.com/issue/IDEA-264036/Gradle-WSL-project-EAP-5-fails-to-find-files-generated-by-annotation-processor)
### Manuell
Follow the steps as described in the test [MapperServiceTest](https://github.com/slPerryRhodan/annotation-processing/blob/b6a6637ebd70cb32dc2f264578f90afc0cda7f13/src/test/java/com/example/annotation_processing/mapping/MapperServiceTest.java#L12), but this can lead to conflicts in case of a project where multiple modules are added to the IntelliJ project.

### Gradle Config
Add ``sourceSets`` to the gradle config as shown here [build.gradle.kts](https://github.com/slPerryRhodan/annotation-processing/blob/b6a6637ebd70cb32dc2f264578f90afc0cda7f13/build.gradle.kts#L17)