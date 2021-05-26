package com.example.AudioLibrary.repositories;

import com.example.AudioLibrary.dto.SearchRequest;
import com.example.AudioLibrary.entity.Melody;

import java.util.List;

/**
 * Представляет методы для поиска данных
 * P.S https://www.baeldung.com/spring-data-criteria-queries
 * Спринг не дал понаследоваться АудиоРепозиторию от кастомного.
 * Вроде на формуха пишут, что кастомные методы по контракту должны удовлетворять методам JPA
 */
public interface CustomTextSearcherRepository {

    /**
     * Выполняет поиск мелодий {@link Melody}, удовлетворяющих запросу
     * @param request запрос, принимаемый от клиента {@link SearchRequest}
     * @return список найденных мелодий {@link Melody}
     */
    List<Melody> findAllByRequest(SearchRequest request);
}
