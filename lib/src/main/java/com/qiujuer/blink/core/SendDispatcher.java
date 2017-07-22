package com.qiujuer.blink.core;

import com.qiujuer.blink.kit.Disposable;

/**
 * Blink send dispatcher to process packet
 */
public interface SendDispatcher extends Disposable {
    void send(SendPacket packet);

    void cancel(SendPacket packet);
}
