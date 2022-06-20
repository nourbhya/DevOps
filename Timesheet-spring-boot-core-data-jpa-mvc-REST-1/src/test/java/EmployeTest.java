import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmployeTest {

    @Autowired
    private IEmployeService serv;

    @Test
    @Rollback(false)
    public void createListUser() {
        Employe us = new Employe("test1","test","test1@gmail.com",true);
        int id = serv.ajouterEmploye(us);
        assertNotNull(id);
    }
    @Test
    public void getListUser() {
        List<Employe> task = serv.getAllEmployes();
        Assertions.assertThat(task.size()).isGreaterThan(0);
    }
    @Test
    public void testFindUserByName() {
        String name = "test1";
        Employe user = serv.findByName(name);
        Assertions.assertThat(user.getNom()).isEqualTo(name);
    }

}