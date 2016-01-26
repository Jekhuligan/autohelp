package com.autohelp.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * Created by jek on 10.01.16.
 */
@Repository
@Table(name="Price")
public interface PriceRepository extends CrudRepository<PriceModel, Long>
{

}
