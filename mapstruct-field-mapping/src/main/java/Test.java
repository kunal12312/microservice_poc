import org.mapstruct.example.dto.Customer;
import org.mapstruct.example.dto.CustomerDto;
import org.mapstruct.example.mapper.CustomerMapper;
import org.mapstruct.example.mapper.CustomerMapperImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerMapper cm = new CustomerMapperImpl();
		CustomerDto  cDto = new CustomerDto();
		cDto.setCustomerName("Ashutosh");
		cDto.setId(new Long(7));
		
		Customer customer = cm.toCustomer(cDto);
		
		System.out.println(customer.toString());
	}

}
