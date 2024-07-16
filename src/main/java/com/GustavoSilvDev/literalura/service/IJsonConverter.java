package com.GustavoSilvDev.literalura.service;

public interface IJsonConverter {
    <T> T getData(String json, Class<T> classe);
}
