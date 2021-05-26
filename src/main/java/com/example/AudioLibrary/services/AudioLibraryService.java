package com.example.AudioLibrary.services;

import java.util.List;

/**
 * Предоставляет базовые методы для работы сервисов
 * @param <T> типа используемой сущности
 * P.S тз у всех только общий поиск
 */
public interface AudioLibraryService<T> {

    /**
     * Получает список всех сущностей типа {@link T}
     * @return список сущностей типа {@link T}
     */
    List<T> getAll();
}
