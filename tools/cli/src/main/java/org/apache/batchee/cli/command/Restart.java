/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.batchee.cli.command;

import io.airlift.airline.Command;
import io.airlift.airline.Option;

import javax.batch.operations.JobOperator;

@Command(name = "restart", description = "restart a batch")
public class Restart extends StartableCommand {
    @Option(name = "-id", description = "id of the failed batch", required = true)
    private long id;

    @Override
    protected long doStart(final JobOperator operator) {
        final long nid = operator.restart(id, toProperties(properties));
        info("Batch " + nid + " restarted with id #" + nid);
        return nid;
    }
}
