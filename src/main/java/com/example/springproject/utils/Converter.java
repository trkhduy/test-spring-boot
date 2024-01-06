package com.example.springproject.utils;

//D là request dto, E là Entity, R là response dto
public interface Converter<D, E, R> {
    // Hàm convert từ dto request sang entity
    E convertToEntity(D requestDto);

    // Hàm convert từ Entity sang response dto
    R convertToDto(E entity);
}
