package org.example.tp2_rent.Manager;

import java.util.List;

public interface Manager <E>{

    List<E> getAll(int page, int size);

    E getById(String id);
}
