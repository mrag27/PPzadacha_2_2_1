package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;
    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        String sql = "from User";
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(sql);
        return query.getResultList();
    }

    @Override
    public User getUserWithCar(String model, int series) {
        String sql = "from User as user where user.car.model = :model and user.car.series = :series";
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery(sql, User.class)
                .setParameter("model", model)
                .setParameter("series", series);
        return query.getResultList().get(0);
    }

}
