#!/usr/bin/env groovy
@Library('github.com/stakater/fabric8-pipeline-library@master')

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
    }
}