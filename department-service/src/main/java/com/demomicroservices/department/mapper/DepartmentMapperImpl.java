package com.demomicroservices.department.mapper;

import com.demomicroservices.department.dtoModel.Department;
import com.demomicroservices.department.entity.DepartmentDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-12T13:06:49+0530",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department dtoToModel(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setDepartmentId( departmentDto.getDepartmentId() );
        department.setDepartmentName( departmentDto.getDepartmentName() );
        department.setDepartmentAddress( departmentDto.getDepartmentAddress() );
        department.setDepartmentCode( departmentDto.getDepartmentCode() );

        return department;
    }

    @Override
    public DepartmentDto modelToDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setDepartmentId( department.getDepartmentId() );
        departmentDto.setDepartmentName( department.getDepartmentName() );
        departmentDto.setDepartmentAddress( department.getDepartmentAddress() );
        departmentDto.setDepartmentCode( department.getDepartmentCode() );

        return departmentDto;
    }
}
