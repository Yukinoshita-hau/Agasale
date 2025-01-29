package com.market.agasale.service;

import com.market.agasale.common.dto.DeleteSellerReturn;
import com.market.agasale.common.dto.UpdateSellerDto;
import com.market.agasale.common.enums.HttpDefaultMessage;
import com.market.agasale.exception.SellerNotFoundException;
import com.market.agasale.model.Seller;
import com.market.agasale.repo.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepo sellerRepo;

    public Seller getSeller(long id) {
        Optional<Seller> optionalSeller = sellerRepo.findById(id);

        if (optionalSeller.isPresent()) {
            return optionalSeller.get();
        } else {
            throw new SellerNotFoundException(HttpDefaultMessage.HTTP_SELLER_NOT_FOUND_MESSAGE.getHttpSellerNotFoundMessageWithId(id));
        }
    }

    public Seller createSeller(Seller seller) {
        return sellerRepo.save(seller);
    }

    public Seller updateSeller(UpdateSellerDto sellerDto) {
        Optional<Seller> optionalSeller = sellerRepo.findById(sellerDto.getId());

        if (optionalSeller.isPresent()) {
            Seller existedSeller = optionalSeller.get();
            existedSeller.setEmail(sellerDto.getEmail());
            existedSeller.setPassword(sellerDto.getPassword());
            return sellerRepo.save(existedSeller);
        } else {
            throw new SellerNotFoundException(HttpDefaultMessage.HTTP_SELLER_NOT_FOUND_MESSAGE.getHttpSellerNotFoundMessageWithId(sellerDto.getId()));
        }
    }

    public DeleteSellerReturn deleteSeller(long id) {
        Optional<Seller> optionalSeller = sellerRepo.findById(id);

        if (optionalSeller.isPresent()) {
            sellerRepo.deleteById(id);
            return new DeleteSellerReturn(optionalSeller.get().getId(), optionalSeller.get().getEmail());
        } else {
            throw new SellerNotFoundException(HttpDefaultMessage.HTTP_SELLER_NOT_FOUND_MESSAGE.getHttpSellerNotFoundMessageWithId(id));
        }
    }
}
