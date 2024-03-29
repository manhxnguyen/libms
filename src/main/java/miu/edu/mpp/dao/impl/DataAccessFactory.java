package miu.edu.mpp.dao.impl;

import miu.edu.mpp.dao.DataAccess;
import miu.edu.mpp.enums.DataAccessType;
import miu.edu.mpp.exception.DataAccessException;

public class DataAccessFactory {

    private static DataAccessMongo mongoDB;
    private static DataAccessFacade facade;

    public static DataAccess createDataAccess(DataAccessType accessType) {
        if (accessType.equals(DataAccessType.MONGO)) {
            if (mongoDB == null) {
                mongoDB = DataAccessMongo.INSTANCE;
            }
            return mongoDB;
        }
        if (accessType.equals(DataAccessType.FACADE)) {
            if (facade == null) {
                facade = DataAccessFacade.INSTANCE;
            }
            return facade;
        }
        throw new DataAccessException("Data access not supported!");
    }

    public static DataAccessFacade defaultDataAccess() {
        return (DataAccessFacade) createDataAccess(DataAccessType.FACADE);
    }
}
