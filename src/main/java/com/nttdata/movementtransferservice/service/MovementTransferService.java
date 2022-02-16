package com.nttdata.movementtransferservice.service;

import com.nttdata.movementtransferservice.model.MovementTransfer;
import com.nttdata.movementtransferservice.repository.MovementTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MovementTransferService implements IMovementTransferService {
    private final MovementTransferRepository repository;

    @Override
    public Flux<MovementTransfer> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<MovementTransfer> findById(String id) {
        return  repository.findById(id);
    } 

    @Override
    public Mono<MovementTransfer> create(MovementTransfer movementTransfer) {
        movementTransfer.setDate(LocalDate.now());
        return repository.save(movementTransfer);
    }

    @Override
    public Mono<MovementTransfer> update(String id, MovementTransfer movementTransfer) {
        return repository.findById(id).flatMap(newMovementTransfer -> {
            movementTransfer.setId(newMovementTransfer.getId());
            return repository.save(movementTransfer);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id).flatMap(movementTransfer -> repository.deleteById(movementTransfer.getId()));
    }
}
