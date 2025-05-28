val LOG4J_VERSION = "2.13.0"

plugins {
    java
    war
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-api:$LOG4J_VERSION")
    implementation("com.google.code.gson:gson:2.13.1")
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
}

tasks.war {
    webInf {
        from("src/web")
    }
    metaInf {
        from("src/meta")
    }
}
