package com.autohelp.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * Created by jek on 27.12.15.
 */
@Repository
@Table(name="Appointments")
public interface AppointmentsRepository extends CrudRepository<AppointmentsModel, Long>
{

}
