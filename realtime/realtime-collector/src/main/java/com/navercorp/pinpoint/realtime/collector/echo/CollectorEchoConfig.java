/*
 * Copyright 2023 NAVER Corp.
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
package com.navercorp.pinpoint.realtime.collector.echo;

import com.navercorp.pinpoint.pubsub.endpoint.PubSubServer;
import com.navercorp.pinpoint.pubsub.endpoint.PubSubServerFactory;
import com.navercorp.pinpoint.realtime.RealtimePubSubServiceDescriptors;
import com.navercorp.pinpoint.realtime.collector.echo.service.CollectorEchoServiceConfig;
import com.navercorp.pinpoint.realtime.collector.echo.service.EchoService;
import com.navercorp.pinpoint.redis.pubsub.RedisPubSubConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author youngjin.kim2
 */
@Configuration
@Import({ CollectorEchoServiceConfig.class, RedisPubSubConfig.class })
public class CollectorEchoConfig {

    @Bean
    PubSubServer echoEndpointServer(
            PubSubServerFactory serverFactory,
            EchoService service
    ) {
        return serverFactory.build(service::echo, RealtimePubSubServiceDescriptors.ECHO);
    }

}
