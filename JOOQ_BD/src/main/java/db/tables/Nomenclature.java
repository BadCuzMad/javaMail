/*
 * This file is generated by jOOQ.
 */
package db.tables;


import db.Keys;
import db.Public;
import db.tables.records.NomenclatureRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


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
public class Nomenclature extends TableImpl<NomenclatureRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.Nomenclature</code>
     */
    public static final Nomenclature NOMENCLATURE = new Nomenclature();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NomenclatureRecord> getRecordType() {
        return NomenclatureRecord.class;
    }

    /**
     * The column <code>public.Nomenclature.id</code>.
     */
    public final TableField<NomenclatureRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.Nomenclature.name</code>.
     */
    public final TableField<NomenclatureRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    private Nomenclature(Name alias, Table<NomenclatureRecord> aliased) {
        this(alias, aliased, null);
    }

    private Nomenclature(Name alias, Table<NomenclatureRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.Nomenclature</code> table reference
     */
    public Nomenclature(String alias) {
        this(DSL.name(alias), NOMENCLATURE);
    }

    /**
     * Create an aliased <code>public.Nomenclature</code> table reference
     */
    public Nomenclature(Name alias) {
        this(alias, NOMENCLATURE);
    }

    /**
     * Create a <code>public.Nomenclature</code> table reference
     */
    public Nomenclature() {
        this(DSL.name("Nomenclature"), null);
    }

    public <O extends Record> Nomenclature(Table<O> child, ForeignKey<O, NomenclatureRecord> key) {
        super(child, key, NOMENCLATURE);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<NomenclatureRecord> getPrimaryKey() {
        return Keys.NOMENCLATURE_PKEY;
    }

    @Override
    public List<UniqueKey<NomenclatureRecord>> getKeys() {
        return Arrays.<UniqueKey<NomenclatureRecord>>asList(Keys.NOMENCLATURE_PKEY);
    }

    @Override
    public Nomenclature as(String alias) {
        return new Nomenclature(DSL.name(alias), this);
    }

    @Override
    public Nomenclature as(Name alias) {
        return new Nomenclature(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Nomenclature rename(String name) {
        return new Nomenclature(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Nomenclature rename(Name name) {
        return new Nomenclature(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
