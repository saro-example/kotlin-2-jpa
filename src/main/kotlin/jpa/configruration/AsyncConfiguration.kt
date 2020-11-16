package jpa.configruration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@Configuration
@EnableAsync
class AsyncConfiguration {

    @Bean
    fun taskScheduler(): Executor = Executors.newScheduledThreadPool(20)

}
