package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(20);
        modelClasses.add(com.terminalbd.www.model.AnonymousCustomer.class);
        modelClasses.add(com.terminalbd.www.model.BankAccount.class);
        modelClasses.add(com.terminalbd.www.model.Category.class);
        modelClasses.add(com.terminalbd.www.model.DIMSItem.class);
        modelClasses.add(com.terminalbd.www.model.ExpenseCategory.class);
        modelClasses.add(com.terminalbd.www.model.ExpenseItem.class);
        modelClasses.add(com.terminalbd.www.model.MobileAccount.class);
        modelClasses.add(com.terminalbd.www.model.PurchaseHistory.class);
        modelClasses.add(com.terminalbd.www.model.PurchaseItem.class);
        modelClasses.add(com.terminalbd.www.model.PurchaseItemHistory.class);
        modelClasses.add(com.terminalbd.www.model.SaleItem.class);
        modelClasses.add(com.terminalbd.www.model.SalesHistory.class);
        modelClasses.add(com.terminalbd.www.model.SalesItemHistory.class);
        modelClasses.add(com.terminalbd.www.model.Setup.class);
        modelClasses.add(com.terminalbd.www.model.StockItem.class);
        modelClasses.add(com.terminalbd.www.model.SystemUser.class);
        modelClasses.add(com.terminalbd.www.model.TokenNo.class);
        modelClasses.add(com.terminalbd.www.model.TransactionMethod.class);
        modelClasses.add(com.terminalbd.www.model.Vendor.class);
        modelClasses.add(com.terminalbd.www.network.PaymentCards.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(20);
        infoMap.put(com.terminalbd.www.model.AnonymousCustomer.class, io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.BankAccount.class, io.realm.com_terminalbd_www_model_BankAccountRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.Category.class, io.realm.com_terminalbd_www_model_CategoryRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.DIMSItem.class, io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.ExpenseCategory.class, io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.ExpenseItem.class, io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.MobileAccount.class, io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.PurchaseHistory.class, io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.PurchaseItem.class, io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.PurchaseItemHistory.class, io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.SaleItem.class, io.realm.com_terminalbd_www_model_SaleItemRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.SalesHistory.class, io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.SalesItemHistory.class, io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.Setup.class, io.realm.com_terminalbd_www_model_SetupRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.StockItem.class, io.realm.com_terminalbd_www_model_StockItemRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.SystemUser.class, io.realm.com_terminalbd_www_model_SystemUserRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.TokenNo.class, io.realm.com_terminalbd_www_model_TokenNoRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.TransactionMethod.class, io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.model.Vendor.class, io.realm.com_terminalbd_www_model_VendorRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.terminalbd.www.network.PaymentCards.class, io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
            return io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
            return io.realm.com_terminalbd_www_model_BankAccountRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.Category.class)) {
            return io.realm.com_terminalbd_www_model_CategoryRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
            return io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
            return io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
            return io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
            return io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
            return io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
            return io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
            return io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
            return io.realm.com_terminalbd_www_model_SaleItemRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
            return io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
            return io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
            return io.realm.com_terminalbd_www_model_SetupRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
            return io.realm.com_terminalbd_www_model_StockItemRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
            return io.realm.com_terminalbd_www_model_SystemUserRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
            return io.realm.com_terminalbd_www_model_TokenNoRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
            return io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
            return io.realm.com_terminalbd_www_model_VendorRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
            return io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
            return "AnonymousCustomer";
        }
        if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
            return "BankAccount";
        }
        if (clazz.equals(com.terminalbd.www.model.Category.class)) {
            return "Category";
        }
        if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
            return "DIMSItem";
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
            return "ExpenseCategory";
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
            return "ExpenseItem";
        }
        if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
            return "MobileAccount";
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
            return "PurchaseHistory";
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
            return "PurchaseItem";
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
            return "PurchaseItemHistory";
        }
        if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
            return "SaleItem";
        }
        if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
            return "SalesHistory";
        }
        if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
            return "SalesItemHistory";
        }
        if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
            return "Setup";
        }
        if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
            return "StockItem";
        }
        if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
            return "SystemUser";
        }
        if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
            return "TokenNo";
        }
        if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
            return "TransactionMethod";
        }
        if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
            return "Vendor";
        }
        if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
            return "PaymentCards";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_BankAccountRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.Category.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_CategoryRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_DIMSItemRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_MobileAccountRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_SaleItemRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_SetupRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_StockItemRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_SystemUserRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_TokenNoRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_model_VendorRealmProxy());
            }
            if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
                return clazz.cast(new io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
            com_terminalbd_www_model_AnonymousCustomerRealmProxy.AnonymousCustomerColumnInfo columnInfo = (com_terminalbd_www_model_AnonymousCustomerRealmProxy.AnonymousCustomerColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.AnonymousCustomer.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.AnonymousCustomer) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
            com_terminalbd_www_model_BankAccountRealmProxy.BankAccountColumnInfo columnInfo = (com_terminalbd_www_model_BankAccountRealmProxy.BankAccountColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.BankAccount.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_BankAccountRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.BankAccount) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.Category.class)) {
            com_terminalbd_www_model_CategoryRealmProxy.CategoryColumnInfo columnInfo = (com_terminalbd_www_model_CategoryRealmProxy.CategoryColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.Category.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_CategoryRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.Category) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
            com_terminalbd_www_model_DIMSItemRealmProxy.DIMSItemColumnInfo columnInfo = (com_terminalbd_www_model_DIMSItemRealmProxy.DIMSItemColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.DIMSItem.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.DIMSItem) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
            com_terminalbd_www_model_ExpenseCategoryRealmProxy.ExpenseCategoryColumnInfo columnInfo = (com_terminalbd_www_model_ExpenseCategoryRealmProxy.ExpenseCategoryColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.ExpenseCategory.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.ExpenseCategory) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
            com_terminalbd_www_model_ExpenseItemRealmProxy.ExpenseItemColumnInfo columnInfo = (com_terminalbd_www_model_ExpenseItemRealmProxy.ExpenseItemColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.ExpenseItem.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.ExpenseItem) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
            com_terminalbd_www_model_MobileAccountRealmProxy.MobileAccountColumnInfo columnInfo = (com_terminalbd_www_model_MobileAccountRealmProxy.MobileAccountColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.MobileAccount.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.MobileAccount) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
            com_terminalbd_www_model_PurchaseHistoryRealmProxy.PurchaseHistoryColumnInfo columnInfo = (com_terminalbd_www_model_PurchaseHistoryRealmProxy.PurchaseHistoryColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.PurchaseHistory.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.PurchaseHistory) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
            com_terminalbd_www_model_PurchaseItemRealmProxy.PurchaseItemColumnInfo columnInfo = (com_terminalbd_www_model_PurchaseItemRealmProxy.PurchaseItemColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.PurchaseItem.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.PurchaseItem) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
            com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.PurchaseItemHistoryColumnInfo columnInfo = (com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.PurchaseItemHistoryColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.PurchaseItemHistory.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.PurchaseItemHistory) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
            com_terminalbd_www_model_SaleItemRealmProxy.SaleItemColumnInfo columnInfo = (com_terminalbd_www_model_SaleItemRealmProxy.SaleItemColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.SaleItem.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_SaleItemRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.SaleItem) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
            com_terminalbd_www_model_SalesHistoryRealmProxy.SalesHistoryColumnInfo columnInfo = (com_terminalbd_www_model_SalesHistoryRealmProxy.SalesHistoryColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.SalesHistory.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.SalesHistory) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
            com_terminalbd_www_model_SalesItemHistoryRealmProxy.SalesItemHistoryColumnInfo columnInfo = (com_terminalbd_www_model_SalesItemHistoryRealmProxy.SalesItemHistoryColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.SalesItemHistory.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.SalesItemHistory) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
            com_terminalbd_www_model_SetupRealmProxy.SetupColumnInfo columnInfo = (com_terminalbd_www_model_SetupRealmProxy.SetupColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.Setup.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_SetupRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.Setup) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
            com_terminalbd_www_model_StockItemRealmProxy.StockItemColumnInfo columnInfo = (com_terminalbd_www_model_StockItemRealmProxy.StockItemColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.StockItem.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_StockItemRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.StockItem) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
            com_terminalbd_www_model_SystemUserRealmProxy.SystemUserColumnInfo columnInfo = (com_terminalbd_www_model_SystemUserRealmProxy.SystemUserColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.SystemUser.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_SystemUserRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.SystemUser) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
            com_terminalbd_www_model_TokenNoRealmProxy.TokenNoColumnInfo columnInfo = (com_terminalbd_www_model_TokenNoRealmProxy.TokenNoColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.TokenNo.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_TokenNoRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.TokenNo) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
            com_terminalbd_www_model_TransactionMethodRealmProxy.TransactionMethodColumnInfo columnInfo = (com_terminalbd_www_model_TransactionMethodRealmProxy.TransactionMethodColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.TransactionMethod.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.TransactionMethod) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
            com_terminalbd_www_model_VendorRealmProxy.VendorColumnInfo columnInfo = (com_terminalbd_www_model_VendorRealmProxy.VendorColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.model.Vendor.class);
            return clazz.cast(io.realm.com_terminalbd_www_model_VendorRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.model.Vendor) obj, update, cache, flags));
        }
        if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
            com_terminalbd_www_network_PaymentCardsRealmProxy.PaymentCardsColumnInfo columnInfo = (com_terminalbd_www_network_PaymentCardsRealmProxy.PaymentCardsColumnInfo) realm.getSchema().getColumnInfo(com.terminalbd.www.network.PaymentCards.class);
            return clazz.cast(io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.copyOrUpdate(realm, columnInfo, (com.terminalbd.www.network.PaymentCards) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
            io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.insert(realm, (com.terminalbd.www.model.AnonymousCustomer) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
            io.realm.com_terminalbd_www_model_BankAccountRealmProxy.insert(realm, (com.terminalbd.www.model.BankAccount) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.Category.class)) {
            io.realm.com_terminalbd_www_model_CategoryRealmProxy.insert(realm, (com.terminalbd.www.model.Category) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
            io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.insert(realm, (com.terminalbd.www.model.DIMSItem) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
            io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.insert(realm, (com.terminalbd.www.model.ExpenseCategory) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
            io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.insert(realm, (com.terminalbd.www.model.ExpenseItem) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
            io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.insert(realm, (com.terminalbd.www.model.MobileAccount) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
            io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.insert(realm, (com.terminalbd.www.model.PurchaseHistory) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
            io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.insert(realm, (com.terminalbd.www.model.PurchaseItem) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
            io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.insert(realm, (com.terminalbd.www.model.PurchaseItemHistory) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
            io.realm.com_terminalbd_www_model_SaleItemRealmProxy.insert(realm, (com.terminalbd.www.model.SaleItem) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
            io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.insert(realm, (com.terminalbd.www.model.SalesHistory) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
            io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.insert(realm, (com.terminalbd.www.model.SalesItemHistory) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
            io.realm.com_terminalbd_www_model_SetupRealmProxy.insert(realm, (com.terminalbd.www.model.Setup) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
            io.realm.com_terminalbd_www_model_StockItemRealmProxy.insert(realm, (com.terminalbd.www.model.StockItem) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
            io.realm.com_terminalbd_www_model_SystemUserRealmProxy.insert(realm, (com.terminalbd.www.model.SystemUser) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
            io.realm.com_terminalbd_www_model_TokenNoRealmProxy.insert(realm, (com.terminalbd.www.model.TokenNo) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
            io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.insert(realm, (com.terminalbd.www.model.TransactionMethod) object, cache);
        } else if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
            io.realm.com_terminalbd_www_model_VendorRealmProxy.insert(realm, (com.terminalbd.www.model.Vendor) object, cache);
        } else if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
            io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.insert(realm, (com.terminalbd.www.network.PaymentCards) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
                io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.insert(realm, (com.terminalbd.www.model.AnonymousCustomer) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
                io.realm.com_terminalbd_www_model_BankAccountRealmProxy.insert(realm, (com.terminalbd.www.model.BankAccount) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.Category.class)) {
                io.realm.com_terminalbd_www_model_CategoryRealmProxy.insert(realm, (com.terminalbd.www.model.Category) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
                io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.insert(realm, (com.terminalbd.www.model.DIMSItem) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
                io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.insert(realm, (com.terminalbd.www.model.ExpenseCategory) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
                io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.insert(realm, (com.terminalbd.www.model.ExpenseItem) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
                io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.insert(realm, (com.terminalbd.www.model.MobileAccount) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
                io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.insert(realm, (com.terminalbd.www.model.PurchaseHistory) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
                io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.insert(realm, (com.terminalbd.www.model.PurchaseItem) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
                io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.insert(realm, (com.terminalbd.www.model.PurchaseItemHistory) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
                io.realm.com_terminalbd_www_model_SaleItemRealmProxy.insert(realm, (com.terminalbd.www.model.SaleItem) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
                io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.insert(realm, (com.terminalbd.www.model.SalesHistory) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
                io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.insert(realm, (com.terminalbd.www.model.SalesItemHistory) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
                io.realm.com_terminalbd_www_model_SetupRealmProxy.insert(realm, (com.terminalbd.www.model.Setup) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
                io.realm.com_terminalbd_www_model_StockItemRealmProxy.insert(realm, (com.terminalbd.www.model.StockItem) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
                io.realm.com_terminalbd_www_model_SystemUserRealmProxy.insert(realm, (com.terminalbd.www.model.SystemUser) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
                io.realm.com_terminalbd_www_model_TokenNoRealmProxy.insert(realm, (com.terminalbd.www.model.TokenNo) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
                io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.insert(realm, (com.terminalbd.www.model.TransactionMethod) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
                io.realm.com_terminalbd_www_model_VendorRealmProxy.insert(realm, (com.terminalbd.www.model.Vendor) object, cache);
            } else if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
                io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.insert(realm, (com.terminalbd.www.network.PaymentCards) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
                    io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
                    io.realm.com_terminalbd_www_model_BankAccountRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.Category.class)) {
                    io.realm.com_terminalbd_www_model_CategoryRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
                    io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
                    io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
                    io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
                    io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
                    io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
                    io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
                    io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
                    io.realm.com_terminalbd_www_model_SaleItemRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
                    io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
                    io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
                    io.realm.com_terminalbd_www_model_SetupRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
                    io.realm.com_terminalbd_www_model_StockItemRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
                    io.realm.com_terminalbd_www_model_SystemUserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
                    io.realm.com_terminalbd_www_model_TokenNoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
                    io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
                    io.realm.com_terminalbd_www_model_VendorRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
                    io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
            io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.AnonymousCustomer) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
            io.realm.com_terminalbd_www_model_BankAccountRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.BankAccount) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.Category.class)) {
            io.realm.com_terminalbd_www_model_CategoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.Category) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
            io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.DIMSItem) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
            io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.ExpenseCategory) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
            io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.ExpenseItem) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
            io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.MobileAccount) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
            io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.PurchaseHistory) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
            io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.PurchaseItem) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
            io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.PurchaseItemHistory) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
            io.realm.com_terminalbd_www_model_SaleItemRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.SaleItem) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
            io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.SalesHistory) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
            io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.SalesItemHistory) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
            io.realm.com_terminalbd_www_model_SetupRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.Setup) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
            io.realm.com_terminalbd_www_model_StockItemRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.StockItem) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
            io.realm.com_terminalbd_www_model_SystemUserRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.SystemUser) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
            io.realm.com_terminalbd_www_model_TokenNoRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.TokenNo) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
            io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.TransactionMethod) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
            io.realm.com_terminalbd_www_model_VendorRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.Vendor) obj, cache);
        } else if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
            io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.network.PaymentCards) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
                io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.AnonymousCustomer) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
                io.realm.com_terminalbd_www_model_BankAccountRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.BankAccount) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.Category.class)) {
                io.realm.com_terminalbd_www_model_CategoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.Category) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
                io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.DIMSItem) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
                io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.ExpenseCategory) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
                io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.ExpenseItem) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
                io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.MobileAccount) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
                io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.PurchaseHistory) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
                io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.PurchaseItem) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
                io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.PurchaseItemHistory) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
                io.realm.com_terminalbd_www_model_SaleItemRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.SaleItem) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
                io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.SalesHistory) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
                io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.SalesItemHistory) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
                io.realm.com_terminalbd_www_model_SetupRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.Setup) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
                io.realm.com_terminalbd_www_model_StockItemRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.StockItem) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
                io.realm.com_terminalbd_www_model_SystemUserRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.SystemUser) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
                io.realm.com_terminalbd_www_model_TokenNoRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.TokenNo) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
                io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.TransactionMethod) object, cache);
            } else if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
                io.realm.com_terminalbd_www_model_VendorRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.model.Vendor) object, cache);
            } else if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
                io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.insertOrUpdate(realm, (com.terminalbd.www.network.PaymentCards) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
                    io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
                    io.realm.com_terminalbd_www_model_BankAccountRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.Category.class)) {
                    io.realm.com_terminalbd_www_model_CategoryRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
                    io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
                    io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
                    io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
                    io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
                    io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
                    io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
                    io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
                    io.realm.com_terminalbd_www_model_SaleItemRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
                    io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
                    io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
                    io.realm.com_terminalbd_www_model_SetupRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
                    io.realm.com_terminalbd_www_model_StockItemRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
                    io.realm.com_terminalbd_www_model_SystemUserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
                    io.realm.com_terminalbd_www_model_TokenNoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
                    io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
                    io.realm.com_terminalbd_www_model_VendorRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
                    io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_BankAccountRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.Category.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_CategoryRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SaleItemRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SetupRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_StockItemRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SystemUserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_TokenNoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_VendorRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_BankAccountRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.Category.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_CategoryRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SaleItemRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SetupRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_StockItemRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SystemUserRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_TokenNoRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_VendorRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.terminalbd.www.model.AnonymousCustomer.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_AnonymousCustomerRealmProxy.createDetachedCopy((com.terminalbd.www.model.AnonymousCustomer) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.BankAccount.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_BankAccountRealmProxy.createDetachedCopy((com.terminalbd.www.model.BankAccount) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.Category.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_CategoryRealmProxy.createDetachedCopy((com.terminalbd.www.model.Category) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.DIMSItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_DIMSItemRealmProxy.createDetachedCopy((com.terminalbd.www.model.DIMSItem) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseCategory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_ExpenseCategoryRealmProxy.createDetachedCopy((com.terminalbd.www.model.ExpenseCategory) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.ExpenseItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_ExpenseItemRealmProxy.createDetachedCopy((com.terminalbd.www.model.ExpenseItem) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.MobileAccount.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_MobileAccountRealmProxy.createDetachedCopy((com.terminalbd.www.model.MobileAccount) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseHistoryRealmProxy.createDetachedCopy((com.terminalbd.www.model.PurchaseHistory) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseItemRealmProxy.createDetachedCopy((com.terminalbd.www.model.PurchaseItem) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.PurchaseItemHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_PurchaseItemHistoryRealmProxy.createDetachedCopy((com.terminalbd.www.model.PurchaseItemHistory) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.SaleItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SaleItemRealmProxy.createDetachedCopy((com.terminalbd.www.model.SaleItem) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.SalesHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SalesHistoryRealmProxy.createDetachedCopy((com.terminalbd.www.model.SalesHistory) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.SalesItemHistory.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SalesItemHistoryRealmProxy.createDetachedCopy((com.terminalbd.www.model.SalesItemHistory) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.Setup.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SetupRealmProxy.createDetachedCopy((com.terminalbd.www.model.Setup) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.StockItem.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_StockItemRealmProxy.createDetachedCopy((com.terminalbd.www.model.StockItem) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.SystemUser.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_SystemUserRealmProxy.createDetachedCopy((com.terminalbd.www.model.SystemUser) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.TokenNo.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_TokenNoRealmProxy.createDetachedCopy((com.terminalbd.www.model.TokenNo) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.TransactionMethod.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_TransactionMethodRealmProxy.createDetachedCopy((com.terminalbd.www.model.TransactionMethod) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.model.Vendor.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_model_VendorRealmProxy.createDetachedCopy((com.terminalbd.www.model.Vendor) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.terminalbd.www.network.PaymentCards.class)) {
            return clazz.cast(io.realm.com_terminalbd_www_network_PaymentCardsRealmProxy.createDetachedCopy((com.terminalbd.www.network.PaymentCards) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
