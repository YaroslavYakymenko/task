package service;

import java.util.function.Consumer;
import java.util.function.Function;

public interface PrintService<T> {
    void printName(T t);
}
