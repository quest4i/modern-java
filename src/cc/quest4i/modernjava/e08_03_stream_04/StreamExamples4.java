package cc.quest4i.modernjava.e08_03_stream_04;



import lombok.AllArgsConstructor;
import lombok.Data;


import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;



/**
 * Created by quest4i on 2016. 6. 15..
 */
public class StreamExamples4 {

    public static void main(String[] args) {



    } // end of main()
} // end of StreamExamples4


@AllArgsConstructor
@Data
class Product {

    private Long id;
    private String name;
    private BigDecimal price;

} // end of Product


@AllArgsConstructor
@Data
class OrderedItem {

    private Long id;
    private Product product;
    private int quantity;

    public BigDecimal getTotalPrice() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
} // end of OrderedItem


@AllArgsConstructor
@Data
class Order {

    private Long id;
    private List<OrderedItem> items;

    public BigDecimal totalPrice() {

        return items.stream()
                    .parallel()
//                    .map(item -> item.getTotalPrice())
                    .map(OrderedItem::getTotalPrice)
//                    .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}



