package com.nttdata.movementtransferservice.service;

import com.nttdata.movementtransferservice.model.MovementTransfer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovementTransferService {
    Flux<MovementTransfer> findAll();

    Mono<MovementTransfer> findById(String id);

    Mono<MovementTransfer> create(MovementTransfer movementTransfer);

    Mono<MovementTransfer> update(String id, MovementTransfer movementTransfer);

    Mono<Void> delete(String id);
}
