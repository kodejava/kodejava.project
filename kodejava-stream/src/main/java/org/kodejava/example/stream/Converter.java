package org.kodejava.example.stream;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
