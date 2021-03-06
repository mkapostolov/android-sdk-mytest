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

package com.kinvey.java.core

/**
 * @author edwardf
 */
interface KinveyCancellableCallback<T> : KinveyClientCallback<T> {

    /**
     * Have this method return true if the pending request should be cancelled.
     * This return value of this method will be checked regularly while execution occurs, and before the callback is made.
     *
     *
     * If a request has already been sent over the network, having this method return true will only result in callbacks being ignored.
     *
     *
     * Once a request has been sent over the network this functionality will ONLY have a client-side effect.
     *
     *
     * @return true if request should be cancelled, false if it should not
     */
    var isCancelled: Boolean

    /**
     * Called on the UI thread after a request has been cancelled.
     *
     *
     * Depending on the reason for cancellation, this method can either do nothing, or update the UI.
     *
     */
    fun onCancelled()
}
