package com.stakater.kubernetes.assertions;

import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReplicaSetPodsAssertTests extends TestBase {
    @Test
    void testPods() {
        ReplicaSetPodsAssert rspAssert = new ReplicaSetPodsAssert(kClient, new ReplicaSet());
        // Needs Kubernetes to be running
        assertThat(rspAssert.pods().getReplicas()).isEqualTo(0);
    }
}
