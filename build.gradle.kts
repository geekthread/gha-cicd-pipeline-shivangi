plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Add Jedis directly as a standard implementation dependency
    implementation("redis.clients:jedis:5.1.5")

    // Uncomment if you want to add JUnit for testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}
