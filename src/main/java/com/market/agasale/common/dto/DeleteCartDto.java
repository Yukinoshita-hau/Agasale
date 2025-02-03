package com.market.agasale.common.dto;


public class DeleteCartDto {
    private long id;

    public DeleteCartDto(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
