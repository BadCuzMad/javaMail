/*
 * This file is generated by jOOQ.
 */
package db.tables.daos;


import db.tables.Nomenclature;
import db.tables.records.NomenclatureRecord;

import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class NomenclatureDao extends DAOImpl<NomenclatureRecord, db.tables.pojos.Nomenclature, Integer> {

    /**
     * Create a new NomenclatureDao without any configuration
     */
    public NomenclatureDao() {
        super(Nomenclature.NOMENCLATURE, db.tables.pojos.Nomenclature.class);
    }

    /**
     * Create a new NomenclatureDao with an attached configuration
     */
    public NomenclatureDao(Configuration configuration) {
        super(Nomenclature.NOMENCLATURE, db.tables.pojos.Nomenclature.class, configuration);
    }

    @Override
    public Integer getId(db.tables.pojos.Nomenclature object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<db.tables.pojos.Nomenclature> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Nomenclature.NOMENCLATURE.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<db.tables.pojos.Nomenclature> fetchById(Integer... values) {
        return fetch(Nomenclature.NOMENCLATURE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public db.tables.pojos.Nomenclature fetchOneById(Integer value) {
        return fetchOne(Nomenclature.NOMENCLATURE.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<db.tables.pojos.Nomenclature> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Nomenclature.NOMENCLATURE.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<db.tables.pojos.Nomenclature> fetchByName(String... values) {
        return fetch(Nomenclature.NOMENCLATURE.NAME, values);
    }
}