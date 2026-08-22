# Workarounds for IntelliJ Issue [IDEA-264036](https://youtrack.jetbrains.com/issue/IDEA-264036/Gradle-WSL-project-EAP-5-fails-to-find-files-generated-by-annotation-processor)
### Manuell
Follow the steps as described in the test [MapperServiceTest](./src/test/java/com/example/annotation_processing/mapping/MapperServiceTest.java#L12), but this can lead to conflicts in case of a project where multiple modules are added to the IntelliJ project.

### Gradle Config
Add ``sourceSets`` to the gradle config as shown here  [build.gradle.kts](./build.gradle.kts#L17)