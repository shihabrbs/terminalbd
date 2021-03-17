package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_terminalbd_www_model_SetupRealmProxy extends com.terminalbd.www.model.Setup
    implements RealmObjectProxy, com_terminalbd_www_model_SetupRealmProxyInterface {

    static final class SetupColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long setupIdIndex;
        long deviceIdIndex;
        long uniqueCodeIndex;
        long nameIndex;
        long mobileIndex;
        long emailIndex;
        long locationIdIndex;
        long locationNameIndex;
        long mainAppIndex;
        long mainAppNameIndex;
        long appsManualIndex;
        long websiteIndex;
        long vatRegNoIndex;
        long vatPercentageIndex;
        long vatEnableIndex;

        SetupColumnInfo(OsSchemaInfo schemaInfo) {
            super(16);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Setup");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.setupIdIndex = addColumnDetails("setupId", "setupId", objectSchemaInfo);
            this.deviceIdIndex = addColumnDetails("deviceId", "deviceId", objectSchemaInfo);
            this.uniqueCodeIndex = addColumnDetails("uniqueCode", "uniqueCode", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.mobileIndex = addColumnDetails("mobile", "mobile", objectSchemaInfo);
            this.emailIndex = addColumnDetails("email", "email", objectSchemaInfo);
            this.locationIdIndex = addColumnDetails("locationId", "locationId", objectSchemaInfo);
            this.locationNameIndex = addColumnDetails("locationName", "locationName", objectSchemaInfo);
            this.mainAppIndex = addColumnDetails("mainApp", "mainApp", objectSchemaInfo);
            this.mainAppNameIndex = addColumnDetails("mainAppName", "mainAppName", objectSchemaInfo);
            this.appsManualIndex = addColumnDetails("appsManual", "appsManual", objectSchemaInfo);
            this.websiteIndex = addColumnDetails("website", "website", objectSchemaInfo);
            this.vatRegNoIndex = addColumnDetails("vatRegNo", "vatRegNo", objectSchemaInfo);
            this.vatPercentageIndex = addColumnDetails("vatPercentage", "vatPercentage", objectSchemaInfo);
            this.vatEnableIndex = addColumnDetails("vatEnable", "vatEnable", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        SetupColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new SetupColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final SetupColumnInfo src = (SetupColumnInfo) rawSrc;
            final SetupColumnInfo dst = (SetupColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.setupIdIndex = src.setupIdIndex;
            dst.deviceIdIndex = src.deviceIdIndex;
            dst.uniqueCodeIndex = src.uniqueCodeIndex;
            dst.nameIndex = src.nameIndex;
            dst.mobileIndex = src.mobileIndex;
            dst.emailIndex = src.emailIndex;
            dst.locationIdIndex = src.locationIdIndex;
            dst.locationNameIndex = src.locationNameIndex;
            dst.mainAppIndex = src.mainAppIndex;
            dst.mainAppNameIndex = src.mainAppNameIndex;
            dst.appsManualIndex = src.appsManualIndex;
            dst.websiteIndex = src.websiteIndex;
            dst.vatRegNoIndex = src.vatRegNoIndex;
            dst.vatPercentageIndex = src.vatPercentageIndex;
            dst.vatEnableIndex = src.vatEnableIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private SetupColumnInfo columnInfo;
    private ProxyState<com.terminalbd.www.model.Setup> proxyState;

    com_terminalbd_www_model_SetupRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SetupColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.terminalbd.www.model.Setup>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$setupId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.setupIdIndex);
    }

    @Override
    public void realmSet$setupId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.setupIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.setupIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$deviceId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.deviceIdIndex);
    }

    @Override
    public void realmSet$deviceId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.deviceIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.deviceIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.deviceIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.deviceIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$uniqueCode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.uniqueCodeIndex);
    }

    @Override
    public void realmSet$uniqueCode(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.uniqueCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.uniqueCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.uniqueCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.uniqueCodeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$mobile() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mobileIndex);
    }

    @Override
    public void realmSet$mobile(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mobileIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mobileIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mobileIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mobileIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$locationId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.locationIdIndex);
    }

    @Override
    public void realmSet$locationId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.locationIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.locationIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$locationName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.locationNameIndex);
    }

    @Override
    public void realmSet$locationName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.locationNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.locationNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.locationNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.locationNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$mainApp() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.mainAppIndex);
    }

    @Override
    public void realmSet$mainApp(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.mainAppIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.mainAppIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$mainAppName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mainAppNameIndex);
    }

    @Override
    public void realmSet$mainAppName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mainAppNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mainAppNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mainAppNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mainAppNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$appsManual() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.appsManualIndex);
    }

    @Override
    public void realmSet$appsManual(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.appsManualIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.appsManualIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.appsManualIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.appsManualIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$website() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.websiteIndex);
    }

    @Override
    public void realmSet$website(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.websiteIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.websiteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.websiteIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.websiteIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$vatRegNo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.vatRegNoIndex);
    }

    @Override
    public void realmSet$vatRegNo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.vatRegNoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.vatRegNoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.vatRegNoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.vatRegNoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$vatPercentage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.vatPercentageIndex);
    }

    @Override
    public void realmSet$vatPercentage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.vatPercentageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.vatPercentageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.vatPercentageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.vatPercentageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$vatEnable() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.vatEnableIndex);
    }

    @Override
    public void realmSet$vatEnable(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.vatEnableIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.vatEnableIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Setup", 16, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("setupId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("deviceId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("uniqueCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("mobile", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("locationId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("locationName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("mainApp", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("mainAppName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("appsManual", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("website", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("vatRegNo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("vatPercentage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("vatEnable", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static SetupColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new SetupColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Setup";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Setup";
    }

    @SuppressWarnings("cast")
    public static com.terminalbd.www.model.Setup createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.terminalbd.www.model.Setup obj = null;
        if (update) {
            Table table = realm.getTable(com.terminalbd.www.model.Setup.class);
            SetupColumnInfo columnInfo = (SetupColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.Setup.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.terminalbd.www.model.Setup.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_terminalbd_www_model_SetupRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_terminalbd_www_model_SetupRealmProxy) realm.createObjectInternal(com.terminalbd.www.model.Setup.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_terminalbd_www_model_SetupRealmProxy) realm.createObjectInternal(com.terminalbd.www.model.Setup.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_terminalbd_www_model_SetupRealmProxyInterface objProxy = (com_terminalbd_www_model_SetupRealmProxyInterface) obj;
        if (json.has("setupId")) {
            if (json.isNull("setupId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'setupId' to null.");
            } else {
                objProxy.realmSet$setupId((int) json.getInt("setupId"));
            }
        }
        if (json.has("deviceId")) {
            if (json.isNull("deviceId")) {
                objProxy.realmSet$deviceId(null);
            } else {
                objProxy.realmSet$deviceId((String) json.getString("deviceId"));
            }
        }
        if (json.has("uniqueCode")) {
            if (json.isNull("uniqueCode")) {
                objProxy.realmSet$uniqueCode(null);
            } else {
                objProxy.realmSet$uniqueCode((String) json.getString("uniqueCode"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("mobile")) {
            if (json.isNull("mobile")) {
                objProxy.realmSet$mobile(null);
            } else {
                objProxy.realmSet$mobile((String) json.getString("mobile"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("locationId")) {
            if (json.isNull("locationId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'locationId' to null.");
            } else {
                objProxy.realmSet$locationId((int) json.getInt("locationId"));
            }
        }
        if (json.has("locationName")) {
            if (json.isNull("locationName")) {
                objProxy.realmSet$locationName(null);
            } else {
                objProxy.realmSet$locationName((String) json.getString("locationName"));
            }
        }
        if (json.has("mainApp")) {
            if (json.isNull("mainApp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'mainApp' to null.");
            } else {
                objProxy.realmSet$mainApp((int) json.getInt("mainApp"));
            }
        }
        if (json.has("mainAppName")) {
            if (json.isNull("mainAppName")) {
                objProxy.realmSet$mainAppName(null);
            } else {
                objProxy.realmSet$mainAppName((String) json.getString("mainAppName"));
            }
        }
        if (json.has("appsManual")) {
            if (json.isNull("appsManual")) {
                objProxy.realmSet$appsManual(null);
            } else {
                objProxy.realmSet$appsManual((String) json.getString("appsManual"));
            }
        }
        if (json.has("website")) {
            if (json.isNull("website")) {
                objProxy.realmSet$website(null);
            } else {
                objProxy.realmSet$website((String) json.getString("website"));
            }
        }
        if (json.has("vatRegNo")) {
            if (json.isNull("vatRegNo")) {
                objProxy.realmSet$vatRegNo(null);
            } else {
                objProxy.realmSet$vatRegNo((String) json.getString("vatRegNo"));
            }
        }
        if (json.has("vatPercentage")) {
            if (json.isNull("vatPercentage")) {
                objProxy.realmSet$vatPercentage(null);
            } else {
                objProxy.realmSet$vatPercentage((String) json.getString("vatPercentage"));
            }
        }
        if (json.has("vatEnable")) {
            if (json.isNull("vatEnable")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'vatEnable' to null.");
            } else {
                objProxy.realmSet$vatEnable((boolean) json.getBoolean("vatEnable"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.terminalbd.www.model.Setup createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.terminalbd.www.model.Setup obj = new com.terminalbd.www.model.Setup();
        final com_terminalbd_www_model_SetupRealmProxyInterface objProxy = (com_terminalbd_www_model_SetupRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("setupId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$setupId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'setupId' to null.");
                }
            } else if (name.equals("deviceId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$deviceId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$deviceId(null);
                }
            } else if (name.equals("uniqueCode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$uniqueCode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$uniqueCode(null);
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("mobile")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mobile((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mobile(null);
                }
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else if (name.equals("locationId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$locationId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'locationId' to null.");
                }
            } else if (name.equals("locationName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$locationName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$locationName(null);
                }
            } else if (name.equals("mainApp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mainApp((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'mainApp' to null.");
                }
            } else if (name.equals("mainAppName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mainAppName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mainAppName(null);
                }
            } else if (name.equals("appsManual")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$appsManual((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$appsManual(null);
                }
            } else if (name.equals("website")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$website((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$website(null);
                }
            } else if (name.equals("vatRegNo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$vatRegNo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$vatRegNo(null);
                }
            } else if (name.equals("vatPercentage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$vatPercentage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$vatPercentage(null);
                }
            } else if (name.equals("vatEnable")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$vatEnable((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'vatEnable' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_terminalbd_www_model_SetupRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.terminalbd.www.model.Setup.class), false, Collections.<String>emptyList());
        io.realm.com_terminalbd_www_model_SetupRealmProxy obj = new io.realm.com_terminalbd_www_model_SetupRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.terminalbd.www.model.Setup copyOrUpdate(Realm realm, SetupColumnInfo columnInfo, com.terminalbd.www.model.Setup object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.terminalbd.www.model.Setup) cachedRealmObject;
        }

        com.terminalbd.www.model.Setup realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.terminalbd.www.model.Setup.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_terminalbd_www_model_SetupRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.terminalbd.www.model.Setup copy(Realm realm, SetupColumnInfo columnInfo, com.terminalbd.www.model.Setup newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.terminalbd.www.model.Setup) cachedRealmObject;
        }

        com_terminalbd_www_model_SetupRealmProxyInterface realmObjectSource = (com_terminalbd_www_model_SetupRealmProxyInterface) newObject;

        Table table = realm.getTable(com.terminalbd.www.model.Setup.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.setupIdIndex, realmObjectSource.realmGet$setupId());
        builder.addString(columnInfo.deviceIdIndex, realmObjectSource.realmGet$deviceId());
        builder.addString(columnInfo.uniqueCodeIndex, realmObjectSource.realmGet$uniqueCode());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.mobileIndex, realmObjectSource.realmGet$mobile());
        builder.addString(columnInfo.emailIndex, realmObjectSource.realmGet$email());
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addString(columnInfo.locationNameIndex, realmObjectSource.realmGet$locationName());
        builder.addInteger(columnInfo.mainAppIndex, realmObjectSource.realmGet$mainApp());
        builder.addString(columnInfo.mainAppNameIndex, realmObjectSource.realmGet$mainAppName());
        builder.addString(columnInfo.appsManualIndex, realmObjectSource.realmGet$appsManual());
        builder.addString(columnInfo.websiteIndex, realmObjectSource.realmGet$website());
        builder.addString(columnInfo.vatRegNoIndex, realmObjectSource.realmGet$vatRegNo());
        builder.addString(columnInfo.vatPercentageIndex, realmObjectSource.realmGet$vatPercentage());
        builder.addBoolean(columnInfo.vatEnableIndex, realmObjectSource.realmGet$vatEnable());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_terminalbd_www_model_SetupRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.terminalbd.www.model.Setup object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.terminalbd.www.model.Setup.class);
        long tableNativePtr = table.getNativePtr();
        SetupColumnInfo columnInfo = (SetupColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.Setup.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.setupIdIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$setupId(), false);
        String realmGet$deviceId = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$deviceId();
        if (realmGet$deviceId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deviceIdIndex, rowIndex, realmGet$deviceId, false);
        }
        String realmGet$uniqueCode = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$uniqueCode();
        if (realmGet$uniqueCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uniqueCodeIndex, rowIndex, realmGet$uniqueCode, false);
        }
        String realmGet$name = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$mobile = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mobile();
        if (realmGet$mobile != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
        }
        String realmGet$email = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$locationId(), false);
        String realmGet$locationName = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$locationName();
        if (realmGet$locationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.locationNameIndex, rowIndex, realmGet$locationName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.mainAppIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mainApp(), false);
        String realmGet$mainAppName = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mainAppName();
        if (realmGet$mainAppName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mainAppNameIndex, rowIndex, realmGet$mainAppName, false);
        }
        String realmGet$appsManual = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$appsManual();
        if (realmGet$appsManual != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.appsManualIndex, rowIndex, realmGet$appsManual, false);
        }
        String realmGet$website = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$website();
        if (realmGet$website != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.websiteIndex, rowIndex, realmGet$website, false);
        }
        String realmGet$vatRegNo = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatRegNo();
        if (realmGet$vatRegNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.vatRegNoIndex, rowIndex, realmGet$vatRegNo, false);
        }
        String realmGet$vatPercentage = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatPercentage();
        if (realmGet$vatPercentage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.vatPercentageIndex, rowIndex, realmGet$vatPercentage, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.vatEnableIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatEnable(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.terminalbd.www.model.Setup.class);
        long tableNativePtr = table.getNativePtr();
        SetupColumnInfo columnInfo = (SetupColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.Setup.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.terminalbd.www.model.Setup object = null;
        while (objects.hasNext()) {
            object = (com.terminalbd.www.model.Setup) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.setupIdIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$setupId(), false);
            String realmGet$deviceId = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$deviceId();
            if (realmGet$deviceId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deviceIdIndex, rowIndex, realmGet$deviceId, false);
            }
            String realmGet$uniqueCode = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$uniqueCode();
            if (realmGet$uniqueCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.uniqueCodeIndex, rowIndex, realmGet$uniqueCode, false);
            }
            String realmGet$name = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$mobile = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mobile();
            if (realmGet$mobile != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
            }
            String realmGet$email = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$locationId(), false);
            String realmGet$locationName = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$locationName();
            if (realmGet$locationName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.locationNameIndex, rowIndex, realmGet$locationName, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.mainAppIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mainApp(), false);
            String realmGet$mainAppName = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mainAppName();
            if (realmGet$mainAppName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mainAppNameIndex, rowIndex, realmGet$mainAppName, false);
            }
            String realmGet$appsManual = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$appsManual();
            if (realmGet$appsManual != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.appsManualIndex, rowIndex, realmGet$appsManual, false);
            }
            String realmGet$website = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$website();
            if (realmGet$website != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.websiteIndex, rowIndex, realmGet$website, false);
            }
            String realmGet$vatRegNo = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatRegNo();
            if (realmGet$vatRegNo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.vatRegNoIndex, rowIndex, realmGet$vatRegNo, false);
            }
            String realmGet$vatPercentage = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatPercentage();
            if (realmGet$vatPercentage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.vatPercentageIndex, rowIndex, realmGet$vatPercentage, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.vatEnableIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatEnable(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.terminalbd.www.model.Setup object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.terminalbd.www.model.Setup.class);
        long tableNativePtr = table.getNativePtr();
        SetupColumnInfo columnInfo = (SetupColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.Setup.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.setupIdIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$setupId(), false);
        String realmGet$deviceId = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$deviceId();
        if (realmGet$deviceId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deviceIdIndex, rowIndex, realmGet$deviceId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.deviceIdIndex, rowIndex, false);
        }
        String realmGet$uniqueCode = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$uniqueCode();
        if (realmGet$uniqueCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uniqueCodeIndex, rowIndex, realmGet$uniqueCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.uniqueCodeIndex, rowIndex, false);
        }
        String realmGet$name = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$mobile = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mobile();
        if (realmGet$mobile != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mobileIndex, rowIndex, false);
        }
        String realmGet$email = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$locationId(), false);
        String realmGet$locationName = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$locationName();
        if (realmGet$locationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.locationNameIndex, rowIndex, realmGet$locationName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.locationNameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.mainAppIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mainApp(), false);
        String realmGet$mainAppName = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mainAppName();
        if (realmGet$mainAppName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mainAppNameIndex, rowIndex, realmGet$mainAppName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mainAppNameIndex, rowIndex, false);
        }
        String realmGet$appsManual = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$appsManual();
        if (realmGet$appsManual != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.appsManualIndex, rowIndex, realmGet$appsManual, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.appsManualIndex, rowIndex, false);
        }
        String realmGet$website = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$website();
        if (realmGet$website != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.websiteIndex, rowIndex, realmGet$website, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.websiteIndex, rowIndex, false);
        }
        String realmGet$vatRegNo = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatRegNo();
        if (realmGet$vatRegNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.vatRegNoIndex, rowIndex, realmGet$vatRegNo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.vatRegNoIndex, rowIndex, false);
        }
        String realmGet$vatPercentage = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatPercentage();
        if (realmGet$vatPercentage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.vatPercentageIndex, rowIndex, realmGet$vatPercentage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.vatPercentageIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.vatEnableIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatEnable(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.terminalbd.www.model.Setup.class);
        long tableNativePtr = table.getNativePtr();
        SetupColumnInfo columnInfo = (SetupColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.Setup.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.terminalbd.www.model.Setup object = null;
        while (objects.hasNext()) {
            object = (com.terminalbd.www.model.Setup) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.setupIdIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$setupId(), false);
            String realmGet$deviceId = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$deviceId();
            if (realmGet$deviceId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deviceIdIndex, rowIndex, realmGet$deviceId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.deviceIdIndex, rowIndex, false);
            }
            String realmGet$uniqueCode = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$uniqueCode();
            if (realmGet$uniqueCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.uniqueCodeIndex, rowIndex, realmGet$uniqueCode, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.uniqueCodeIndex, rowIndex, false);
            }
            String realmGet$name = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$mobile = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mobile();
            if (realmGet$mobile != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mobileIndex, rowIndex, false);
            }
            String realmGet$email = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$locationId(), false);
            String realmGet$locationName = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$locationName();
            if (realmGet$locationName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.locationNameIndex, rowIndex, realmGet$locationName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.locationNameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.mainAppIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mainApp(), false);
            String realmGet$mainAppName = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$mainAppName();
            if (realmGet$mainAppName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mainAppNameIndex, rowIndex, realmGet$mainAppName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mainAppNameIndex, rowIndex, false);
            }
            String realmGet$appsManual = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$appsManual();
            if (realmGet$appsManual != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.appsManualIndex, rowIndex, realmGet$appsManual, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.appsManualIndex, rowIndex, false);
            }
            String realmGet$website = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$website();
            if (realmGet$website != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.websiteIndex, rowIndex, realmGet$website, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.websiteIndex, rowIndex, false);
            }
            String realmGet$vatRegNo = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatRegNo();
            if (realmGet$vatRegNo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.vatRegNoIndex, rowIndex, realmGet$vatRegNo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.vatRegNoIndex, rowIndex, false);
            }
            String realmGet$vatPercentage = ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatPercentage();
            if (realmGet$vatPercentage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.vatPercentageIndex, rowIndex, realmGet$vatPercentage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.vatPercentageIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.vatEnableIndex, rowIndex, ((com_terminalbd_www_model_SetupRealmProxyInterface) object).realmGet$vatEnable(), false);
        }
    }

    public static com.terminalbd.www.model.Setup createDetachedCopy(com.terminalbd.www.model.Setup realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.terminalbd.www.model.Setup unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.terminalbd.www.model.Setup();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.terminalbd.www.model.Setup) cachedObject.object;
            }
            unmanagedObject = (com.terminalbd.www.model.Setup) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_terminalbd_www_model_SetupRealmProxyInterface unmanagedCopy = (com_terminalbd_www_model_SetupRealmProxyInterface) unmanagedObject;
        com_terminalbd_www_model_SetupRealmProxyInterface realmSource = (com_terminalbd_www_model_SetupRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$setupId(realmSource.realmGet$setupId());
        unmanagedCopy.realmSet$deviceId(realmSource.realmGet$deviceId());
        unmanagedCopy.realmSet$uniqueCode(realmSource.realmGet$uniqueCode());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$mobile(realmSource.realmGet$mobile());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$locationId(realmSource.realmGet$locationId());
        unmanagedCopy.realmSet$locationName(realmSource.realmGet$locationName());
        unmanagedCopy.realmSet$mainApp(realmSource.realmGet$mainApp());
        unmanagedCopy.realmSet$mainAppName(realmSource.realmGet$mainAppName());
        unmanagedCopy.realmSet$appsManual(realmSource.realmGet$appsManual());
        unmanagedCopy.realmSet$website(realmSource.realmGet$website());
        unmanagedCopy.realmSet$vatRegNo(realmSource.realmGet$vatRegNo());
        unmanagedCopy.realmSet$vatPercentage(realmSource.realmGet$vatPercentage());
        unmanagedCopy.realmSet$vatEnable(realmSource.realmGet$vatEnable());

        return unmanagedObject;
    }

    static com.terminalbd.www.model.Setup update(Realm realm, SetupColumnInfo columnInfo, com.terminalbd.www.model.Setup realmObject, com.terminalbd.www.model.Setup newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_terminalbd_www_model_SetupRealmProxyInterface realmObjectTarget = (com_terminalbd_www_model_SetupRealmProxyInterface) realmObject;
        com_terminalbd_www_model_SetupRealmProxyInterface realmObjectSource = (com_terminalbd_www_model_SetupRealmProxyInterface) newObject;
        Table table = realm.getTable(com.terminalbd.www.model.Setup.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.setupIdIndex, realmObjectSource.realmGet$setupId());
        builder.addString(columnInfo.deviceIdIndex, realmObjectSource.realmGet$deviceId());
        builder.addString(columnInfo.uniqueCodeIndex, realmObjectSource.realmGet$uniqueCode());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.mobileIndex, realmObjectSource.realmGet$mobile());
        builder.addString(columnInfo.emailIndex, realmObjectSource.realmGet$email());
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addString(columnInfo.locationNameIndex, realmObjectSource.realmGet$locationName());
        builder.addInteger(columnInfo.mainAppIndex, realmObjectSource.realmGet$mainApp());
        builder.addString(columnInfo.mainAppNameIndex, realmObjectSource.realmGet$mainAppName());
        builder.addString(columnInfo.appsManualIndex, realmObjectSource.realmGet$appsManual());
        builder.addString(columnInfo.websiteIndex, realmObjectSource.realmGet$website());
        builder.addString(columnInfo.vatRegNoIndex, realmObjectSource.realmGet$vatRegNo());
        builder.addString(columnInfo.vatPercentageIndex, realmObjectSource.realmGet$vatPercentage());
        builder.addBoolean(columnInfo.vatEnableIndex, realmObjectSource.realmGet$vatEnable());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Setup = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{setupId:");
        stringBuilder.append(realmGet$setupId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{deviceId:");
        stringBuilder.append(realmGet$deviceId() != null ? realmGet$deviceId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{uniqueCode:");
        stringBuilder.append(realmGet$uniqueCode() != null ? realmGet$uniqueCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mobile:");
        stringBuilder.append(realmGet$mobile() != null ? realmGet$mobile() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{locationId:");
        stringBuilder.append(realmGet$locationId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{locationName:");
        stringBuilder.append(realmGet$locationName() != null ? realmGet$locationName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mainApp:");
        stringBuilder.append(realmGet$mainApp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mainAppName:");
        stringBuilder.append(realmGet$mainAppName() != null ? realmGet$mainAppName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{appsManual:");
        stringBuilder.append(realmGet$appsManual() != null ? realmGet$appsManual() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{website:");
        stringBuilder.append(realmGet$website() != null ? realmGet$website() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{vatRegNo:");
        stringBuilder.append(realmGet$vatRegNo() != null ? realmGet$vatRegNo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{vatPercentage:");
        stringBuilder.append(realmGet$vatPercentage() != null ? realmGet$vatPercentage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{vatEnable:");
        stringBuilder.append(realmGet$vatEnable());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_terminalbd_www_model_SetupRealmProxy aSetup = (com_terminalbd_www_model_SetupRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSetup.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSetup.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSetup.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
