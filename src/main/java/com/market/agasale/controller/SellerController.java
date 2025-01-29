package com.market.agasale.controller;

import com.market.agasale.common.dto.DeleteSellerReturn;
import com.market.agasale.common.dto.UpdateSellerDto;
import com.market.agasale.model.Seller;
import com.market.agasale.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/seller/{id}")
    public Seller getSeller(@PathVariable long id) {
        return sellerService.getSeller(id);
    }

    @PostMapping("/seller")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

    @PutMapping("/seller")
    public Seller updateSeller(@RequestBody UpdateSellerDto sellerDto) {
        return sellerService.updateSeller(sellerDto);
    }

    @DeleteMapping("/seller/{id}")
    public DeleteSellerReturn deleteSeller(@PathVariable long id) {
        return sellerService.deleteSeller(id);
    }
}
