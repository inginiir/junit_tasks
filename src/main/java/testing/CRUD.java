package testing;

import java.util.HashMap;
import java.util.Map;

public class CRUD {

    private Map<Integer, Entity> base = new HashMap<>();
    public boolean create(Entity entity) {
        if (base.containsKey(entity.getId())) {
            return false;
        } else {
            base.put(entity.getId(),entity);
            return true;
        }
    }

    public Entity read(int id) {
        return base.get(id);
    }

    public boolean update(Entity entity) {

        if (!base.containsKey(entity.getId())) {
            return false;
        } else {
            base.put(entity.getId(),entity);
            return true;
        }
    }

    public  boolean delete(int id) {
        if (!base.containsKey(id)) {
            return false;
        } else {
            base.remove(id);
            return true;
        }
    }
}
