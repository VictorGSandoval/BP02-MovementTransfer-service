package com.nttdata.movementtransferservice.repository;

import com.nttdata.movementtransferservice.model.MovementTransfer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MovementTransferRepository extends ReactiveCrudRepository<MovementTransfer, String> {

}