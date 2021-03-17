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
public class com_terminalbd_www_model_AnonymousCustomerRealmProxy extends com.terminalbd.www.model.AnonymousCustomer
    implements RealmObjectProxy, com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface {

    static final class AnonymousCustomerColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long globalIdIndex;
        long customerIdIndex;
        long nameIndex;
        long mobileIndex;

        AnonymousCustomerColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("AnonymousCustomer");
            this.globalIdIndex = addColumnDetails("globalId", "globalId", objectSchemaInfo);
            this.customerIdIndex = addColumnDetails("customerId", "customerId", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.mobileIndex = addColumnDetails("mobile", "mobile", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        AnonymousCustomerColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new AnonymousCustomerColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final AnonymousCustomerColumnInfo src = (AnonymousCustomerColumnInfo) rawSrc;
            final AnonymousCustomerColumnInfo dst = (AnonymousCustomerColumnInfo) rawDst;
            dst.globalIdIndex = src.globalIdIndex;
            dst.customerIdIndex = src.customerIdIndex;
            dst.nameIndex = src.nameIndex;
            dst.mobileIndex = src.mobileIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private AnonymousCustomerColumnInfo columnInfo;
    private ProxyState<com.terminalbd.www.model.AnonymousCustomer> proxyState;

    com_terminalbd_www_model_AnonymousCustomerRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AnonymousCustomerColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.terminalbd.www.model.AnonymousCustomer>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$globalId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.globalIdIndex);
    }

    @Override
    public void realmSet$globalId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.globalIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.globalIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$customerId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.customerIdIndex);
    }

    @Override
    public void realmSet$customerId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.customerIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.customerIdIndex, value);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("AnonymousCustomer", 4, 0);
        builder.addPersistedProperty("globalId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("customerId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("mobile", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AnonymousCustomerColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new AnonymousCustomerColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "AnonymousCustomer";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "AnonymousCustomer";
    }

    @SuppressWarnings("cast")
    public static com.terminalbd.www.model.AnonymousCustomer createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.terminalbd.www.model.AnonymousCustomer obj = realm.createObjectInternal(com.terminalbd.www.model.AnonymousCustomer.class, true, excludeFields);

        final com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface objProxy = (com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) obj;
        if (json.has("globalId")) {
            if (json.isNull("globalId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'globalId' to null.");
            } else {
                objProxy.realmSet$globalId((int) json.getInt("globalId"));
            }
        }
        if (json.has("customerId")) {
            if (json.isNull("customerId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'customerId' to null.");
            } else {
                objProxy.realmSet$customerId((int) json.getInt("customerId"));
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
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.terminalbd.www.model.AnonymousCustomer createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.terminalbd.www.model.AnonymousCustomer obj = new com.terminalbd.www.model.AnonymousCustomer();
        final com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface objProxy = (com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("globalId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$globalId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'globalId' to null.");
                }
            } else if (name.equals("customerId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$customerId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'customerId' to null.");
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
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_terminalbd_www_model_AnonymousCustomerRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.terminalbd.www.model.AnonymousCustomer.class), false, Collections.<String>emptyList());
        io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy obj = new io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.terminalbd.www.model.AnonymousCustomer copyOrUpdate(Realm realm, AnonymousCustomerColumnInfo columnInfo, com.terminalbd.www.model.AnonymousCustomer object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.terminalbd.www.model.AnonymousCustomer) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.terminalbd.www.model.AnonymousCustomer copy(Realm realm, AnonymousCustomerColumnInfo columnInfo, com.terminalbd.www.model.AnonymousCustomer newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.terminalbd.www.model.AnonymousCustomer) cachedRealmObject;
        }

        com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface realmObjectSource = (com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) newObject;

        Table table = realm.getTable(com.terminalbd.www.model.AnonymousCustomer.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.globalIdIndex, realmObjectSource.realmGet$globalId());
        builder.addInteger(columnInfo.customerIdIndex, realmObjectSource.realmGet$customerId());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.mobileIndex, realmObjectSource.realmGet$mobile());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.terminalbd.www.model.AnonymousCustomer object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.terminalbd.www.model.AnonymousCustomer.class);
        long tableNativePtr = table.getNativePtr();
        AnonymousCustomerColumnInfo columnInfo = (AnonymousCustomerColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.AnonymousCustomer.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.globalIdIndex, rowIndex, ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$globalId(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.customerIdIndex, rowIndex, ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$customerId(), false);
        String realmGet$name = ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$mobile = ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$mobile();
        if (realmGet$mobile != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.terminalbd.www.model.AnonymousCustomer.class);
        long tableNativePtr = table.getNativePtr();
        AnonymousCustomerColumnInfo columnInfo = (AnonymousCustomerColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.AnonymousCustomer.class);
        com.terminalbd.www.model.AnonymousCustomer object = null;
        while (objects.hasNext()) {
            object = (com.terminalbd.www.model.AnonymousCustomer) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.globalIdIndex, rowIndex, ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$globalId(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.customerIdIndex, rowIndex, ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$customerId(), false);
            String realmGet$name = ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$mobile = ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$mobile();
            if (realmGet$mobile != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.terminalbd.www.model.AnonymousCustomer object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.terminalbd.www.model.AnonymousCustomer.class);
        long tableNativePtr = table.getNativePtr();
        AnonymousCustomerColumnInfo columnInfo = (AnonymousCustomerColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.AnonymousCustomer.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.globalIdIndex, rowIndex, ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$globalId(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.customerIdIndex, rowIndex, ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$customerId(), false);
        String realmGet$name = ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$mobile = ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$mobile();
        if (realmGet$mobile != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mobileIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.terminalbd.www.model.AnonymousCustomer.class);
        long tableNativePtr = table.getNativePtr();
        AnonymousCustomerColumnInfo columnInfo = (AnonymousCustomerColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.AnonymousCustomer.class);
        com.terminalbd.www.model.AnonymousCustomer object = null;
        while (objects.hasNext()) {
            object = (com.terminalbd.www.model.AnonymousCustomer) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.globalIdIndex, rowIndex, ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$globalId(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.customerIdIndex, rowIndex, ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$customerId(), false);
            String realmGet$name = ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$mobile = ((com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) object).realmGet$mobile();
            if (realmGet$mobile != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mobileIndex, rowIndex, realmGet$mobile, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mobileIndex, rowIndex, false);
            }
        }
    }

    public static com.terminalbd.www.model.AnonymousCustomer createDetachedCopy(com.terminalbd.www.model.AnonymousCustomer realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.terminalbd.www.model.AnonymousCustomer unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.terminalbd.www.model.AnonymousCustomer();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.terminalbd.www.model.AnonymousCustomer) cachedObject.object;
            }
            unmanagedObject = (com.terminalbd.www.model.AnonymousCustomer) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface unmanagedCopy = (com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) unmanagedObject;
        com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface realmSource = (com_terminalbd_www_model_AnonymousCustomerRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$globalId(realmSource.realmGet$globalId());
        unmanagedCopy.realmSet$customerId(realmSource.realmGet$customerId());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$mobile(realmSource.realmGet$mobile());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("AnonymousCustomer = proxy[");
        stringBuilder.append("{globalId:");
        stringBuilder.append(realmGet$globalId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{customerId:");
        stringBuilder.append(realmGet$customerId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mobile:");
        stringBuilder.append(realmGet$mobile() != null ? realmGet$mobile() : "null");
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
        com_terminalbd_www_model_AnonymousCustomerRealmProxy aAnonymousCustomer = (com_terminalbd_www_model_AnonymousCustomerRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAnonymousCustomer.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAnonymousCustomer.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAnonymousCustomer.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
