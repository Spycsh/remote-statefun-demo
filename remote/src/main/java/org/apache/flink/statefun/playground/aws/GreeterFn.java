/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.flink.statefun.playground.aws;

import java.util.concurrent.CompletableFuture;
import org.apache.flink.statefun.sdk.java.Context;
import org.apache.flink.statefun.sdk.java.StatefulFunction;
import org.apache.flink.statefun.sdk.java.StatefulFunctionSpec;
import org.apache.flink.statefun.sdk.java.TypeName;
import org.apache.flink.statefun.sdk.java.message.Message;

public final class GreeterFn implements StatefulFunction {

  static final TypeName TYPENAME = TypeName.typeNameOf("aws.lambda.example", "greeter");
  static final StatefulFunctionSpec SPEC =
      StatefulFunctionSpec.builder(TYPENAME).withSupplier(GreeterFn::new).build();

  @Override
  public CompletableFuture<Void> apply(Context context, Message message) {
    System.out.println(message);
    System.out.println(message.valueTypeName());
    System.out.println(message.rawValue());
    System.out.println("xxx");
    Query q = message.as(Types.QUERY);
    System.out.println(
        "Welcome, qid: "
            + q.getQueryId()
            + ", uid: "
            + q.getUserId()
            + ", content: "
            + q.getContent()
            + "!");
    return context.done();
  }
}
