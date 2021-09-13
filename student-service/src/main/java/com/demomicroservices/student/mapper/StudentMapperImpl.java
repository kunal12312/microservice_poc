package com.demomicroservices.student.mapper;

import com.demomicroservices.student.dtoModel.Student;
import com.demomicroservices.student.entity.StudentDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-12T13:05:18+0530",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student dtoToModel(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setStudentId( studentDto.getStudentId() );
        student.setFirstName( studentDto.getFirstName() );
        student.setLastName( studentDto.getLastName() );
        student.setEmail( studentDto.getEmail() );
        student.setDepartmentId( studentDto.getDepartmentId() );

        return student;
    }

    @Override
    public StudentDto modelToDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setStudentId( student.getStudentId() );
        studentDto.setFirstName( student.getFirstName() );
        studentDto.setLastName( student.getLastName() );
        studentDto.setEmail( student.getEmail() );
        studentDto.setDepartmentId( student.getDepartmentId() );

        return studentDto;
    }
}
