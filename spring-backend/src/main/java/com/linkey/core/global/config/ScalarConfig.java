package com.linkey.core.global.config;

import graphql.scalars.ExtendedScalars;
import graphql.scalars.datetime.DateScalar;
import graphql.scalars.datetime.DateTimeScalar;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class ScalarConfig implements RuntimeWiringConfigurer {

    @Override
    public void configure(RuntimeWiring.Builder builder) {
        builder.scalar(DateScalar.INSTANCE);            // Date Scalar 등록
        builder.scalar(DateTimeScalar.INSTANCE);        // DateTime Scalar 등록
        builder.scalar(ExtendedScalars.GraphQLLong);    // Long Scalar 등록
    }
}