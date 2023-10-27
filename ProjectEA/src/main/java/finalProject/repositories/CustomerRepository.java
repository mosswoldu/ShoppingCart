package finalProject.repositories;

import finalProject.domain.Customer;
import finalProject.domain.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where c.emailAddress = :email")
    Optional<Customer> findByEmail(String email);

    @Query("select c from  Customer  c  join c.orderList o where o.id=:idOrder")
    void findByOrderId(int idOrder);


}
