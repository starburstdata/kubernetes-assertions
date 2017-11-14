package com.stakater.kubernetes.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AssertFactory;
import org.assertj.core.api.ListAssert;
import org.assertj.core.api.ObjectAssert;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Provides helper methods for navigating a list property in a generated assertion class
 *
 * TODO replace with the same class from assertj-core when this issue is fixed and released:
 * https://github.com/joel-costigliola/assertj-core/issues/641
 */
public class NavigationListAssert<T, EA extends AbstractAssert> extends ListAssert<T> {
    private final AssertFactory<T, EA> assertFactory;

    public NavigationListAssert(List<? extends T> actual, AssertFactory<T, EA> assertFactory) {
        super(actual);
        this.assertFactory = assertFactory;
    }

    /**
     * Navigates to the element at the given index if the index is within the range of the list
     *
     * @return the assertion on the given element
     */
    public EA item(int index) {

        isNotEmpty();
        assertThat(index).describedAs(Assertions.joinDescription(this, "index")).isGreaterThanOrEqualTo(0).isLessThan(actual.size());
        return assertFactory.createAssert(actual.get(index));
    }
}