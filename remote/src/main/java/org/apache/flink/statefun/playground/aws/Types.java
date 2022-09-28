package org.apache.flink.statefun.playground.aws;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.statefun.sdk.java.TypeName;
import org.apache.flink.statefun.sdk.java.types.SimpleType;
import org.apache.flink.statefun.sdk.java.types.Type;

public class Types {
  private Types() {}

  private static final ObjectMapper JSON_OBJ_MAPPER = new ObjectMapper();
  private static final String TYPES_NAMESPACE = "greeter.types";

  public static final Type<Query> QUERY =
      SimpleType.simpleImmutableTypeFrom(
          TypeName.typeNameOf(TYPES_NAMESPACE, "query"),
          JSON_OBJ_MAPPER::writeValueAsBytes,
          bytes -> JSON_OBJ_MAPPER.readValue(bytes, Query.class));
}
