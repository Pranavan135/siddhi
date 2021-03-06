/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.siddhi.core.executor.condition;

import org.wso2.siddhi.core.event.ComplexEvent;
import org.wso2.siddhi.core.executor.ExpressionExecutor;
import org.wso2.siddhi.core.table.EventTable;
import org.wso2.siddhi.core.util.collection.operator.Finder;

public class InConditionExpressionExecutor extends ConditionExpressionExecutor {

    private EventTable eventTable;
    private final Finder finder;


    public InConditionExpressionExecutor(EventTable eventTable, Finder finder) {

        this.eventTable = eventTable;
        this.finder = finder;
    }

    public Boolean execute(ComplexEvent event) {
        return eventTable.contains(event, finder);
    }

    @Override
    public ExpressionExecutor cloneExecutor(String key) {
        return new InConditionExpressionExecutor(eventTable, finder.cloneFinder());
    }


}
