package com.stakater.kubernetes.assertions;

import org.junit.jupiter.api.Test;

import static com.stakater.kubernetes.assertions.Assertions.assertThat;

class AssertionTests extends TestBase {

    @Test
    void testDeploymentPodIsReadyForPeriod() {
        assertThat(kClient).deployments().pods().isPodReadyForPeriod();
    }

    @Test
    void testAllServicesHaveEndpointOrReadyPod() {
        assertThat(kClient).services().assertAllServicesHaveEndpointOrReadyPod();
    }
}
