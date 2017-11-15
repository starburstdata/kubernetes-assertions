package com.stakater.kubernetes.assertions;

import io.fabric8.kubernetes.api.model.HasMetadata;
import org.assertj.core.api.FactoryBasedNavigableListAssert;
import org.assertj.core.api.ObjectAssert;

import java.util.List;

public class MetadatasListAssert<R extends HasMetadata> extends FactoryBasedNavigableListAssert<MetadatasListAssert<R>, List<? extends R>, R, ObjectAssert<R>> {
    public MetadatasListAssert() {

    }

}
