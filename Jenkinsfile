#!/usr/bin/env groovy
@Library('github.com/stakater/fabric8-pipeline-library@master')

def localItestPattern = ""
try {
    localItestPattern = ITEST_PATTERN
} catch (Throwable e) {
    localItestPattern = "com.stakater.kubernetes.assertions.*Tests"
}

def localFailIfNoTests = ""
try {
    localFailIfNoTests = ITEST_FAIL_IF_NO_TEST
} catch (Throwable e) {
    localFailIfNoTests = "false"
}

def versionPrefix = ""
try {
    versionPrefix = VERSION_PREFIX
} catch (Throwable e) {
    versionPrefix = "1.0"
}

def canaryVersion = "${versionPrefix}.${env.BUILD_NUMBER}"


mavenNode(mavenImage: 'openjdk:8') {
    container(name: 'maven') {
        stage('Checkout') {
            checkout scm
        }

        stage('Canary Release') {
            mavenCanaryRelease2 {
                version = canaryVersion
            }
        }

        stage('Integration Tests') {
            mavenIntegrationTest {
                environment = 'Testing'
                failIfNoTests = lFailIfNoTests
                itestPattern = localItestPattern
            }
        }
    }
}