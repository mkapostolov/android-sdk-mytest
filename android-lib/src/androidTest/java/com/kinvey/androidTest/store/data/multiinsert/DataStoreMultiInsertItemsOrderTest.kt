package com.kinvey.androidTest.store.data.multiinsert

import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import com.kinvey.android.store.DataStore
import com.kinvey.androidTest.model.Person
import com.kinvey.java.store.StoreType

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue

@RunWith(AndroidJUnit4::class)
@SmallTest
class DataStoreMultiInsertItemsOrderTest : BaseDataStoreMultiInsertTest() {

    @Test
    @Throws(InterruptedException::class)
    fun testSaveListCheckItemsOrderNetwork() {
        testSaveListCheckItemsOrder(StoreType.NETWORK)
    }

    @Test
    @Throws(InterruptedException::class)
    fun testSaveListCheckItemsOrderSync() {
        testSaveListCheckItemsOrder(StoreType.SYNC)
    }

    @Test
    @Throws(InterruptedException::class)
    fun testSaveListCheckItemsOrderAuto() {
        testSaveListCheckItemsOrder(StoreType.AUTO)
    }

    private fun testSaveListCheckItemsOrder(storeType: StoreType) {

        val personList = createCombineList()

        val store = DataStore.collection(MULTI_INSERT_COLLECTION, Person::class.java, storeType, client)
        clearBackend(store)
        client.syncManager.clear(MULTI_INSERT_COLLECTION)

        val saveCallback = saveList(store, personList)

        assertNull(saveCallback.error)
        assertNotNull(saveCallback.result)
        assertTrue(checkPersonListIfSameOrder(personList, saveCallback.result))

        //  val findCallback = find(store, LONG_TIMEOUT)
        //  assertNotNull(findCallback.result)
        //
        //  assertTrue(checkPersonIfSameObjects(personList, findCallback.result?.result!!))
    }
}
