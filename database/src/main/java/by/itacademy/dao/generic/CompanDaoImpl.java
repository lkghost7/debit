package by.itacademy.dao.generic;

import by.itacademy.dao.generic.BaseDaoImpl;
import by.itacademy.dao.generic.CompanDao;
import by.itacademy.model.BaseEntity;
import by.itacademy.model.Company;

import java.io.Serializable;

<<<<<<< .merge_file_a07060
    private static final Object LOCK = new Object();
    private static CompanDaoImpl INSTANCE = null;
    public static CompanDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CompanDaoImpl(Company.class);
                }
            }
        }
        return INSTANCE;
    }

    public CompanDaoImpl(Class<Company> modelClass) {
        super(modelClass);
    }
=======
public abstract class CompanDaoImpl<P extends Serializable, E extends BaseEntity<P>> implements BaseDao<P, E>{

//    public CompanDaoImpl(Class<Company> modelClass) {
//        super(modelClass);
//    }

private Class<E> clazz;
>>>>>>> .merge_file_a11104
}


