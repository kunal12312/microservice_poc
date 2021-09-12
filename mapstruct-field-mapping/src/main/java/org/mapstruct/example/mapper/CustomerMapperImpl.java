package org.mapstruct.example.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.mapstruct.example.dto.Customer;
import org.mapstruct.example.dto.CustomerDto;
import org.mapstruct.example.dto.OrderItem;
import org.mapstruct.example.dto.OrderItemDto;
import org.mapstruct.factory.Mappers;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-25T15:57:33+0530",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
*/
public class CustomerMapperImpl implements CustomerMapper {

    private final OrderItemMapper orderItemMapper = Mappers.getMapper( OrderItemMapper.class );

    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setOrderItems( orderItemDtoListToOrderItemCollection( customerDto.orders ) );
        customer.setName( customerDto.customerName );
        customer.setId( customerDto.id );

        return customer;
    }

    @Override
    public CustomerDto fromCustomer(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.orders = orderItemCollectionToOrderItemDtoList( customer.getOrderItems() );
        customerDto.customerName = customer.getName();
        customerDto.id = customer.getId();

        return customerDto;
    }

    protected Collection<OrderItem> orderItemDtoListToOrderItemCollection(List<OrderItemDto> list) {
        if ( list == null ) {
            return null;
        }

        Collection<OrderItem> collection = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemDto orderItemDto : list ) {
            collection.add( orderItemMapper.toOrder( orderItemDto ) );
        }

        return collection;
    }

    protected List<OrderItemDto> orderItemCollectionToOrderItemDtoList(Collection<OrderItem> collection) {
        if ( collection == null ) {
            return null;
        }

        List<OrderItemDto> list = new ArrayList<OrderItemDto>( collection.size() );
        for ( OrderItem orderItem : collection ) {
            list.add( orderItemMapper.fromOrder( orderItem ) );
        }

        return list;
    }
}
