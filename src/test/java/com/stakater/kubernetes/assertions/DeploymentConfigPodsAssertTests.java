package com.stakater.kubernetes.assertions;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.openshift.api.model.DeploymentConfig;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeploymentConfigPodsAssertTests {
    @Test
    void testPods() {
        DeploymentConfigPodsAssert deploymentConfigPodsAssert = new DeploymentConfigPodsAssert(new DefaultKubernetesClient(), new DeploymentConfig());
        assertThat(deploymentConfigPodsAssert.pods()).isNotNull();
    }
}
