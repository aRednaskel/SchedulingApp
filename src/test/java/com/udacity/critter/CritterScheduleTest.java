package com.udacity.critter;

import com.google.common.collect.Sets;
import com.udacity.critter.controller.CustomerController;
import com.udacity.critter.controller.EmployeeController;
import com.udacity.critter.controller.PetController;
import com.udacity.critter.dto.CustomerDTO;
import com.udacity.critter.dto.EmployeeDTO;
import com.udacity.critter.dto.PetDTO;
import com.udacity.critter.entity.EmployeeSkill;
import com.udacity.critter.entity.PetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest(classes = CritterApplication.class)
public class CritterScheduleTest {

    @Autowired
    private CustomerController customerController;

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private PetController petController;

    @Test
    public void testCreateCustomer(){
        CustomerDTO customerDTO = createCustomerDTO();
        CustomerDTO newCustomer = customerController.saveCustomer(customerDTO);
        CustomerDTO retrievedCustomer = customerController.getAllCustomers().get(0);
        Assertions.assertEquals(newCustomer.getName(), customerDTO.getName());
        Assertions.assertEquals(newCustomer.getId(), retrievedCustomer.getId());
        Assertions.assertTrue(retrievedCustomer.getId() > 0);
    }

    @Test
    public void testCreateEmployee(){
        EmployeeDTO employeeDTO = createEmployeeDTO();
        EmployeeDTO newEmployee = employeeController.saveEmployee(employeeDTO);
        EmployeeDTO retrievedEmployee = employeeController.getEmployee(newEmployee.getId());
        Assertions.assertEquals(employeeDTO.getSkills(), newEmployee.getSkills());
        Assertions.assertEquals(newEmployee.getId(), retrievedEmployee.getId());
        Assertions.assertTrue(retrievedEmployee.getId() > 0);
    }

    @Test
    public void testAddPetsToCustomer() {
        CustomerDTO customerDTO = createCustomerDTO();
        CustomerDTO newCustomer = customerController.saveCustomer(customerDTO);

        PetDTO petDTO = createPetDTO();
        petDTO.setOwnerId(newCustomer.getId());
        PetDTO newPet = petController.savePet(petDTO);

        PetDTO retrievedPet = petController.getPet(newPet.getId());
        Assertions.assertEquals(retrievedPet.getId(), newPet.getId());
        Assertions.assertEquals(retrievedPet.getOwnerId(), newCustomer.getId());

        List<PetDTO> pets = petController.getPetsByOwner(newCustomer.getId());
        Assertions.assertEquals(newPet.getId(), pets.get(0).getId());
        Assertions.assertEquals(newPet.getName(), pets.get(0).getName());

        CustomerDTO retrievedCustomer = customerController.getAllCustomers().get(0);
        Assertions.assertTrue(retrievedCustomer.getPetIds() != null && retrievedCustomer.getPetIds().size() > 0);
        Assertions.assertEquals(retrievedCustomer.getPetIds().get(0), retrievedPet.getId());
    }

    private static CustomerDTO createCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("TestEmployee");
        customerDTO.setPhoneNumber("123-456-789");
        return customerDTO;
    }

    private static EmployeeDTO createEmployeeDTO() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("TestEmployee");
        employeeDTO.setSkills(Sets.newHashSet(EmployeeSkill.FEEDING, EmployeeSkill.PETTING));
        return employeeDTO;
    }

    private static PetDTO createPetDTO() {
        PetDTO petDTO = new PetDTO();
        petDTO.setName("TestPet");
        petDTO.setType(PetType.CAT);
        return petDTO;
    }
}
