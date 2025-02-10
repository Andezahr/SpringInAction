package app.data;

import app.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByZip(String zip);
    List<TacoOrder> findByZipAndPlacedAtBetween(String zip, Date startDate, Date endDate);
}
