package com.linkey.core.global.config;


import graphql.scalars.ExtendedScalars;
import graphql.scalars.datetime.DateScalar;
import graphql.scalars.datetime.DateTimeScalar;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

public class ScalarConfig implements RuntimeWiringConfigurer {

    @Override
    public void configure(RuntimeWiring.Builder builder){
        builder.scalar(DateScalar.INSTANCE);
        builder.scalar(DateTimeScalar.INSTANCE);
        builder.scalar(ExtendedScalars.GraphQLLong);
    }
}
