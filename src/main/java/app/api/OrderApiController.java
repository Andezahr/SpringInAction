package app.api;

import app.data.OrderRepository;
import app.model.TacoOrder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/orders", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class OrderApiController {

    private final OrderRepository orderRepo;

    public OrderApiController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping(produces = "application/json")
    public Iterable<TacoOrder> allOrders() {
        return orderRepo.findAll();
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder tacoOrder) {
        tacoOrder.setId(orderId);
        return orderRepo.save(tacoOrder);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder patch) {

        if (orderRepo.findById(orderId).isEmpty()) {
            return null;
        }

        TacoOrder order = orderRepo.findById(orderId).get();

        if (patch.getName() != null) {
            order.setName(patch.getName());
        }

        if (patch.getStreet() != null) {
            order.setStreet(patch.getStreet());
        }

        if (patch.getCity() != null) {
            order.setCity(patch.getCity());
        }

        if (patch.getState() != null) {
            order.setState(patch.getState());
        }

        if (patch.getZip() != null) {
            order.setZip(patch.getZip());
        }

        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }

        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }

        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }

        return orderRepo.save(order);
    }
}
