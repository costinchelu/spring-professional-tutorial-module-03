package question14.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.*;

@Repository
public class EmployeeDao {

    @Transactional(propagation = REQUIRED)
    public void requiredTransactionMethod() {
        /*
        Starting callRequiredWithoutCurrentTransaction
            (REQUIRED DID NOT FIND ANY TRANSACTIONAL ON THE METHOD THAT CALLED IT SO IT DECIDED TO CREATE A NEW ONE)
        Data Source Trace: Connection javax.sql.DataSource.getConnection()
            Starting requiredTransactionMethod
            Completed requiredTransactionMethod
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
        Completed callRequiredWithoutCurrentTransaction

        Data Source Trace: Connection javax.sql.DataSource.getConnection()
        Starting callRequiredWithCurrentTransaction (transaction is created before this method is called)
            Starting requiredTransactionMethod
            Completed requiredTransactionMethod
        Completed callRequiredWithCurrentTransaction
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
         */
    }

    @Transactional(propagation = SUPPORTS)
    public void supportsTransactionMethod() {
        /*
        Starting callSupportsWithoutCurrentTransaction
            (DID NOT FIND A TRANSACTIONAL AND DID NOT CREATE ONE)
            Starting supportsTransactionMethod
            Completed supportsTransactionMethod
        Completed callSupportsWithoutCurrentTransaction

        Data Source Trace: Connection javax.sql.DataSource.getConnection()
        Starting callSupportsWithCurrentTransaction
            Starting supportsTransactionMethod
            Completed supportsTransactionMethod
        Completed callSupportsWithCurrentTransaction
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
         */
    }

    @Transactional(propagation = MANDATORY)
    public void mandatoryTransactionMethod() {
        /*
        Starting callMandatoryWithoutCurrentTransaction
            (IF TRANSACTIONAL NOT FOUND ON THE CALLING METHOD, THEN IT WILL THROW AN EXCEPTION)
        Exception thrown from callMandatoryWithoutCurrentTransaction: No existing transaction found for transaction marked with propagation 'mandatory'
        Completed callMandatoryWithoutCurrentTransaction

        Data Source Trace: Connection javax.sql.DataSource.getConnection()
        Starting callMandatoryWithCurrentTransaction
            Starting mandatoryTransactionMethod
            Completed mandatoryTransactionMethod
        Completed callMandatoryWithCurrentTransaction
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
         */
    }

    @Transactional(propagation = REQUIRES_NEW)
    public void requiresNewTransactionMethod() {
        /*
        Starting callRequiresNewWithoutCurrentTransaction
            (REQUIRES_NEW WILL CREATE A NEW TRANSACTION)
        Data Source Trace: Connection javax.sql.DataSource.getConnection()
            Starting requiresNewTransactionMethod
            Completed requiresNewTransactionMethod
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
        Completed callRequiresNewWithoutCurrentTransaction

        Data Source Trace: Connection javax.sql.DataSource.getConnection()
            (BECAUSE WE HAVE REQUIRES_NEW THIS WILL CREATE A NEW TRANSACTION WHEN THE CALLING METHOD STARTS, AND THEN IT WILL
            CLOSE IT IN ORDER TO CREATE ANOTHER NEW TRANSACTION)
        Starting callRequiresNewWithCurrentTransaction
        Data Source Trace: Connection javax.sql.DataSource.getConnection()
            Starting requiresNewTransactionMethod
            Completed requiresNewTransactionMethod
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
        Completed callRequiresNewWithCurrentTransaction
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
         */
    }

    @Transactional(propagation = NOT_SUPPORTED)
    public void notSupportedTransactionMethod() {
        /*
        Starting callNotSupportedWithoutCurrentTransaction
            (NOT_SUPPORTED WILL NOT FIND A TRANSACTION SO IT WILL DO NOTHING, BUT IN THE SECOND CALL (WITH TRANSACTION) WILL
            STOP THE TRANSACTION)
            Starting notSupportedTransactionMethod
            Completed notSupportedTransactionMethod
        Completed callNotSupportedWithoutCurrentTransaction

        Data Source Trace: Connection javax.sql.DataSource.getConnection()
        Starting callNotSupportedWithCurrentTransaction
            Starting notSupportedTransactionMethod
            Completed notSupportedTransactionMethod
        Completed callNotSupportedWithCurrentTransaction
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
         */
    }

    @Transactional(propagation = NEVER)
    public void neverTransactionMethod() {
        /*
        Starting callNeverWithoutCurrentTransaction
            (NEVER WILL THROW AN EXCEPTION WHEN IT WILL FIND A TRANSACTION)
            Starting neverTransactionMethod
            Completed neverTransactionMethod
        Completed callNeverWithoutCurrentTransaction

        Data Source Trace: Connection javax.sql.DataSource.getConnection()
            Starting callNeverWithCurrentTransaction
        Exception thrown from callNeverWithCurrentTransaction: Existing transaction found for transaction marked with propagation 'never'
            Completed callNeverWithCurrentTransaction
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
         */
    }

    @Transactional(propagation = NESTED)
    public void nestedTransactionMethod() {
        /*
        Starting callNestedWithoutCurrentTransaction
            (IF THERE IS NO TRANSACTION IT WILL BEHAVE EXACTLY LIKE REQUIRED)
        Data Source Trace: Connection javax.sql.DataSource.getConnection()
            Starting nestedTransactionMethod
            Completed nestedTransactionMethod
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
        Completed callNestedWithoutCurrentTransaction

        Data Source Trace: Connection javax.sql.DataSource.getConnection()
        Starting callNestedWithCurrentTransaction
            Starting nestedTransactionMethod
            Completed nestedTransactionMethod
        Completed callNestedWithCurrentTransaction
        Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
        Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
         */
    }
}
