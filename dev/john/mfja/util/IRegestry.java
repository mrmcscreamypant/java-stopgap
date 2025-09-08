package dev.john.mfja.util;

import java.util.HashMap;

public interface IRegestry<T> {

    public HashMap<String, T> items(Object[] args);
}
