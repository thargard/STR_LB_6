import org.example.hibLab.authorization.LogIn;
import org.example.hibLab.dao.daoImpl.CompanyDaoImpl;
import org.example.hibLab.dao.daoImpl.PersonDaoImpl;
import org.example.hibLab.entity.Company;
import org.example.hibLab.entity.Person;
import org.example.hibLab.sessionFactory.SessionFactoryImpl;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HibTest {
    @Test
    public void authTest(){
        String login = "thargard";
        String pass = "root";
        LogIn logIn = new LogIn();
        int res = logIn.authorizationForTest(login, pass);
        assertEquals(1, res);
    }

    @Test
    public void showPersonTable(){
        try {
            PersonDaoImpl pdi = new PersonDaoImpl();
            List<Person> list = pdi.showPeople();
            assertNotNull(list);
        } catch (Exception e){
            fail();
        }
    }

    @Test
    public void addCompanyToDb(){
        Company com = new Company("Volvo", "Sweden");
        try {
            CompanyDaoImpl cdi = new CompanyDaoImpl();
            boolean successed = cdi.addCompany(com);
            assertTrue(successed);
        } catch (Exception e){
            fail();
        }
    }

    @Test
    public void deleteCompanyFromDb(){
        CompanyDaoImpl pdi = new CompanyDaoImpl();
        List<Company> list = pdi.showCompanies();
        Company lastCom = list.get(list.size() - 1);
        try {
            boolean isDeleted = pdi.deleteCompany(lastCom.getCompanyId());
            assertTrue(isDeleted);
        } catch (NoClassDefFoundError e){
            fail();
        }
    }

    @Test
    public void findPersonByIdd(){
        Person person;
        try {
            PersonDaoImpl pdi = new PersonDaoImpl();
            person = pdi.findPersonById(2);
            assertNotNull(person);
        } catch (NoClassDefFoundError e){
            fail();
        }
    }
}
