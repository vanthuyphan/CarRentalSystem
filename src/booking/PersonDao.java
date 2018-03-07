package booking;

import java.util.List;

/**
 * Created by admin on 3/7/18.
 */
public interface PersonDao {

    void createPersonTable();

    void insert(Person person);

    Person selectById(int id);

    List<Person> selectAll();

    void delete(int id);

    void update(Person person,int id);
}
