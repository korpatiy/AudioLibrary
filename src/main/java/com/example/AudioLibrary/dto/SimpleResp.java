package com.example.AudioLibrary.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SimpleResp<T> {

    private final T result;
}
