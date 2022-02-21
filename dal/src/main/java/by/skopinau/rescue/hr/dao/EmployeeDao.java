package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.EmployeeEntity;
import java.util.List;

/**
 * Data Access Object for employee.
 */
public interface EmployeeDao {
    /**
     * Add employee
     * @param employeeEntity object of EmployeeEntity
     */
    void save(EmployeeEntity employeeEntity);

    /**
     * Get all employees by rank id
     * @param rankId id for Rank
     * @return all employees {@link EmployeeEntity}
     */
    List<EmployeeEntity> getByRankId(long rankId);

    /**
     * Get all employees by subdivision id
     * @param subdivisionId id for Subdivision
     * @return all employees {@link EmployeeEntity}
     */
    List<EmployeeEntity> getBySubdivisionId(long subdivisionId);

    /**
     * Get all employees by position id
     * @param positionId id for Position
     * @return all employees {@link EmployeeEntity}
     */
    List<EmployeeEntity> getByPositionId(long positionId);

    /**
     * Get employee by id.
     *
     * @param id unique field for employee
     * @return employee {@link EmployeeEntity}
     */
    EmployeeEntity getById(long id);
}
