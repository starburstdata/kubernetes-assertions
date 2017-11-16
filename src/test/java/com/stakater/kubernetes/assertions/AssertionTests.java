package com.stakater.kubernetes.assertions;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static com.stakater.kubernetes.assertions.Assertions.assertThat;

class AssertionTests {
    private final KubernetesClient client = new DefaultKubernetesClient();

    @Test
    void testDeploymentPodIsReadyForPeriod() {
        assertThat(client).deployments().pods().isPodReadyForPeriod();
    }

    @Test
    void testAllServicesHaveEndpointOrReadyPod() {
        assertThat(client).services().assertAllServicesHaveEndpointOrReadyPod();
    }
}
