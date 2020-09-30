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
package com.kinvey.android

import android.content.Context

import com.google.api.client.util.Key

/**
 * Standard Kinvey specific headers are added to all requests.
 * @author m0rganic
 * @since 2.0
 */
class KinveyHeaders(context: Context?) : com.kinvey.java.core.KinveyHeaders() {

    @Key("x-kinvey-device-information")
    private val deviceInformation: String

    @Key("x-kinvey-device-info")
    private val deviceInfo: String

    init {
        val uuidFactory = UuidFactory(context)
        deviceInformation = uuidFactory.getDeviceInfoHeader(context)
        deviceInfo = uuidFactory.getDeviceInfoHeader(VERSION)
    }

}
