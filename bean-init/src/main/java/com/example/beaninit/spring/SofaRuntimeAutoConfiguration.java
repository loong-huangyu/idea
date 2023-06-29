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
package com.example.beaninit.spring;

import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.Set;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuanbei 18/3/17
 */
@Configuration(proxyBeanMethods = false)
public class SofaRuntimeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AsyncTaskExecutionListener asyncTaskExecutionListener() {
        return new AsyncTaskExecutionListener();
    }

    @Bean
    @ConditionalOnMissingBean
    public static AsyncProxyBeanPostProcessor asyncProxyBeanPostProcessor() {
        return new AsyncProxyBeanPostProcessor();
    }

    @Bean
    @ConditionalOnMissingBean
    public static AsyncInitBeanFactoryPostProcessor asyncInitBeanFactoryPostProcessor() {
        return new AsyncInitBeanFactoryPostProcessor();
    }

    public static <T> Set<T> getClassesByServiceLoader(Class<T> clazz) {
        ServiceLoader<T> serviceLoader = ServiceLoader.load(clazz);

        Set<T> result = new HashSet<>();
        for (T t : serviceLoader) {
            result.add(t);
        }
        return result;
    }

}
