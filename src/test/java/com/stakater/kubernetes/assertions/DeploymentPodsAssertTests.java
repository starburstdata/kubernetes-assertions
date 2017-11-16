package com.stakater.kubernetes.assertions;

import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeploymentPodsAssertTests {
    @Test
    void testPods() {
        DeploymentPodsAssert deploymentPodsAssert = new DeploymentPodsAssert(new DefaultKubernetesClient(), new Deployment());
        assertThat(deploymentPodsAssert.pods()).isNotNull();
    }
}
