/*
 * This file is generated by jOOQ.
 */
package db;


import db.tables.Nomenclature;
import db.tables.Organisation;
import db.tables.Waybill;
import db.tables.Waybillcontent;

import javax.annotation.processing.Generated;


/**
 * Convenience access to all tables in public.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.Nomenclature</code>.
     */
    public static final Nomenclature NOMENCLATURE = Nomenclature.NOMENCLATURE;

    /**
     * The table <code>public.Organisation</code>.
     */
    public static final Organisation ORGANISATION = Organisation.ORGANISATION;

    /**
     * The table <code>public.Waybill</code>.
     */
    public static final Waybill WAYBILL = Waybill.WAYBILL;

    /**
     * The table <code>public.WaybillContent</code>.
     */
    public static final Waybillcontent WAYBILLCONTENT = Waybillcontent.WAYBILLCONTENT;
}
