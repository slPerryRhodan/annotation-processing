plugins {
	java
	id("org.springframework.boot") version "4.0.6"
	id("io.spring.dependency-management") version "1.1.7"
	id("io.freefair.lombok") version "9.5.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

// WORKAROUND: Makes IntelliJ recognizing the generated mapstruct code under WSL2, which is automatically available under Windows
// Groovy DSL: sourceSets.main.java.srcDirs = ['build/generated/sources/annotationProcessor/java/main', 'src/main/java']
// Kotlin DSL:
java.sourceSets["main"].java {
	srcDir("build/generated/sources/annotationProcessor/java/main")
}

repositories {
	mavenCentral()
}

val mockitoVersion = "1.6.3"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.mapstruct:mapstruct:$mockitoVersion")
	annotationProcessor("org.mapstruct:mapstruct-processor:$mockitoVersion")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
