package com.stakater.kubernetes.assertions;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KubernetesNamespaceAssertTests {
    @Test
    void testNamespace() {
        String namespace = "default";
        KubernetesNamespaceAssert kNamespaceAssert = new KubernetesNamespaceAssert(new DefaultKubernetesClient(), namespace);
        assertThat(namespace).isEqualTo(kNamespaceAssert.namespace());
    }
}
