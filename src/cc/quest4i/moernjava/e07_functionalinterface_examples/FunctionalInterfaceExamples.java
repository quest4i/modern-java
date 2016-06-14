package cc.quest4i.moernjava.e07_functionalinterface_examples;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;



/**
 * Created by quest4i on 2016. 6. 13..
 */
public class FunctionalInterfaceExamples {

    public static void main(String[] args) {

    }



    @AllArgsConstructor
    @Data
    static class Product {
        private Long id;
        private Product product;
        private int quantity;
    }

}
