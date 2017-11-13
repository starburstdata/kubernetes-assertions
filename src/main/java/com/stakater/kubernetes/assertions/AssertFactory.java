package com.stakater.kubernetes.assertions;

public interface AssertFactory<T, A> {
    public A createAssert(T t);
}
