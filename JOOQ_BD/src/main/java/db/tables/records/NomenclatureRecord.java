/*
 * This file is generated by jOOQ.
 */
package db.tables.records;


import db.tables.Nomenclature;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class NomenclatureRecord extends UpdatableRecordImpl<NomenclatureRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.Nomenclature.id</code>.
     */
    public NomenclatureRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.Nomenclature.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.Nomenclature.name</code>.
     */
    public NomenclatureRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.Nomenclature.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Nomenclature.NOMENCLATURE.ID;
    }

    @Override
    public Field<String> field2() {
        return Nomenclature.NOMENCLATURE.NAME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public NomenclatureRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public NomenclatureRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public NomenclatureRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached NomenclatureRecord
     */
    public NomenclatureRecord() {
        super(Nomenclature.NOMENCLATURE);
    }

    /**
     * Create a detached, initialised NomenclatureRecord
     */
    public NomenclatureRecord(Integer id, String name) {
        super(Nomenclature.NOMENCLATURE);

        setId(id);
        setName(name);
    }
}
