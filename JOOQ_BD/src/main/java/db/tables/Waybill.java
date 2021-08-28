/*
 * This file is generated by jOOQ.
 */
package db.tables;


import db.Keys;
import db.Public;
import db.tables.records.WaybillRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class Waybill extends TableImpl<WaybillRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.Waybill</code>
     */
    public static final Waybill WAYBILL = new Waybill();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WaybillRecord> getRecordType() {
        return WaybillRecord.class;
    }

    /**
     * The column <code>public.Waybill.id</code>.
     */
    public final TableField<WaybillRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.Waybill.number</code>.
     */
    public final TableField<WaybillRecord, Integer> NUMBER = createField(DSL.name("number"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.Waybill.date</code>.
     */
    public final TableField<WaybillRecord, String> DATE = createField(DSL.name("date"), SQLDataType.VARCHAR(255).defaultValue(DSL.field("NULL::character varying", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>public.Waybill.organisation</code>.
     */
    public final TableField<WaybillRecord, String> ORGANISATION = createField(DSL.name("organisation"), SQLDataType.VARCHAR(255).defaultValue(DSL.field("NULL::character varying", SQLDataType.VARCHAR)), this, "");

    private Waybill(Name alias, Table<WaybillRecord> aliased) {
        this(alias, aliased, null);
    }

    private Waybill(Name alias, Table<WaybillRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.Waybill</code> table reference
     */
    public Waybill(String alias) {
        this(DSL.name(alias), WAYBILL);
    }

    /**
     * Create an aliased <code>public.Waybill</code> table reference
     */
    public Waybill(Name alias) {
        this(alias, WAYBILL);
    }

    /**
     * Create a <code>public.Waybill</code> table reference
     */
    public Waybill() {
        this(DSL.name("Waybill"), null);
    }

    public <O extends Record> Waybill(Table<O> child, ForeignKey<O, WaybillRecord> key) {
        super(child, key, WAYBILL);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<WaybillRecord> getPrimaryKey() {
        return Keys.WAYBILL_PKEY;
    }

    @Override
    public List<UniqueKey<WaybillRecord>> getKeys() {
        return Arrays.<UniqueKey<WaybillRecord>>asList(Keys.WAYBILL_PKEY);
    }

    @Override
    public Waybill as(String alias) {
        return new Waybill(DSL.name(alias), this);
    }

    @Override
    public Waybill as(Name alias) {
        return new Waybill(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Waybill rename(String name) {
        return new Waybill(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Waybill rename(Name name) {
        return new Waybill(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
