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
package org.apache.batchee.test;

import javax.batch.runtime.JobExecution;
import java.util.Properties;

/**
 * A helper class test oriented.
 */
public class JobLauncher {
    private static final SynchronousJobOperator SYNCHRONOUS_JOB_OPERATOR = new SynchronousJobOperator();

    private final String name;

    public JobLauncher(final String name) {
        this.name = name;
    }

    public JobExecution start(final Properties properties) {
        final long id = SYNCHRONOUS_JOB_OPERATOR.start(name, properties);
        return SYNCHRONOUS_JOB_OPERATOR.getJobExecution(id);
    }

    public static JobExecution start(final String name, final Properties properties) {
        final long id = SYNCHRONOUS_JOB_OPERATOR.start(name, properties);
        return SYNCHRONOUS_JOB_OPERATOR.getJobExecution(id);
    }

    public JobExecution restart(final long id, final Properties properties) {
        final long newId = SYNCHRONOUS_JOB_OPERATOR.restart(id, properties);
        return SYNCHRONOUS_JOB_OPERATOR.getJobExecution(newId);
    }
}
