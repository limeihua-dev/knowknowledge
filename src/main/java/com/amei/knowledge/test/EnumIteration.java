package com.amei.knowledge.test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 3, time = 3)
@Measurement(iterations = 5, time = 3)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class EnumIteration {
    enum FourteenEnum {
        a,b,c,d,e,f,g,h,i,j,k,l,m,n;

        static final FourteenEnum[] VALUES;
        static {
            VALUES = values();
        }
    }

    @Benchmark
    public void valuesEnum(Blackhole bh) {
        for (FourteenEnum value : FourteenEnum.values()) {
            bh.consume(value.ordinal());
        }
    }

    @Benchmark
    public void enumSetEnum(Blackhole bh) {
        for (FourteenEnum value : EnumSet.allOf(FourteenEnum.class)) {
            bh.consume(value.ordinal());
        }
    }

    @Benchmark
    public void cacheEnums(Blackhole bh) {
        for (FourteenEnum value : FourteenEnum.VALUES) {
            bh.consume(value.ordinal());
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(EnumIteration.class.getSimpleName())
//                .forks(1)
//                .warmupIterations(2)
//                .measurementIterations(2)
                .build();

        new Runner(opt).run();
    }
}
