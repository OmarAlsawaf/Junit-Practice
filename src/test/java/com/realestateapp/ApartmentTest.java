package com.realestateapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {

    Apartment apartment;

    @BeforeEach
    void setup(){
        this.apartment = new Apartment(210, new BigDecimal(100000));
    }

    @Test
    void Should_ReturnCorrectArea_When_ApartmentNotNull() {

        //Given
        double expectedArea = 210;

        //when
        double actualArea = this.apartment.getArea();

        //then
        assertEquals(expectedArea,actualArea);

    }

    @Test
    void Should_ReturnNewArea_when_NewAreaNotNull(){

        //Given
        double newArea = 500;

        //when
        this.apartment.setArea(newArea);

        //then
        assertEquals(this.apartment.getArea(),newArea);


    }

    @Test
    void Should_ReturnCorrectPrice_When_ApartmentNotNull(){

        //Given
        BigDecimal expectedPrice = new BigDecimal(100000);

        //when
        BigDecimal actualPrice = this.apartment.getPrice();

        //then
        assertEquals(actualPrice,expectedPrice);


    }

    @Test
    void Should_ReturnNewPrice_When_NewPriceNotNull(){
        //Given
        BigDecimal newPrice = new BigDecimal(250000);

        //when
        this.apartment.setPrice(newPrice);

        //then
        assertEquals(this.apartment.getPrice(),newPrice);
    }
}