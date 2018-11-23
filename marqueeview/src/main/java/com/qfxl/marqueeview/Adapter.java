/*
 * Copyright (c) 2018 Frank Xu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qfxl.marqueeview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * <pre>
 *     author : qfxl
 *     e-mail : xuyonghong0822@gmail.com
 *     time   : 2018/11/22
 *     desc   : MarqueeView 适配器
 *     version: 1.0
 * </pre>
 */
public interface Adapter {
    /**
     * 获取MarqueeView ItemView
     *
     * @param position position
     * @param context  context
     * @param parent   parent
     * @return MarqueeView itemView
     */
    View getView(int position, Context context, ViewGroup parent);

    /**
     * 获取MarqueeView数量
     *
     * @return MarqueeView count
     */
    int getCount();
}
