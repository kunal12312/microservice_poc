package org.mapstruct.example.mapper;

import org.mapstruct.example.dto.OrderItem;
import org.mapstruct.example.dto.OrderItemDto;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-25T15:57:32+0530",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
*/
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItem toOrder(OrderItemDto orderItemDto) {
        if ( orderItemDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setName( orderItemDto.name );
        orderItem.setQuantity( orderItemDto.quantity );

        return orderItem;
    }

    @Override
    public OrderItemDto fromOrder(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.name = orderItem.getName();
        orderItemDto.quantity = orderItem.getQuantity();

        return orderItemDto;
    }
}
