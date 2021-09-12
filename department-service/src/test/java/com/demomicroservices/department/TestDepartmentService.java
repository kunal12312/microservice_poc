package com.demomicroservices.department;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demomicroservices.department.entity.Department;
import com.demomicroservices.department.repository.DepartmentRepository;
import com.demomicroservices.department.service.DepartmentService;

@DataJpaTest
class TestDepartmentService {

//	Department department = null;

	@Mock
	private DepartmentRepository departmentRepository;

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
//	@Before
//	public void setUp() {
//		department = new Department();
//	}

	@InjectMocks
	private DepartmentService departmentService;

	@Test
	public void saveDepartmentTest() {
		Department department = new Department();
		department.setDepartmentName("Electronics");
		department.setDepartmentAddress("Kolkata");
		department.setDepartmentCode("101");

		when(departmentRepository.save(ArgumentMatchers.any(Department.class))).thenReturn(department);
		Department created = departmentService.saveDepartment(department);

		assertEquals(created.getDepartmentName(), department.getDepartmentName());
		assertEquals(created.getDepartmentId(), department.getDepartmentId());
		assertEquals(created.getDepartmentAddress(), department.getDepartmentAddress());
		assertEquals(created.getDepartmentCode(), department.getDepartmentCode());
		verify(departmentRepository).save(department);
	}
	
	@Test
	public void finDepartmentByIdTest() {
		Department department = new Department();
		department.setDepartmentName("Electronics");
		department.setDepartmentAddress("Kolkata");
		department.setDepartmentCode("101");

		when(departmentRepository.findByDepartmentId(department.getDepartmentId())).thenReturn(department);
		Department created = departmentService.finDepartmentById(department.getDepartmentId());

		assertEquals(created.getDepartmentName(), department.getDepartmentName());
		assertEquals(created.getDepartmentId(), department.getDepartmentId());
		assertEquals(created.getDepartmentAddress(), department.getDepartmentAddress());
		assertEquals(created.getDepartmentCode(), department.getDepartmentCode());
		verify(departmentRepository).findByDepartmentId(department.getDepartmentId());
	}

}
