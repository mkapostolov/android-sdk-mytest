/*
 *  Copyright (c) 2016, Kinvey, Inc. All rights reserved.
 *
 * This software is licensed to you under the Kinvey terms of service located at
 * http://www.kinvey.com/terms-of-use. By downloading, accessing and/or using this
 * software, you hereby accept such terms of service  (and any agreement referenced
 * therein) and agree that you have read, understand and agree to be bound by such
 * terms of service and are of legal age to agree to such terms with Kinvey.
 *
 * This software contains valuable confidential and proprietary information of
 * KINVEY, INC and is subject to applicable licensing agreements.
 * Unauthorized reproduction, transmission or distribution of this file and its
 * contents is a violation of applicable laws.
 *
 */

package com.kinvey.java.store

import com.kinvey.java.AbstractClient
import com.kinvey.java.linkedResources.LinkedGenericJson
import com.kinvey.java.network.LinkedNetworkManager

class LinkedBaseDataStore<T : LinkedGenericJson>
/**
 * Constructor for creating LinkedBaseDataStore for given collection that will be mapped to itemType class
 *
 * @param client     Kinvey client instance to work with
 * @param collection collection name
 * @param itemType   class that data should be mapped to
 * @param storeType  type of storage that client want to use
 */
(client: AbstractClient<*>, collection: String, itemType: Class<T>, storeType: StoreType) : BaseDataStore<T>(client, collection, itemType, storeType, LinkedNetworkManager<T>(collection, itemType, client))
