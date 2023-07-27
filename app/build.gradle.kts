/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.3/userguide/building_java_projects.html
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // use Maven Central for resolving dependencies
    mavenCentral()

    // get xwarp.jar from github packages
    maven {
        url = uri("https://maven.pkg.github.com/kbirken/xwarp")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.token") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }    
}

dependencies {
    // use JUnit Jupiter for testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")

    // dependencies used by the application
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("org.nanosite.xwarp:xwarp:1.0.0-SNAPSHOT")
}

application {
    // define the main class for the application
    mainClass.set("org.nanosite.xwarp_client.App")
}

tasks.named<Test>("test") {
    // use JUnit Platform for unit tests
    useJUnitPlatform()
}
