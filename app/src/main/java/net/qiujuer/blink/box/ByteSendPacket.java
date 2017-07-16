/*
 * Copyright (C) 2014 Qiujuer <qiujuer@live.cn>
 * WebSite http://www.qiujuer.net
 * Created 04/16/2015
 * Changed 04/19/2015
 * Version 1.0.0
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.qiujuer.blink.box;

import net.qiujuer.blink.core.PacketType;
import net.qiujuer.blink.core.listener.SendListener;

import java.io.ByteArrayInputStream;

/**
 * Bytes send class
 */
public class ByteSendPacket extends BaseSendPacket<byte[]> {
    public ByteSendPacket(byte[] entity) {
        this(entity, null);
    }

    public ByteSendPacket(byte[] entity, SendListener listener) {
        super(entity, PacketType.BYTES, listener);
        mLength = mEntity.length;
    }

    @Override
    public boolean startPacket() {
        try {
            mStream = new ByteArrayInputStream(mEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void endPacket() {
        closeStream();
    }
}
