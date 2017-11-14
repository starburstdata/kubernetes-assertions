package com.stakater.kubernetes.assertions;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.utils.Block;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.stakater.kubernetes.assertions.Assertions.assertThat;
import static io.fabric8.utils.Asserts.assertAssertionError;


/**
 */
public class ExampleTest {

    @Test
    public void testNavigationAssertions() throws Exception {
        String expectedId = "abc";
        Map<String, String> expectedLabels = new HashMap<>();
        expectedLabels.put("foo", "bar");

        final Pod pod = new Pod();
        pod.setMetadata(new ObjectMeta());
        pod.getMetadata().setName(expectedId);
        pod.getMetadata().setLabels(expectedLabels);


        assertThat(pod).metadata().name().isEqualTo(expectedId);
        assertThat(pod).metadata().labels().isEqualTo(expectedLabels);

        assertAssertionError(new Block() {
            @Override
            public void invoke() throws Exception {
                assertThat(pod).metadata().name().isEqualTo("cheese");
            }
        });

        assertAssertionError(new Block() {
            @Override
            public void invoke() throws Exception {
                assertThat(pod).describedAs("my pod").metadata().name().isEqualTo("cheese");
            }
        });

        assertAssertionError(new Block() {
            @Override
            public void invoke() throws Exception {
                Map<String, String> wrongLabels = new HashMap<>();
                wrongLabels.put("bar", "whatnot");
                assertThat(pod).metadata().labels().isEqualTo(wrongLabels);
            }
        });
    }

    @Test
    public void testNullNavigationOnPod() throws Exception {
        final Pod pod = new Pod();
        pod.setMetadata(null);

        assertAssertionError(new Block() {
            @Override
            public void invoke() throws Exception {
                assertThat(pod).metadata().name().isEqualTo("cheese");
            }
        });
    }

}