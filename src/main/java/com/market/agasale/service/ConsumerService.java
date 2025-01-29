package com.market.agasale.service;

import com.market.agasale.common.dto.DeleteConsumerReturn;
import com.market.agasale.common.dto.UpdateConsumerDto;
import com.market.agasale.common.enums.HttpDefaultMessage;
import com.market.agasale.exception.ConsumerNotFoundException;
import com.market.agasale.model.Consumer;
import com.market.agasale.repo.ConsumerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerRepo consumerRepo;

    public Consumer getConsumer(long id) {
        Optional<Consumer> optionalConsumer = consumerRepo.findById(id);

        if (optionalConsumer.isPresent()) {
            return optionalConsumer.get();
        } else {
            throw new ConsumerNotFoundException(HttpDefaultMessage.HTTP_CONSUMER_NOT_FOUND_MESSAGE.getHttpConsumerNotFoundMessageWithId(id));
        }
    }

    public List<Consumer> getAllConsumers() {
        return consumerRepo.findAll();
    }

    public Consumer createConsumer(Consumer consumer) {
        return consumerRepo.save(consumer);
    }

    public Consumer updateConsumer(UpdateConsumerDto consumerDto) {
        Optional<Consumer> optionalConsumer = consumerRepo.findById(consumerDto.getId());

        if (optionalConsumer.isPresent()) {
            Consumer existingConsumer = optionalConsumer.get();
            existingConsumer.setEmail(consumerDto.getEmail());
            existingConsumer.setName(consumerDto.getName());
            existingConsumer.setPassword(consumerDto.getPassword());
            existingConsumer.setPhoneNumber(consumerDto.getPhoneNumber());
            return consumerRepo.save(existingConsumer);
        } else {
            throw new ConsumerNotFoundException(HttpDefaultMessage.HTTP_CONSUMER_NOT_FOUND_MESSAGE.getHttpConsumerNotFoundMessageWithId(consumerDto.getId()));
        }
    }

    public DeleteConsumerReturn deleteConsumer(long id) {
        Optional<Consumer> optionalConsumer = consumerRepo.findById(id);

        if (optionalConsumer.isPresent()) {
            consumerRepo.deleteById(id);
            return new DeleteConsumerReturn(optionalConsumer.get().getId(),
                                            optionalConsumer.get().getName(),
                                            optionalConsumer.get().getEmail(),
                                            optionalConsumer.get().getPhoneNumber());
        } else {
            throw new ConsumerNotFoundException(HttpDefaultMessage.HTTP_CONSUMER_NOT_FOUND_MESSAGE.getHttpConsumerNotFoundMessageWithId(id));
        }
    }
}
