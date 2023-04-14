package org.example.ioc.nonioc;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liyunfei
 **/
public class PersonServiceImpl implements PersonService{

    private final PersonDao personDao;

//    @Autowired
//    private PersonDao personDao2;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    /**
     * 添加用户
     * @param person
     * @return
     */
    @Override
    public boolean add(Person person) {
        personDao.insert(person);
        return true;
    }
}
