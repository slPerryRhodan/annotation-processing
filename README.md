# Workarounds for IntelliJ Issue [IDEA-264036](https://youtrack.jetbrains.com/issue/IDEA-264036/Gradle-WSL-project-EAP-5-fails-to-find-files-generated-by-annotation-processor)
### Manual
Follow the steps as described to fix the issue in [MapperServiceTest](./src/test/java/com/example/annotation_processing/mapping/MapperServiceTest.java#L12), but this can lead to conflicts in case of a project where multiple modules are added to the IntelliJ project.
Steps for WSL2 which is not necessary on Windows system:
- 1 Mark generated code under main (build/generated/sources/annotationProcessor/java/main) as "Generated Source Root"
- 2 In this test class here execute at the unresolved MyMapperImpl class the context menu action "Add dependency on module 'annotation-processing'"
- 3 In MyMapperImpl class execute at @Component annotation the context menu action "Add library 'spring.context' to class path"
- 4 In MyMapperImpl class execute at MyMapper interface the context menu action "Add Add dependency on module 'annotation-processing.main'"

### Gradle Config
Add ``sourceSets`` to the gradle config as shown here  [build.gradle.kts](./build.gradle.kts#L17)

### Gradle Init Script (`~/.gradle/init.d/idea-wsl-fix.gradle`)
Place an init script at `~/.gradle/init.d/idea-wsl-fix.gradle` in your Gradle user home to resolve the issue globally across all projects without modifying project build files:

```groovy
allprojects {
    afterEvaluate { project ->
        if (project.plugins.hasPlugin('java')) {
            project.apply plugin: 'idea'
            project.idea {
                module {
                    def aptDir = project.file("${project.layout.buildDirectory.get()}/generated/sources/annotationProcessor/java/main")
                    sourceDirs += aptDir
                    generatedSourceDirs += aptDir
                }
            }
        }
    }
}
```
