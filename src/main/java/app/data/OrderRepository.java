package app.data;

import java.util.Optional;
import app.model.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
