package dev.struchkov.library.context.service;

import lombok.NonNull;

import java.util.Optional;

public interface BasicService<T, K> {

    Optional<T> getById(@NonNull K entityId);

    T getByIdOrThrown(@NonNull K entityId);

}
