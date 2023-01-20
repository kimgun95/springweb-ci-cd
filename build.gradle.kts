plugins {
    java
    id("org.springframework.boot") version "2.7.6"
    id("io.spring.dependency-management") version "1.1.0"
}

tasks.named<Jar>("jar") {
    enabled = false
}

group = "com.example"
version = "0.0.4"
java.sourceCompatibility = JavaVersion.VERSION_1_8

ext["hibernate.version"] = "5.6.14.Final"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("junit:junit:4.13.1")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("pl.allegro.tech.boot:handlebars-spring-boot-starter:0.3.2")
    implementation("org.mariadb.jdbc:mariadb-java-client")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
