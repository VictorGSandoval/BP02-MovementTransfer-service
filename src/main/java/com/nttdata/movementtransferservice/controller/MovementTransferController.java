package com.nttdata.movementtransferservice.controller;


import com.nttdata.movementtransferservice.model.MovementTransfer;
import com.nttdata.movementtransferservice.service.IMovementTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movementTransfer")
public class MovementTransferController {

    private final IMovementTransferService service;

    @GetMapping
    public Flux<MovementTransfer> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<MovementTransfer> getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<MovementTransfer> create(@RequestBody MovementTransfer movementTransfer) {
        return service.create(movementTransfer);
    }

    @PutMapping("/{id}")
    public Mono<MovementTransfer> update(@PathVariable String id, @RequestBody MovementTransfer movementTransfer) {
        return service.update(id, movementTransfer);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
