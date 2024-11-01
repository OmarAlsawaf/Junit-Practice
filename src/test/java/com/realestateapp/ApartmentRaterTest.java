package com.realestateapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRaterTest {


    @Nested
    @DisplayName("rateApartment()")
    class TestingRateApartment{

        @ParameterizedTest
        @CsvSource(value = {"72.0, 250000.0, 0", "48.0, 350000.0, 1", "30.0, 600000.0, 2"})
        void should_ReturnCorrectRating_When_CorrectApartment(Double area, Double price, int rating) {

            // given
            Apartment apartment = new Apartment(area, new BigDecimal(price));
            int expected = rating;

            // when
            int actual = ApartmentRater.rateApartment(apartment);

            // then
            assertEquals(expected, actual);
        }

        @Test
        void Should_ReturnNegOne_When_ApartmentAreaIsZero(){
            //Given
            Apartment apartment = new Apartment(0.0,new BigDecimal(10000));

            //When
            int actualRate = ApartmentRater.rateApartment(apartment);

            //then
            assertEquals(actualRate,-1);
        }

        @Test
        void Should_ReturnZero_When_RatioLessThan6000(){

            //Given
            Apartment apartment = new Apartment(110,new BigDecimal(600000));

            //When
            int apartmentRate = ApartmentRater.rateApartment(apartment);

            //then
            assertEquals(0,apartmentRate);
        }

        @Test
        void Should_ReturnOne_When_RatioLessThan8000AndGreaterThan5999(){

            //Given
            Apartment apartment = new Apartment(90,new BigDecimal(600000));

            //When
            int apartmentRate = ApartmentRater.rateApartment(apartment);

            //then
            assertEquals(1,apartmentRate);
        }

        @Test
        void Should_ReturnTwo_When_RatioGreaterThan7999(){

            //Given
            Apartment apartment = new Apartment(50,new BigDecimal(600000));

            //When
            int apartmentRate = ApartmentRater.rateApartment(apartment);

            //then
            assertEquals(2,apartmentRate);
        }

    }


    @Nested
    @DisplayName("calculateAverageRating()")
    class TestingCalculateAverageRating{

        @Test
        void Should_ThrowRuntimeException_When_ApartmentListIsEmpty(){
            //Given
            List<Apartment> apartmentList = new ArrayList<>();

            //When
            Executable exe = ()-> ApartmentRater.calculateAverageRating(apartmentList);

            //then
            assertThrows(RuntimeException.class,exe);
        }

        @Test
        void Should_ReturnCorrectAverageRating_when_ApartmentListNotEmpty(){
            //Given
            List<Apartment> apartmentList = new ArrayList<>();
            apartmentList.add(new Apartment(200,new BigDecimal(1200000)));
            apartmentList.add(new Apartment(200,new BigDecimal(1200000)));
            apartmentList.add(new Apartment(200,new BigDecimal(1200000)));

            //when
            double actualAverageRating = ApartmentRater.calculateAverageRating(apartmentList);

            //then
            assertEquals(actualAverageRating,1);


        }


    }
}