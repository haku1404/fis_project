package vn.fis.training.service;

import org.omg.PortableInterceptor.INACTIVE;
import vn.fis.training.domain.Customer;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerException;
import vn.fis.training.exception.InvalidCustomerStatusException;
import vn.fis.training.store.InMemoryCustomerStore;



import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{
    private InMemoryCustomerStore customerStore;
    List<Customer> listCustomer = customerStore.findAll();


    @Override
    public Customer findById(String id)  {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        //check if id is empty or null
        if(isNullOrEmpty(id)){
            //print out error message
            throw new IllegalArgumentException("Can't find customer without ID");
        }
        //Loop from the fist customer to the last customer if id not null or empty
        for(int i = 0; i< listCustomer.size(); i++){
            //if user's input id equal to customer's id, return that customer
            if(listCustomer.get(i).getId().equals(id)){
                return listCustomer.get(i);
            }
        }
        //print out error message
        throw new CustomerNotFoundException("Can't find customer with ID: " +id);
    }

    /**
     *
     * @param id
     * @return
     */
    private boolean isNullOrEmpty(String id) {
        if(id.isEmpty()){
            return false;
        }
        if(id.trim().length() == 0){
            return false;
        }
        return true;
    }

    /**
     *
     * @param customer : Doi tuong customer muon tao.
     * @return
     * @throws InvalidCustomerException
     */
    @Override
    public Customer createCustomer(Customer customer) throws InvalidCustomerException {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        //validate customer's information before adding to the system
        validate(customer);
        //check if the customer already existed
        checkExisted(customer);
        //insert a new customer if it wasn't exist
        return customerStore.insertOrUpdate(customer);
    }

    /**
     * Validate customer's name & mobile phone before do something else
     * @param customer
     */
    private void validate(Customer customer) {
        if(isNullOrEmpty(customer.getName())){
            throw new InvalidCustomerException(customer, "Customer name is empty!");
        }
        if(isNullOrEmpty(customer.getMobile())){
            throw new InvalidCustomerException(customer, "Customer phone number is empty!");
        }

    }

    /**
     * check if customer already existed
     * @param customer
     */
    public void checkExisted(Customer customer){
        //loop from the first customer to the last customer in the customer list
        for(Customer customer1 : listCustomer){
            //if phone number of customer whom user entered is equal to one in the list, throw Exception
            if(customer.getMobile().equals(customer1.getMobile())) {
                throw new DuplicateCustomerException(customer, String.format("Customer with" +
                        "phone number: " + customer.getMobile() + " is already existed!"));
            }
        }
    }

    /**
     *
     * @param customer : Doi tuong customer muon cap nhat thong tin
     * @return
     * @throws InvalidCustomerException
     */
    @Override
    public Customer updateCustomer(Customer customer) throws InvalidCustomerException {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        //validate customer's information
        validate(customer);
        //find that customer by id after validate
        findById(customer.getId());
        //update customer's information
        customerStore.insertOrUpdate(customer);

        return null;
    }

    /**
     *
     * @param id : Id cua khach hang can delete.
     * @throws InvalidCustomerStatusException
     */
    @Override
    public void deleteCustomerById(String id) throws InvalidCustomerStatusException {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        if(isNullOrEmpty(id)){
            throw new IllegalArgumentException("Can't not delete without enter an id!");
        }
        if(findById(id).getStatus().equals("ACTIVE")){
            throw new InvalidCustomerStatusException(findById(id), String.format("Can't " +
                    "delete active customer with id:" +id));
        }
        //find the customer user want to delete by id
        findById(id);
        //delete that customer
        customerStore.deleteById(id);

    }

    /**
     *
     * @return the list of customer with name sorted by ascending order
     */
    @Override
    public List<Customer> findAllOrderByNameAsc()  {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param limit : So luong toi da Customer duoc tra ve
     * @return the list of limited customer with name sorted by ascending order
     */
    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .limit(limit)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param custName : Dieu kien tim kiem . Vi du: "Nguyen Van" -> He thong tra ve tat ca cac customer co chu chuoi ky tu : Nguyen Van, Khong phan biet hoa tuong
     * @param limit : So luong toi da Customer duoc tra ve
     * @return list of customer searched by name
     */
    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, int limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return customerStore.findAll().stream()
                .filter(customer -> customer.getName().contains(custName))
                .sorted(Comparator.comparing(Customer::getName))
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
//        return customerStore.findAll().stream()
//                .sorted(Comparator.comparingInt(SummaryCustomerByAgeDTO::getAge))
//                .collect(Collectors.toList());
        return null;
    }

}
